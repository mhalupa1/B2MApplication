package hr.b2m.mhalupa.b2mapplication.dao;

import hr.b2m.mhalupa.b2mapplication.model.User;
import hr.b2m.mhalupa.b2mapplication.model.UserMeeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMeetingDAO extends JpaRepository<UserMeeting, Long> {

    @Query(value = "SELECT um FROM b2m_user_meeting um WHERE um.user = :user")
    List<UserMeeting> getUserMeetings(User user);
}
