package hr.b2m.mhalupa.b2mapplication.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "b2m_organization")
public class Organization {

    @Id
    private Long id;
    private String name;
    @Column(name = "created_event")
    private boolean createdEvent;
    @OneToMany(mappedBy = "organization")
    private List<User> users;
}
