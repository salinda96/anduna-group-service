package lk.andunaechomedia.services.impl;

import lk.andunaechomedia.dtos.SaveDeviceDto;
import lk.andunaechomedia.dtos.mapper.DeviceMapper;
import lk.andunaechomedia.dtos.mapper.GroupMapper;
import lk.andunaechomedia.models.Device;
import lk.andunaechomedia.repositories.DeviceGroupRepo;
import lk.andunaechomedia.repositories.DeviceRepo;
import lk.andunaechomedia.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceimpl implements DeviceService {

    @Autowired
    DeviceRepo deviceRepo;

    @Override
    public Device saveDevice(SaveDeviceDto saveDeviceDto){

        Device d1 = DeviceMapper.fromSaveDto(saveDeviceDto);
        return deviceRepo.save(d1);
    }

}
