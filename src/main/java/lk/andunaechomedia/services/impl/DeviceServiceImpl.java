package lk.andunaechomedia.services.impl;

import lk.andunaechomedia.constant.DeviceStatus;
import lk.andunaechomedia.dtos.getDtos.AddDeviceDto;
import lk.andunaechomedia.dtos.getDtos.getMapper.DeviceMapper;
import lk.andunaechomedia.dtos.sendDtos.SendDeviceDto;
import lk.andunaechomedia.dtos.sendDtos.SendDeviceDetailsDto;
import lk.andunaechomedia.dtos.sendDtos.sendMapper.SendDeviceDtoMapper;
import lk.andunaechomedia.dtos.sendDtos.sendMapper.SendDeviceDetailsDtoMapper;
import lk.andunaechomedia.models.Device;
import lk.andunaechomedia.repositories.DeviceGroupRepo;
import lk.andunaechomedia.repositories.DeviceRepo;
import lk.andunaechomedia.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    DeviceRepo deviceRepo;

    @Autowired
    DeviceMapper addDeviceMapper;

    @Autowired
    DeviceGroupRepo deviceGroupRepo;

    @Autowired
    SendDeviceDtoMapper sendDeviceDtoMapper;

    @Autowired
    SendDeviceDetailsDtoMapper sendDeviceDetailsDtoMapper;

    @Override
    public Device addDevice(AddDeviceDto addDeviceDto) throws Exception {
        Device d = addDeviceMapper.addDeviceMap(addDeviceDto);
        return deviceRepo.save(d);
    }

    @Override
    public List<SendDeviceDto> findAllByGroupId(String id) throws  Exception{
        List<SendDeviceDto> sendDeviceDtos= new ArrayList();

        if(deviceGroupRepo.existsById(id)){
            deviceRepo.findAllByGroupId(id).forEach(d->{
               sendDeviceDtos.add( sendDeviceDtoMapper.deviceMaptoSendDeviceDto(d));
            });
        }
        else {
            throw new Exception();
        }
        return sendDeviceDtos;
    }

    @Override
    public Device changeDeviceStatus(String id)throws Exception {

        if(deviceRepo.existsById(id)){
            Device device=deviceRepo.findById(id).get();
            DeviceStatus deviceStatus= device.getDeviceStatus();
            device.setDeviceStatus(deviceStatus == DeviceStatus.OFF ? DeviceStatus.ON : DeviceStatus.OFF);
            return deviceRepo.save(device);
        }
        else{
            throw new Exception();
        }
    }

    @Override
    public SendDeviceDetailsDto deviceReportDetails(String id) throws Exception {
        SendDeviceDetailsDto sendDeviceDetailsDto = new SendDeviceDetailsDto();
        if(deviceRepo.existsById(id)) {
            Device device = deviceRepo.findById(id).get();
            sendDeviceDetailsDto = sendDeviceDetailsDtoMapper.deviceMaptoSendDeviceDetailstDto(device);
            return sendDeviceDetailsDto;
        }
        else {
            throw new Exception();
        }
    }


}
