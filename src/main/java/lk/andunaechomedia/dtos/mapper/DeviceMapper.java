package lk.andunaechomedia.dtos.mapper;

import lk.andunaechomedia.dtos.SaveDeviceDto;
import lk.andunaechomedia.models.Device;
import lk.andunaechomedia.repositories.DeviceGroupRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


public class DeviceMapper {

    @Autowired
    static DeviceGroupRepo deviceGroupRepo;

    public static Device deviceMapToModel(SaveDeviceDto deviceDto){
        Device device = new Device();
        device.setDevice_id(deviceDto.getDeviceId());
        device.setCustomer_name(deviceDto.getCustomerName());
        device.setDevice_address(deviceDto.getDeviceAddress());
        device.setEnd_point(deviceDto.getEndPoint());
        device.setStart_point(deviceDto.getStartPoint());
        device.setPublishDate(new Date());
        device.setTel_number(deviceDto.getTelNumber());
        device.setStatus(deviceDto.getStatus());
        System.out.println(device);

        return device;
    }

}
//    public static Device deviceDeleteMapToModel(SaveDeviceDto saveDeviceDto){
//
//
//
//
//        return device;
//    }