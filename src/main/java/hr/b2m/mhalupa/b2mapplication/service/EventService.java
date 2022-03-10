package hr.b2m.mhalupa.b2mapplication.service;

import hr.b2m.mhalupa.b2mapplication.dao.EventDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    EventDAO dao;
}
