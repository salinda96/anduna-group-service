package lk.andunaechomedia.dtos.mapper;

import lk.andunaechomedia.constant.DeviceStatus;
import lk.andunaechomedia.constant.HDMIStatus;
import lk.andunaechomedia.constant.InternetStatus;
import lk.andunaechomedia.dtos.AddDeviceDto;
import lk.andunaechomedia.models.Device;
import lk.andunaechomedia.repositories.DeviceGroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

@Component
public class AddDeviceMapper {


    @Autowired
    DeviceGroupRepo deviceGroupRepo;

    public Device addDeviceMap(AddDeviceDto addDeviceDto) throws Exception{
        Device device = new Device();
        device.setDevice_id(addDeviceDto.getDevice_id());
        device.setCustomer_name(addDeviceDto.getCustomer_name());
        device.setDevice_address(addDeviceDto.getDevice_address());
        device.setTel_number(addDeviceDto.getTel_number());
        device.setOrigin(addDeviceDto.getOrigin());
        device.setDestination(addDeviceDto.getDestination());
        device.setRoute(addDeviceDto.getRoute());
        device.setLocation_name(addDeviceDto.getLocation_name());

        device.setDeviceStatus(DeviceStatus.OFF);
        device.setHdmiStatus(HDMIStatus.Disconnected);
        device.setInternetStatus(InternetStatus.Disconnected);


        if (deviceGroupRepo.existsById(addDeviceDto.getGroup_id())) {
            device.setGroup_id(addDeviceDto.getGroup_id());
        } else {
            throw new Exception("Unavailable Group Exception");
        }

        return device;

    }
}
