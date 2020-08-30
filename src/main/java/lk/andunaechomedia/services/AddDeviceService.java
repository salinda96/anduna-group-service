package lk.andunaechomedia.services;

import lk.andunaechomedia.dtos.AddDeviceDto;
import lk.andunaechomedia.models.Device;

public interface AddDeviceService {
    public Device addDevice(AddDeviceDto addDeviceDto) throws Exception;
}
