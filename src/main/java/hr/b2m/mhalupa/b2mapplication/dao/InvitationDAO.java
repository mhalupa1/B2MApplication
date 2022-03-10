package hr.b2m.mhalupa.b2mapplication.dao;

import hr.b2m.mhalupa.b2mapplication.model.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvitationDAO extends JpaRepository<Invitation, Long> {
}