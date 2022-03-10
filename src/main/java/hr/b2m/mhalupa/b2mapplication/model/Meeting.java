package hr.b2m.mhalupa.b2mapplication.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@Entity(name = "b2m_meeting")
public class Meeting {

    @Id
    private Long id;
    private String name;
    @Column(name = "start_time")
    private OffsetDateTime startTime;
    @Column(name = "end_time")
    private OffsetDateTime endTime;
    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;
    @OneToMany(mappedBy = "meeting")
    private List<Invitation> invitations;
    @OneToMany(mappedBy = "meeting")
    private List<UserMeeting> userMeetings;
}
