package lk.andunaechomedia.models;

import lk.andunaechomedia.constant.DeviceStatus;
import lk.andunaechomedia.constant.HDMIStatus;
import lk.andunaechomedia.constant.InternetStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Device {
    @Id
    private String device_id;
    private String customerName;
    private String deviceAddress;
    private String telNumber;
    private String origin;
    private String destination;
    private String route;
    private String locationName;
    private String groupId;

    @Enumerated
    private DeviceStatus deviceStatus;

    @Enumerated
    private HDMIStatus hdmiStatus;

    @Enumerated
    private InternetStatus internetStatus;


}
