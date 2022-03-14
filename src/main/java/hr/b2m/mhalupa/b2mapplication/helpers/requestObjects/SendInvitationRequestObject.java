package hr.b2m.mhalupa.b2mapplication.helpers.requestObjects;

import hr.b2m.mhalupa.b2mapplication.model.Meeting;
import hr.b2m.mhalupa.b2mapplication.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SendInvitationRequestObject {

    private List<User> users;
    private Meeting meeting;
}
