package hr.b2m.mhalupa.b2mapplication.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "b2m_invitation")
public class Invitation {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Meeting meeting;
    @ManyToOne
    @JoinColumn(name = "invitation_status_id", referencedColumnName = "id")
    private InvitationStatus invitationStatus;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}