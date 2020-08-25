package lk.andunaechomedia.services.impl;

import lk.andunaechomedia.dtos.GetTempVersionDto;
import lk.andunaechomedia.dtos.SaveTempScheduleDto;
import lk.andunaechomedia.dtos.mapper.ScheduleMapper;
import lk.andunaechomedia.models.TempSchedule;
import lk.andunaechomedia.models.TempSchedulePlayFile;
import lk.andunaechomedia.repositories.*;
import lk.andunaechomedia.services.TempScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TempScheduleServiceImpl implements TempScheduleService {
    @Autowired
    TempScheduleRepo tempScheduleRepo;
    @Autowired
    DeviceRepo deviceRepo;
    @Autowired
    DeviceGroupRepo deviceGroupRepo;
    @Autowired
    FileRepo fileRepo;
    @Autowired
    TempSchedulePlayFileRepo tempSchedulePlayFileRepo;

    @Override
    public SaveTempScheduleDto saveTemp(SaveTempScheduleDto saveScheduleDto){
        tempScheduleRepo.save(ScheduleMapper.mapTempToModel(saveScheduleDto));
        return saveScheduleDto;
    }
    @Override
    public GetTempVersionDto getCurrentVersion(String deviceId){
        return ScheduleMapper.mapToGetTempVersionDto(deviceRepo.findById(deviceId).get().getDeviceGroup().getTempSchedule());
    }
    @Override
    public String decrementDeviceList(String deviceId) {
        TempSchedule tempSchedule = deviceRepo.findById(deviceId).get().getDeviceGroup().getTempSchedule();
        tempSchedule.setNoOf_devices(tempSchedule.getNoOf_devices()-1);
        tempScheduleRepo.save(tempSchedule);
        return "Ok";
    }
    @Override
    public Set<TempSchedulePlayFile> getTempScheduleByGroup(String groupId){
        TempSchedule tempSchedule = deviceGroupRepo.findById(groupId).get().getTempSchedule();
        return tempSchedulePlayFileRepo.findByTempScheduleId(tempSchedule.getTempId());
    }
}
