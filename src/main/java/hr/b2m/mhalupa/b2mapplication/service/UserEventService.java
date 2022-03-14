package hr.b2m.mhalupa.b2mapplication.service;

import hr.b2m.mhalupa.b2mapplication.dao.UserEventDAO;
import hr.b2m.mhalupa.b2mapplication.model.Event;
import hr.b2m.mhalupa.b2mapplication.model.UserEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEventService {

    @Autowired
    UserEventDAO dao;

    @Autowired
    private EventService eventService;

    public UserEvent addUserToEvent(UserEvent userEvent){
        return dao.save(userEvent);
    }

    //send timestamp in following format: 2022-03-11T16:19:52.83258+00
    public UserEvent createEvent(UserEvent userEvent){
        Event event = eventService.createEvent(userEvent.getEvent());
        userEvent.setEvent(event);
        userEvent.setCreatedEvent(true);
        return dao.save(userEvent);
    }
}
