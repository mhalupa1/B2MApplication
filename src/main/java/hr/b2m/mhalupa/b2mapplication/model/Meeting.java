package hr.b2m.mhalupa.b2mapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue
    private Long id;
    private String name;
    @Column(name = "start_time")
    private OffsetDateTime startTime;
    @Column(name = "end_time")
    private OffsetDateTime endTime;
    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;
    @ManyToOne
    @JoinColumn(name = "meeting_status_id", referencedColumnName = "id")
    private MeetingStatus meetingStatus;
    @OneToMany(mappedBy = "meeting")
    @JsonIgnore
    private List<Invitation> invitations;
    @OneToMany(mappedBy = "meeting")
    @JsonIgnore
    private List<UserMeeting> userMeetings;

}
