package lk.andunaechomedia.services;

import lk.andunaechomedia.dtos.AddDeviceDto;
import lk.andunaechomedia.models.Device;
import org.springframework.stereotype.Service;

@Service
public interface DeviceService {
    public Device addDevice(AddDeviceDto addDeviceDto) throws Exception;
}
