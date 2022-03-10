package hr.b2m.mhalupa.b2mapplication.enumeration;

public enum InvitationStatusEnum {

    PENDING(0), ACCEPTED(1), REJECTED(2);
    private int code;


    InvitationStatusEnum(int code) {
        this.code = code;
    }
};
