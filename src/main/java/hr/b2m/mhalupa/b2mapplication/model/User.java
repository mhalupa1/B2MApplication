package hr.b2m.mhalupa.b2mapplication.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "b2m_user")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organization organization;
    @OneToMany(mappedBy = "user")
    private List<Invitation> invitations;
    @OneToMany(mappedBy = "user")
    private List<UserEvent> userEvents;
    @OneToMany(mappedBy = "user")
    private List<UserMeeting> userMeetings;


}
