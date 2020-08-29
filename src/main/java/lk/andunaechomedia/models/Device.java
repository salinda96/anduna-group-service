package lk.andunaechomedia.models;

import lk.andunaechomedia.constant.DeviceStatus;
import lk.andunaechomedia.constant.HDMIStatus;
import lk.andunaechomedia.constant.InternetStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "device")
@Getter
@Setter
public class Device {
    @Id
    private String device_id;
    private String customer_name;
    private String start_point;
    private String end_point;
    private String device_address;
    private String tel_number;
    private String route;
    private String location_name;

    private String group_id;

    @Enumerated
    private DeviceStatus deviceStatus;
    @Enumerated
    private HDMIStatus hdmiStatus;
    @Enumerated
    private InternetStatus internetStatus;



}
