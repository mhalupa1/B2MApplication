package hr.b2m.mhalupa.b2mapplication.controller;

import hr.b2m.mhalupa.b2mapplication.enumeration.InvitationStatusEnum;
import hr.b2m.mhalupa.b2mapplication.helpers.requestObjects.SendInvitationRequestObject;
import hr.b2m.mhalupa.b2mapplication.model.Invitation;
import hr.b2m.mhalupa.b2mapplication.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvitationController {

    @Autowired
    InvitationService service;

    @PostMapping(value = "/sendInvitations")
    public ResponseEntity sendInvitations(@RequestBody SendInvitationRequestObject requestObject){
        List<Invitation> invitations = service.sendInvitations(requestObject.getUsers(), requestObject.getMeeting());
        return ResponseEntity.ok(invitations);
    }

    @PostMapping(value = "/acceptInvitation")
    public ResponseEntity acceptInvitation(@RequestBody Long id){
        try {
            service.resolveInvitation(id, InvitationStatusEnum.ACCEPTED);
        } catch(UnsupportedOperationException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/rejectInvitation")
    public ResponseEntity rejectInvitation(@RequestBody Long id){
        service.resolveInvitation(id, InvitationStatusEnum.REJECTED);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/getUserInvitations")
    public List<Invitation> getAllForUser(@RequestParam Long id){
        return service.getUserInvitations(id);
    }
}
