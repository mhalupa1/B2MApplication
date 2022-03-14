package hr.b2m.mhalupa.b2mapplication.controller;

import hr.b2m.mhalupa.b2mapplication.helpers.requestObjects.EventUserRequestObject;
import hr.b2m.mhalupa.b2mapplication.model.Event;
import hr.b2m.mhalupa.b2mapplication.model.User;
import hr.b2m.mhalupa.b2mapplication.model.UserEvent;
import hr.b2m.mhalupa.b2mapplication.service.EventService;
import hr.b2m.mhalupa.b2mapplication.service.UserEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserEventController {

    @Autowired
    private UserEventService service;

    @PostMapping(value = "/addUserToEvent")
    public @ResponseBody ResponseEntity addUserToEvent(@RequestBody UserEvent userEvent){
        return ResponseEntity.ok(service.addUserToEvent(userEvent));
    }

    //send timestamp in following format: 2022-03-11T16:19:52.83258+00
    @PostMapping(value = "/createEvent")
    public @ResponseBody ResponseEntity createEvent(@RequestBody UserEvent userEvent){
        return ResponseEntity.ok(service.createEvent(userEvent));
    }

}
