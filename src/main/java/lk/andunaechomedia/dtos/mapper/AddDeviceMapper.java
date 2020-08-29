package lk.andunaechomedia.dtos.mapper;

import lk.andunaechomedia.constant.DeviceStatus;
import lk.andunaechomedia.constant.HDMIStatus;
import lk.andunaechomedia.constant.InternetStatus;
import lk.andunaechomedia.dtos.AddDeviceDto;
import lk.andunaechomedia.models.Device;

public class AddDeviceMapper {

    public static Device addDeviceMap(AddDeviceDto addDeviceDto){
        Device device = new Device();
        device.setDevice_id(addDeviceDto.getDevice_id());
        device.setCustomer_name(addDeviceDto.getCustomer_name());
        device.setDevice_address(addDeviceDto.getDevice_address());
        device.setTel_number(addDeviceDto.getTel_number());
        device.setStart_point(addDeviceDto.getStart_point());
        device.setEnd_point(addDeviceDto.getEnd_point());
        device.setRoute(addDeviceDto.getRoute());
        device.setLocation_name(addDeviceDto.getLocation_name());

        device.setDeviceStatus(DeviceStatus.OFF);
        device.setHdmiStatus(HDMIStatus.Disconnected);
        device.setInternetStatus(InternetStatus.Disconnected);

        return device;

    }
}
