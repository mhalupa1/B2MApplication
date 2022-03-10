package hr.b2m.mhalupa.b2mapplication.dao;

import hr.b2m.mhalupa.b2mapplication.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingDAO extends JpaRepository<Meeting, Long> {
}
