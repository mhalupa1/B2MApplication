package hr.b2m.mhalupa.b2mapplication.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "b2m_user_event")
public class UserEvent {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "created_event")
    private boolean createdEvent;
    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
