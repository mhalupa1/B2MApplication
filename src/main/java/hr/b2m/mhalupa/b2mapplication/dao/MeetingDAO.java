package hr.b2m.mhalupa.b2mapplication.dao;

import hr.b2m.mhalupa.b2mapplication.model.Meeting;
import hr.b2m.mhalupa.b2mapplication.model.MeetingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MeetingDAO extends JpaRepository<Meeting, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE b2m_meeting SET meetingStatus = :meetingStatus WHERE id = :meetingId")
    void scheduleMeeting(Long meetingId, MeetingStatus meetingStatus);

}
