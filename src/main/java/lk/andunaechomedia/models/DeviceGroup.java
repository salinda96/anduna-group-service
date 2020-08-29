package lk.andunaechomedia.models;
import lk.andunaechomedia.constant.GPSStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

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



}