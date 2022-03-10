package hr.b2m.mhalupa.b2mapplication.service;

import hr.b2m.mhalupa.b2mapplication.dao.MeetingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingService {

    @Autowired
    MeetingDAO dao;
}
