package lk.andunaechomedia.services.impl;

import lk.andunaechomedia.dtos.AddDeviceDto;
import lk.andunaechomedia.dtos.mapper.AddDeviceMapper;
import lk.andunaechomedia.models.Device;
import lk.andunaechomedia.repositories.AddDeviceRepo;
import lk.andunaechomedia.services.AddDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddDeviceServiceImpl implements AddDeviceService {
    @Autowired
    AddDeviceRepo addDeviceRepo;

    @Override
    public Device addDevice(AddDeviceDto addDeviceDto){
        Device d = AddDeviceMapper.addDeviceMap(addDeviceDto);
        return addDeviceRepo.save(d);
    }


}
