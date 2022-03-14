package hr.b2m.mhalupa.b2mapplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.b2m.mhalupa.b2mapplication.dao.EventDAO;
import hr.b2m.mhalupa.b2mapplication.dao.UserDAO;
import hr.b2m.mhalupa.b2mapplication.dao.UserEventDAO;
import hr.b2m.mhalupa.b2mapplication.model.Event;
import hr.b2m.mhalupa.b2mapplication.model.User;
import hr.b2m.mhalupa.b2mapplication.model.UserEvent;
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

import java.time.OffsetDateTime;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EventControllerTests {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserEventDAO userEventDAO;

    private User user;
    private Event event;
    private UserEvent userEvent;

    @BeforeEach
    public void setUp(){
    }



    @Test
    void createEventTest() throws Exception {
        OffsetDateTime startTime = OffsetDateTime.now();
        OffsetDateTime endTime = startTime.plusDays(2);
        String eventName = "testCreateEvent";
        user = userDao.save(new User("testCreateEvent", "testCreateEvent"));
        event = new Event(eventName, startTime, endTime);
        userEvent = new UserEvent(user,event);

        MvcResult result = mockMvc.perform(post("/createEvent")
                        .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(userEvent)))
                .andExpect(status().isOk())
                .andReturn();

        String newEventStr = result.getResponse().getContentAsString();
        userEvent = objectMapper.readValue(newEventStr, UserEvent.class);
        assertThat(userEvent.getEvent().getName().equals(eventName) && userEvent.getEvent().getStartTime().isEqual(event.getStartTime())
                            && userEvent.getEvent().getEndTime().isEqual(event.getEndTime())).isEqualTo(true);
    }

    @AfterEach
    public void tearDown(){
        userEventDAO.delete(userEvent);
        userDao.delete(user);
        eventDAO.delete(event);
    }
}
