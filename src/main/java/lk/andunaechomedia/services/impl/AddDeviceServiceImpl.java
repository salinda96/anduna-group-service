package lk.andunaechomedia.services.impl;

import lk.andunaechomedia.dtos.AddDeviceDto;
import lk.andunaechomedia.dtos.mapper.AddDeviceMapper;
import lk.andunaechomedia.models.Device;
import lk.andunaechomedia.repositories.DeviceRepo;
import lk.andunaechomedia.services.AddDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddDeviceServiceImpl implements AddDeviceService {
    @Autowired
    DeviceRepo deviceRepo;



    @Autowired
    AddDeviceMapper addDeviceMapper;

    @Override
    public Device addDevice(AddDeviceDto addDeviceDto) throws Exception {
        Device d = addDeviceMapper.addDeviceMap(addDeviceDto);
        return deviceRepo.save(d);
    }


}
