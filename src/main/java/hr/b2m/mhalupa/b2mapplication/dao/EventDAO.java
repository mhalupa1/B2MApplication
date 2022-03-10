package hr.b2m.mhalupa.b2mapplication.dao;

import hr.b2m.mhalupa.b2mapplication.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventDAO extends JpaRepository<Event, Long> {
}
