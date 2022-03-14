package hr.b2m.mhalupa.b2mapplication.service;

import hr.b2m.mhalupa.b2mapplication.dao.MeetingDAO;
import hr.b2m.mhalupa.b2mapplication.enumeration.MeetingStatusEnum;
import hr.b2m.mhalupa.b2mapplication.model.Meeting;
import hr.b2m.mhalupa.b2mapplication.model.MeetingStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingService {

    @Autowired
    MeetingDAO dao;

    public Meeting createMeeting(Meeting meeting){
        MeetingStatus meetingStatus = new MeetingStatus(MeetingStatusEnum.PROPOSED);
        meeting.setMeetingStatus(meetingStatus);
        return dao.save(meeting);
    }

    public void scheduleMeeting(Long meetingId){
        MeetingStatus meetingStatus = new MeetingStatus(MeetingStatusEnum.SCHEDULED);
        dao.scheduleMeeting(meetingId, meetingStatus);
    }

}
