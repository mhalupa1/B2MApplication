package hr.b2m.mhalupa.b2mapplication.service;

import hr.b2m.mhalupa.b2mapplication.dao.EventDAO;
import hr.b2m.mhalupa.b2mapplication.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class EventService {

    @Autowired
    EventDAO dao;

    public Event createEvent(String name, int hoursFromNow, int durationDays){
        OffsetDateTime startTime = OffsetDateTime.now().plusHours(hoursFromNow);
        OffsetDateTime endTime = startTime.plusDays(durationDays);
        Event event = new Event(name, startTime, endTime);
        return dao.save(event);
    }
}
