package hr.b2m.mhalupa.b2mapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private List<Invitation> invitations;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<UserEvent> userEvents;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<UserMeeting> userMeetings;


    public User(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(Long id){
        this.id = id;
    }


    public User() {

    }
}
