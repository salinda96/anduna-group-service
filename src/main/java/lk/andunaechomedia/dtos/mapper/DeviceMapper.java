package lk.andunaechomedia.dtos.mapper;

import lk.andunaechomedia.constant.DeviceStatus;
import lk.andunaechomedia.constant.HDMIStatus;
import lk.andunaechomedia.constant.InternetStatus;
import lk.andunaechomedia.dtos.SaveDeviceDto;
import lk.andunaechomedia.dtos.SaveGroupDto;
import lk.andunaechomedia.models.Device;


public class DeviceMapper {
    static public Device fromSaveDto(SaveDeviceDto deviceDto){

        Device device = new Device();
        device.setDevice_id(deviceDto.getDevice_id());
        device.setCustomer_name(deviceDto.getCustomer_name());
        device.setStart_point(deviceDto.getStart_point());
        device.setEnd_point(deviceDto.getEnd_point());
        device.setDevice_address(deviceDto.getDevice_address());
        device.setTel_number(deviceDto.getTel_number());
        device.setRoute(deviceDto.getRoute());
        device.setLocation_name(deviceDto.getLocation_name());
        device.setDeviceStatus(DeviceStatus.OFF);
        device.setHdmiStatus(HDMIStatus.DISCONNECTED);
        device.setInternetStatus(InternetStatus.DISCONNECTED);
        return device;
    }
}
