package lk.andunaechomedia.services;

import lk.andunaechomedia.dtos.sendDtos.SendRPIStatusDto;
import org.springframework.stereotype.Service;


public interface RPIService {
    public SendRPIStatusDto getDeviceStatus(String deviceId) throws Exception;
}
