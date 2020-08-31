package lk.andunaechomedia.services.impl;

import lk.andunaechomedia.constant.DeviceGroupStatus;
import lk.andunaechomedia.constant.DeviceStatus;
import lk.andunaechomedia.dtos.getDtos.SaveGroupDto;
import lk.andunaechomedia.dtos.getDtos.getMapper.GroupMapper;
import lk.andunaechomedia.models.DeviceGroup;
import lk.andunaechomedia.repositories.DeviceGroupRepo;
import lk.andunaechomedia.repositories.DeviceRepo;
import lk.andunaechomedia.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private DeviceGroupRepo groupRepo;

    @Autowired
    private DeviceRepo deviceRepo;

    public SaveGroupDto saveGroup(SaveGroupDto group) {
        groupRepo.save(GroupMapper.fromSaveDto(group));
        return group;
    }

    @Override
    public Set<DeviceGroup> getDeviceGroupsByStatus(Boolean status) {
        return  groupRepo.getAllByDeviceGroupStatus(status ? DeviceGroupStatus.ACTIVATED : DeviceGroupStatus.DEACTIVATED);
    }

    @Override
    public List<DeviceGroup> getAll() {
        return groupRepo.findAll();
    }

    @Override
    public DeviceGroup changeStatus(String id) throws Exception{
        if(groupRepo.existsById(id)){
            DeviceGroup group=groupRepo.findById(id).get();
            DeviceGroupStatus status= group.getDeviceGroupStatus();
            group.setDeviceGroupStatus(status == DeviceGroupStatus.ACTIVATED ? DeviceGroupStatus.DEACTIVATED : DeviceGroupStatus.ACTIVATED);
            deviceRepo.findAllByGroupId(id).forEach(device -> {
                device.setDeviceStatus(status == DeviceGroupStatus.ACTIVATED ? DeviceStatus.OFF : DeviceStatus.ON);
                deviceRepo.save(device);
            });
            return groupRepo.save(group);
        }
        else{
            throw new Exception();
        }

    }
}
