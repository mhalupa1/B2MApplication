package hr.b2m.mhalupa.b2mapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue
    private Long id;
    private Integer code;
    @Column(name = "verbose_name")
    private String verbose;
    @OneToMany(mappedBy = "invitationStatus")
    @JsonIgnore
    private List<Invitation> invitations;

    public InvitationStatus(InvitationStatusEnum statusEnum){
        this.id = (long) statusEnum.getCode();
        this.code = statusEnum.getCode();
        this.verbose = statusEnum.toString();
    }

    public InvitationStatus() {

    }
}