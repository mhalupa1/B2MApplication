package hr.b2m.mhalupa.b2mapplication.service;

import hr.b2m.mhalupa.b2mapplication.dao.UserMeetingDAO;
import hr.b2m.mhalupa.b2mapplication.model.Meeting;
import hr.b2m.mhalupa.b2mapplication.model.User;
import hr.b2m.mhalupa.b2mapplication.model.UserMeeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UserMeetingService {

    @Autowired
    UserMeetingDAO dao;

    @Autowired
    MeetingService meetingService;

    public List<UserMeeting> getUserMeetings(@RequestParam Long id){
        User user = new User(id);
        return dao.getUserMeetings(user);
    }

    public UserMeeting createMeeting(UserMeeting userMeeting){
        Meeting meeting = meetingService.createMeeting(userMeeting.getMeeting());
        userMeeting.setMeeting(meeting);
        userMeeting.setCreatedMeeting(true);
        return dao.save(userMeeting);
    }
}
