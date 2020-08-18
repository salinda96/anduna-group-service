package lk.andunaechomedia.services.impl;

import lk.andunaechomedia.dtos.SaveDeviceDto;
import lk.andunaechomedia.dtos.mapper.DeviceMapper;
import lk.andunaechomedia.models.Device;
import lk.andunaechomedia.repositories.DeviceGroupRepo;
import lk.andunaechomedia.repositories.DeviceRepo;
import lk.andunaechomedia.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceRepo deviceRepo;

    @Autowired
    DeviceGroupRepo deviceGroupRepo;

    public SaveDeviceDto saveDevice(SaveDeviceDto saveDeviceDto) throws Exception{
        Device d = DeviceMapper.deviceMapToModel(saveDeviceDto);
        d.setDeviceGroup(deviceGroupRepo.findById(saveDeviceDto.getDeviceGroupId()).get());
        deviceRepo.save(d);
        return saveDeviceDto;
    }

    public String removeDevice(String deviceId) throws Exception{
        deviceRepo.deleteById(deviceId);
        return "deleted";
    }
}
