package hr.b2m.mhalupa.b2mapplication.controller;


import hr.b2m.mhalupa.b2mapplication.model.Meeting;
import hr.b2m.mhalupa.b2mapplication.model.UserMeeting;
import hr.b2m.mhalupa.b2mapplication.service.UserMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserMeetingController {

    @Autowired
    UserMeetingService service;

    @GetMapping(value = "/getUserMeetings")
    public List<UserMeeting> getUserMeetings(@RequestParam Long id){
        return service.getUserMeetings(id);
    }


    //send timestamp in following format: 2022-03-11T16:19:52.83258+00
    @PostMapping(value = "/createMeeting")
    public ResponseEntity createMeeting(@RequestBody UserMeeting userMeeting){
        return ResponseEntity.ok(service.createMeeting(userMeeting));
    }

}
