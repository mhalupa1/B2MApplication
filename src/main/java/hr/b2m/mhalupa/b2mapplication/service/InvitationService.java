package hr.b2m.mhalupa.b2mapplication.service;

import hr.b2m.mhalupa.b2mapplication.dao.InvitationDAO;
import hr.b2m.mhalupa.b2mapplication.enumeration.InvitationStatusEnum;
import hr.b2m.mhalupa.b2mapplication.model.Invitation;
import hr.b2m.mhalupa.b2mapplication.model.InvitationStatus;
import hr.b2m.mhalupa.b2mapplication.model.Meeting;
import hr.b2m.mhalupa.b2mapplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class InvitationService {

    @Autowired
    InvitationDAO dao;

    @Autowired
    MeetingService meetingService;

    public List<Invitation> sendInvitations(List<User> users, Meeting meeting){
        List<Invitation> invitations = new LinkedList<>();
        for(User user : users){
            Invitation invitation = sendInvitation(user, meeting);
            invitations.add(invitation);
        }
        return invitations;
    }

    private Invitation sendInvitation(User user, Meeting meeting){
        InvitationStatus invitationStatus = new InvitationStatus(InvitationStatusEnum.PENDING);
        Invitation invitation = new Invitation(user,meeting, invitationStatus);
        return dao.save(invitation);
    }

    public void resolveInvitation(Long userId, InvitationStatusEnum statusEnum){
        InvitationStatus invitationStatus = new InvitationStatus(statusEnum);
        Invitation acceptingInvitation = getInvitation(userId);

        //check if an already accepted meeting overlaps with newly accepted meeting
        if(invitationStatus.getCode() == InvitationStatusEnum.ACCEPTED.getCode()){
            checkMeetingOverlaps(userId, acceptingInvitation);
        }
        dao.resolveInvitation(userId, invitationStatus);

       /* if(invitationStatus.getCode() == InvitationStatusEnum.ACCEPTED.getCode()){
            checkAndScheduleMeeting(acceptingInvitation);
        }*/

    }

    public List<Invitation> getUserInvitations(Long id){
        return dao.getUserInvitations(id);
    }

    public Invitation getInvitation(Long id){
        return dao.getById(id);
    }

    public List<Invitation> getInvitationsForMeeting(Long meetingId){
        return dao.getInvitationsForMeeting(meetingId);
    }

    private void checkMeetingOverlaps(Long userId, Invitation acceptingInvitation){
        Meeting acceptingMeeting = acceptingInvitation.getMeeting();
        List<Invitation> invitations = getUserInvitations(acceptingInvitation.getUser().getId());
        invitations.stream().filter(invitation -> !invitation.getId().equals(userId))
                .forEach(invitation -> {
                    Meeting meeting = invitation.getMeeting();

                    //check meeting runtime overlap
                    if(acceptingMeeting.getStartTime().isBefore(meeting.getEndTime()) &&
                            meeting.getStartTime().isBefore(acceptingMeeting.getEndTime())){
                        throw new UnsupportedOperationException("The accepted meeting overlaps with an already accepted meeting.");
                    }
                });
    }

    private void checkAndScheduleMeeting(Invitation acceptingInvitation){
        Meeting meeting = acceptingInvitation.getMeeting();
        List<Invitation> invitations = getInvitationsForMeeting(meeting.getId());

        //check for any unaccepted invitations
        Optional<Invitation> unacceptedInv = invitations.stream()
                .filter(inv -> inv.getInvitationStatus().getCode() != InvitationStatusEnum.ACCEPTED.getCode())
                .findFirst();
        if(!unacceptedInv.isPresent()){
            meetingService.scheduleMeeting(meeting.getId());
        }

    }

}
