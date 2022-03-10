package hr.b2m.mhalupa.b2mapplication.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity(name = "b2m_event")
public class Event {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "event")
    private List<Meeting> meetings;
    @OneToMany(mappedBy = "event")
    private List<UserEvent> eventUsers;

}
