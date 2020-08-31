package lk.andunaechomedia.dtos.sendDtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendDeviceDto {

    private String device_id;
    private String locationName;
    private String main_broadcasting;
    private String layer_broadcasting;
    private Boolean deviceStatus;
    private Boolean hdmiStatus;
    private Boolean internetStatus;

}
