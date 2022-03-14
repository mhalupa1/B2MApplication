package hr.b2m.mhalupa.b2mapplication.enumeration;

public enum InvitationStatusEnum {

    PENDING(1), ACCEPTED(2), REJECTED(3);
    private final int code;


    InvitationStatusEnum(int code) {
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }
};
