CREATE OR REPLACE FUNCTION schedule_meeting() RETURNS TRIGGER AS
$$
	DECLARE
        status_verbose varchar;
		allInvCount int;
		acceptedInvCount int;
		scheduledId int;
    BEGIN
        SELECT verbose_name INTO status_verbose from b2m_invitation_status
            where id = new.invitation_status_id;
        if(status_verbose = 'ACCEPTED') THEN
            select count(*) into allInvCount from b2m_invitation where meeting_id = new.meeting_id;
            select count(*) into acceptedInvCount from b2m_invitation where meeting_id = new.meeting_id
                                                            and invitation_status_id = new.invitation_status_id;
            if(acceptedInvCount = allInvCount) then
                select id into scheduledId from b2m_meeting_status where verbose_name='SCHEDULED';
                update b2m_meeting set meeting_status_id = scheduledId where id = new.meeting_id;
            END IF;
        END IF;
    return new;
    END;
$$ LANGUAGE plpgsql;


CREATE TRIGGER schedule_meeting_audit
    AFTER UPDATE
    ON b2m_invitation
    FOR EACH ROW
    EXECUTE PROCEDURE schedule_meeting();