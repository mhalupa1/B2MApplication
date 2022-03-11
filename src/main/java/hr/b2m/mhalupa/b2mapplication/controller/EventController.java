package hr.b2m.mhalupa.b2mapplication.controller;

import hr.b2m.mhalupa.b2mapplication.helpers.CreateEventRequestObject;
import hr.b2m.mhalupa.b2mapplication.model.Event;
import hr.b2m.mhalupa.b2mapplication.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.time.OffsetDateTime;

@RestController
public class EventController {

    @Autowired
    EventService service;

    @PostMapping(value = "/createEvent")
    public @ResponseBody ResponseEntity createEvent(@RequestBody CreateEventRequestObject requestObject){
        Event event = service.createEvent(requestObject.getName(), requestObject.getHoursFromNow(), requestObject.getDurationDays());
        return ResponseEntity.ok(event);
    }
}
