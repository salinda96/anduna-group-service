package lk.andunaechomedia.services.impl;

import lk.andunaechomedia.dtos.AddDeviceDto;
import lk.andunaechomedia.dtos.mapper.DeviceMapper;
import lk.andunaechomedia.models.Device;
import lk.andunaechomedia.repositories.DeviceRepo;
import lk.andunaechomedia.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    DeviceRepo deviceRepo;

    @Autowired
    DeviceMapper addDeviceMapper;

    @Override
    public Device addDevice(AddDeviceDto addDeviceDto) throws Exception {
        Device d = addDeviceMapper.addDeviceMap(addDeviceDto);
        return deviceRepo.save(d);
    }


}
