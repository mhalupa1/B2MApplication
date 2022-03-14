package hr.b2m.mhalupa.b2mapplication.helpers.requestObjects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventUserRequestObject {

    private Long userId;
    private Long eventId;
    private Boolean createdEvent;


}
