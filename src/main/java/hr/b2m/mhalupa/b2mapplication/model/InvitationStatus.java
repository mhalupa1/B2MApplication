package hr.b2m.mhalupa.b2mapplication.model;

import hr.b2m.mhalupa.b2mapplication.enumeration.InvitationStatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "b2m_invitation_status")
public class InvitationStatus {

    @Id
    private Long id;
    @Enumerated(EnumType.ORDINAL)
    private InvitationStatusEnum code;
    @Enumerated(EnumType.STRING)
    @Column(name = "verbose_name")
    private InvitationStatusEnum verbose;
    @OneToMany(mappedBy = "invitationStatus")
    private List<Invitation> invitations;

}