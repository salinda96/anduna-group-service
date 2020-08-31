package lk.andunaechomedia.dtos.sendDtos.sendMapper;

import lk.andunaechomedia.constant.DeviceStatus;
import lk.andunaechomedia.constant.HDMIStatus;
import lk.andunaechomedia.constant.InternetStatus;
import lk.andunaechomedia.dtos.sendDtos.SendDeviceDto;
import lk.andunaechomedia.models.Device;
import org.springframework.stereotype.Component;

@Component
public class SendDeviceDtoMapper {
    public SendDeviceDto deviceMaptoSendDeviceDto(Device device){

        SendDeviceDto sendDeviceDto = new SendDeviceDto();

        sendDeviceDto.setInternetStatus(device.getInternetStatus() == InternetStatus.CONNECTED ? true : false);
        sendDeviceDto.setHdmiStatus(device.getHdmiStatus() == HDMIStatus.CONNECTED ? true : false);
        sendDeviceDto.setDevice_id(device.getDevice_id());
        sendDeviceDto.setLocationName(device.getLocationName());
        sendDeviceDto.setMain_broadcasting(null);
        sendDeviceDto.setLayer_broadcasting(null);
        sendDeviceDto.setDeviceStatus(device.getDeviceStatus() == DeviceStatus.ON ? true : false);

        return sendDeviceDto;

    }

}
