package hr.b2m.mhalupa.b2mapplication.helpers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEventRequestObject {

    private String name;
    private int hoursFromNow;
    private int durationDays;

}
