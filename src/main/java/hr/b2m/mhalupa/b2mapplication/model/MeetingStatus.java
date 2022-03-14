package hr.b2m.mhalupa.b2mapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hr.b2m.mhalupa.b2mapplication.enumeration.MeetingStatusEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "b2m_meeting_status")
public class MeetingStatus {

    @Id
    private Long id;
    private Integer code;
    @Column(name = "verbose_name")
    private String verbose;
    @OneToMany(mappedBy = "meetingStatus")
    @JsonIgnore
    private List<Meeting> meetings;

    public MeetingStatus(MeetingStatusEnum statusEnum){
        this.id = (long) statusEnum.getCode();
        this.code = statusEnum.getCode();
        this.verbose = statusEnum.toString();
    }
}
