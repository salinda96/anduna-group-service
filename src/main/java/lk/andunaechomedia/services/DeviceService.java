package lk.andunaechomedia.services;

import lk.andunaechomedia.dtos.getDtos.AddDeviceDto;
import lk.andunaechomedia.dtos.sendDtos.SendDeviceDto;
import lk.andunaechomedia.models.Device;
import lk.andunaechomedia.models.DeviceGroup;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DeviceService {
    public Device addDevice(AddDeviceDto addDeviceDto) throws Exception;
    public List<SendDeviceDto> findAllByGroupId(String id) throws  Exception;

    public Device changeDeviceStatus(String id) throws Exception;
}
