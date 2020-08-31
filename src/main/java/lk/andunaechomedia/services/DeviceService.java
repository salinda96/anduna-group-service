package lk.andunaechomedia.services;

import lk.andunaechomedia.dtos.getDtos.AddDeviceDto;
import lk.andunaechomedia.dtos.sendDtos.SendDeviceDto;
import lk.andunaechomedia.dtos.sendDtos.SendDeviceDetailsDto;
import lk.andunaechomedia.models.Device;

import java.util.List;


public interface DeviceService {
    public Device addDevice(AddDeviceDto addDeviceDto) throws Exception;
    public List<SendDeviceDto> findAllByGroupId(String id) throws  Exception;

    public Device changeDeviceStatus(String id) throws Exception;
    public SendDeviceDetailsDto deviceReportDetails(String id) throws Exception;
}
