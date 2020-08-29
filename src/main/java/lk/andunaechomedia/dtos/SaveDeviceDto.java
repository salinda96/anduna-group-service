package lk.andunaechomedia.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveDeviceDto {
    private String device_id;
    private String customer_name;
    private String start_point;
    private String end_point;
    private String device_address;
    private String tel_number;
    private String route;
    private String location_name;
}
