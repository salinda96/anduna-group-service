package lk.andunaechomedia.dtos.sendDtos;

import lk.andunaechomedia.constant.DeviceStatus;
import lk.andunaechomedia.constant.HDMIStatus;
import lk.andunaechomedia.constant.InternetStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendDeviceDetailsDto {
    //private String device_id;
    private String customerName;
    private String deviceAddress;
    private String telNumber;
    private String origin;
    private String destination;
    private String route;
    private String locationName;
    private String groupId;

    private HDMIStatus hdmiStatus;
    private InternetStatus internetStatus;
    private String Layer;
    private String content;
}
