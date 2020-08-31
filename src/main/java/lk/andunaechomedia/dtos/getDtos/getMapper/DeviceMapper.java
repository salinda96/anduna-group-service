package lk.andunaechomedia.dtos.getDtos.getMapper;

import lk.andunaechomedia.constant.DeviceStatus;
import lk.andunaechomedia.constant.HDMIStatus;
import lk.andunaechomedia.constant.InternetStatus;
import lk.andunaechomedia.dtos.getDtos.AddDeviceDto;
import lk.andunaechomedia.models.Device;
import lk.andunaechomedia.repositories.DeviceGroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeviceMapper {


    @Autowired
    DeviceGroupRepo deviceGroupRepo;

    public Device addDeviceMap(AddDeviceDto addDeviceDto) throws Exception{
        Device device = new Device();
        device.setDevice_id(addDeviceDto.getDevice_id());
        device.setCustomerName(addDeviceDto.getCustomer_name());
        device.setDeviceAddress(addDeviceDto.getDevice_address());
        device.setTelNumber(addDeviceDto.getTel_number());
        device.setOrigin(addDeviceDto.getOrigin());
        device.setDestination(addDeviceDto.getDestination());
        device.setRoute(addDeviceDto.getRoute());
        device.setLocationName(addDeviceDto.getLocation_name());

        device.setDeviceStatus(DeviceStatus.OFF);
        device.setHdmiStatus(HDMIStatus.DISCONNECTED);
        device.setInternetStatus(InternetStatus.DISCONNECTED);


        if (deviceGroupRepo.existsById(addDeviceDto.getGroup_id())) {
            device.setGroupId(addDeviceDto.getGroup_id());
        } else {
            throw new Exception("Unavailable Group Exception");
        }

        return device;

    }
}
