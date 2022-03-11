package hr.b2m.mhalupa.b2mapplication.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@Entity(name = "b2m_event")
public class Event {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(name = "start_time")
    private OffsetDateTime startTime;
    @Column(name = "end_time")
    private OffsetDateTime endTime;
    @OneToMany(mappedBy = "event")
    private List<Meeting> meetings;
    @OneToMany(mappedBy = "event")
    private List<UserEvent> eventUsers;

    public Event(String name, OffsetDateTime startTime, OffsetDateTime endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
