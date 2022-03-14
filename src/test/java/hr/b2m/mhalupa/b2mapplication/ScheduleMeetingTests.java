package hr.b2m.mhalupa.b2mapplication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hr.b2m.mhalupa.b2mapplication.dao.InvitationDAO;
import hr.b2m.mhalupa.b2mapplication.dao.MeetingDAO;
import hr.b2m.mhalupa.b2mapplication.dao.UserDAO;
import hr.b2m.mhalupa.b2mapplication.enumeration.InvitationStatusEnum;
import hr.b2m.mhalupa.b2mapplication.enumeration.MeetingStatusEnum;
import hr.b2m.mhalupa.b2mapplication.model.*;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ScheduleMeetingTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private InvitationDAO invitationDAO;

    @Autowired
    private MeetingDAO meetingDAO;

    @Autowired
    private UserDAO userDAO;

    private User user1;
    private User user2;
    private Invitation inv1;
    private Invitation inv2;
    private Meeting scheduledMeeting;


    @BeforeEach
    public void setUp(){
        Meeting meeting = new Meeting();
        meeting.setName("test_meeting");
        meeting.setMeetingStatus(new MeetingStatus(MeetingStatusEnum.PROPOSED));
        user1 = userDAO.save(new User("testest1","testest1"));
        user2 = userDAO.save(new User("testest2","testest2"));
        scheduledMeeting = meetingDAO.save(meeting);
        inv1 = invitationDAO.save(new Invitation(user1,scheduledMeeting, new InvitationStatus(InvitationStatusEnum.PENDING)));
        inv2 = invitationDAO.save(new Invitation(user2,scheduledMeeting, new InvitationStatus(InvitationStatusEnum.PENDING)));
    }

    @Test
    public void sendInvitations_acceptInvitations_scheduleMeeting() throws Exception {

        mockMvc.perform(post("/acceptInvitation")
                        .contentType(MediaType.APPLICATION_JSON).content(inv1.getId().toString()))
                .andExpect(status().isOk());

        mockMvc.perform(post("/acceptInvitation")
                        .contentType(MediaType.APPLICATION_JSON).content(inv2.getId().toString()))
                .andExpect(status().isOk());

        Optional<Meeting> scheduledMeetingOpt = meetingDAO.findById(scheduledMeeting.getId());
        scheduledMeeting = scheduledMeetingOpt.get();
        assertThat(scheduledMeeting.getMeetingStatus().getCode().equals(MeetingStatusEnum.SCHEDULED.getCode())).isEqualTo(true);
    }


    @AfterEach
    public void tearDown(){
        invitationDAO.delete(inv1);
        invitationDAO.delete(inv2);
        userDAO.delete(user1);
        userDAO.delete(user2);
        meetingDAO.delete(scheduledMeeting);

    }
}
