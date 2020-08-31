package lk.andunaechomedia.dtos.sendDtos.sendMapper;

import lk.andunaechomedia.dtos.sendDtos.SendDeviceDetailsDto;
import lk.andunaechomedia.models.Device;
import org.springframework.stereotype.Component;

@Component
public class SendDeviceDetailsDtoMapper {

    public SendDeviceDetailsDto deviceMaptoSendDeviceDetailstDto(Device device){
        SendDeviceDetailsDto sendDeviceDetailsDto = new SendDeviceDetailsDto();

        //sendDeviceDetailsDto.setDevice_id(device.getDevice_id());
        sendDeviceDetailsDto.setCustomerName(device.getCustomerName());
        sendDeviceDetailsDto.setDestination(device.getDestination());
        sendDeviceDetailsDto.setDeviceAddress(device.getDeviceAddress());
        sendDeviceDetailsDto.setHdmiStatus(device.getHdmiStatus());
        sendDeviceDetailsDto.setInternetStatus(device.getInternetStatus());
        sendDeviceDetailsDto.setLocationName(device.getLocationName());
        sendDeviceDetailsDto.setOrigin(device.getOrigin());
        sendDeviceDetailsDto.setRoute(device.getRoute());
        sendDeviceDetailsDto.setTelNumber(device.getTelNumber());
        sendDeviceDetailsDto.setLayer(null);
        sendDeviceDetailsDto.setContent(null);

        return sendDeviceDetailsDto;
    }
}
