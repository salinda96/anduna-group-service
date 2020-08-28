package lk.andunaechomedia.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lk.andunaechomedia.constant.GPSStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Set;
import java.util.Timer;

@Entity
@Table(name = "device_group")
@Getter
@Setter
public class DeviceGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    public DeviceGroup() {
    }

    public DeviceGroup(String groupId) {
        this.groupId=groupId;
    }

    @Id
    private String groupId;
    private String groupName;
    private String description;

    @Enumerated
    private GPSStatus gpsStatus;
    @Column(columnDefinition = "TIME")
    private LocalTime broadCastTime;

    private Integer gpsRepeat;



    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "main_schedule_id")
    private MainSchedule mainSchedule;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "temp_id")
    private TempSchedule tempSchedule;


}