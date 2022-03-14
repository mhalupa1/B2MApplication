package hr.b2m.mhalupa.b2mapplication.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "b2m_invitation")
public class Invitation {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name ="meeting_id", referencedColumnName = "id")
    private Meeting meeting;
    @ManyToOne
    @JoinColumn(name = "invitation_status_id", referencedColumnName = "id")
    private InvitationStatus invitationStatus;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    public Invitation(User user, Meeting meeting, InvitationStatus invitationStatus) {
        this.meeting = meeting;
        this.invitationStatus = invitationStatus;
        this.user = user;
    }

    public Invitation() {

    }
}