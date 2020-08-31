package lk.andunaechomedia.services.impl;

import lk.andunaechomedia.dtos.sendDtos.SendRPIStatusDto;
import lk.andunaechomedia.repositories.DeviceRepo;
import lk.andunaechomedia.services.RPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RPIServiceImpl implements RPIService {
    @Autowired
    DeviceRepo deviceRepo;

    @Override
    public SendRPIStatusDto getDeviceStatus(String deviceId) throws Exception{
        if (deviceRepo.existsById(deviceId)) {
            SendRPIStatusDto sendRPIStatusDto = new SendRPIStatusDto();
            sendRPIStatusDto.setDeviceStatus(deviceRepo.findById(deviceId).get().getDeviceStatus());
            return sendRPIStatusDto;
        }
        else {
            throw new Exception();
        }

    }
}
