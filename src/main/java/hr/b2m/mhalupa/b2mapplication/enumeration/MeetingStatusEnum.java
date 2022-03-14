package hr.b2m.mhalupa.b2mapplication.enumeration;

public enum MeetingStatusEnum {

    PROPOSED(1), SCHEDULED(2);
    private final int code;

    MeetingStatusEnum(int code) {
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }
}
