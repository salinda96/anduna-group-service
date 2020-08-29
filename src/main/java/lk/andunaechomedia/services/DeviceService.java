package lk.andunaechomedia.services;

import lk.andunaechomedia.dtos.SaveDeviceDto;
import lk.andunaechomedia.models.Device;
import org.springframework.stereotype.Service;

@Service
public interface DeviceService {

    public Device saveDevice(SaveDeviceDto saveDeviceDto);
}
