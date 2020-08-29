package lk.andunaechomedia.services.impl;

import lk.andunaechomedia.dtos.SaveGroupDto;
import lk.andunaechomedia.dtos.mapper.GroupMapper;
import lk.andunaechomedia.models.Device;
import lk.andunaechomedia.models.DeviceGroup;
import lk.andunaechomedia.models.MainSchedule;
import lk.andunaechomedia.repositories.DeviceGroupRepo;
import lk.andunaechomedia.repositories.MainScheduleRepo;
import lk.andunaechomedia.repositories.TempScheduleRepo;
import lk.andunaechomedia.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private DeviceGroupRepo groupRepo;

    @Autowired
    private MainScheduleRepo mainScheduleRepo;

    @Autowired
    TempScheduleRepo tempScheduleRepo;

    public SaveGroupDto saveGroup(SaveGroupDto group) {
        groupRepo.save(GroupMapper.fromSaveDto(group));
        return group;
    }
}
