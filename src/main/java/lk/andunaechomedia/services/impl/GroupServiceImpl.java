package lk.andunaechomedia.services.impl;

import lk.andunaechomedia.dtos.SaveGroupDto;
import lk.andunaechomedia.dtos.mapper.GroupMapper;
import lk.andunaechomedia.repositories.DeviceGroupRepo;
import lk.andunaechomedia.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private DeviceGroupRepo groupRepo;


    public SaveGroupDto saveGroup(SaveGroupDto group) {
        groupRepo.save(GroupMapper.fromSaveDto(group));
        return group;
    }
}
