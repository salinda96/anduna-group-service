package lk.andunaechomedia.dtos.getDtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddDeviceDto {
    private String device_id;
    private String customer_name;
    private String device_address;
    private String tel_number;
    private String origin;
    private String destination;
    private String route;
    private String location_name;

    private String group_id;
}
