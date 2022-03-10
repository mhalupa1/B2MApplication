package hr.b2m.mhalupa.b2mapplication.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "b2m_user_meeting")
public class UserMeeting {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "created_meeting")
    private boolean createdMeeting;
    @ManyToOne
    @JoinColumn(name = "meeting_id", referencedColumnName = "id")
    private Meeting meeting;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
