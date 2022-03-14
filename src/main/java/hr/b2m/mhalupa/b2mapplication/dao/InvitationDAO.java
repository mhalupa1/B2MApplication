package hr.b2m.mhalupa.b2mapplication.dao;

import hr.b2m.mhalupa.b2mapplication.model.Invitation;
import hr.b2m.mhalupa.b2mapplication.model.InvitationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface InvitationDAO extends JpaRepository<Invitation, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE b2m_invitation SET invitationStatus = :status WHERE id = :invitationId")
    void resolveInvitation(long invitationId, InvitationStatus status);

    @Query("SELECT i FROM b2m_invitation i left join i.user WHERE i.user.id = :id")
    List<Invitation> getUserInvitations(Long id);

    @Query("SELECT i FROM b2m_invitation i left join fetch i.meeting WHERE i.meeting.id = :id")
    List<Invitation> getInvitationsForMeeting(Long id);

}