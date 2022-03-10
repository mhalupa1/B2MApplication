package hr.b2m.mhalupa.b2mapplication.controller;

import hr.b2m.mhalupa.b2mapplication.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeetingController {

    @Autowired
    MeetingService service;
}
