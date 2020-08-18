package lk.andunaechomedia.services.impl;

import lk.andunaechomedia.dtos.GetVersionDto;
import lk.andunaechomedia.dtos.SaveScheduleDto;
import lk.andunaechomedia.dtos.mapper.ScheduleMapper;
import lk.andunaechomedia.models.DeviceGroup;
import lk.andunaechomedia.models.MainSchedule;
import lk.andunaechomedia.models.MainSchedulePlayFile;
import lk.andunaechomedia.repositories.DeviceGroupRepo;
import lk.andunaechomedia.repositories.DeviceRepo;
import lk.andunaechomedia.repositories.MainSchedulePlayFileRepo;
import lk.andunaechomedia.repositories.MainScheduleRepo;
import lk.andunaechomedia.services.MainScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MainScheduleServiceImpl implements MainScheduleService {
    @Autowired
    MainScheduleRepo mainScheduleRepo;
    @Autowired
    DeviceRepo deviceRepo;
    @Autowired
    DeviceGroupRepo deviceGroupRepo;
    @Autowired
    MainSchedulePlayFileRepo mainSchedulePlayFileRepo;


    @Override
    public SaveScheduleDto save(SaveScheduleDto scheduleDto) {
         mainScheduleRepo.save(ScheduleMapper.mapToModel(scheduleDto));
        return scheduleDto;
    }

    @Override
    public GetVersionDto getCurrentVersion(String deviceId) {
        return ScheduleMapper.mapToGetVersionDto(deviceRepo
                .findById(deviceId).get()
                .getDeviceGroup()
                .getMainSchedule());
    }

    @Override
    public String decrementDevicesList(String deviceId) {
        MainSchedule mainSchedule = deviceRepo.findById(deviceId).get().getDeviceGroup().getMainSchedule();
        mainSchedule.setNoOf_devices(mainSchedule.getNoOf_devices()-1);
        mainScheduleRepo.save(mainSchedule);
        return "Ok...";
    }
    @Override
    public Set<MainSchedulePlayFile> getScheduleByGroup(String groupId){
        MainSchedule mainSchedule = deviceGroupRepo.findById(groupId).get().getMainSchedule();
        return mainSchedulePlayFileRepo.findByMainSchedule(mainSchedule.getScheduleId());
    }
}
