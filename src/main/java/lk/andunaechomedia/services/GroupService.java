package lk.andunaechomedia.services;

import lk.andunaechomedia.dtos.getDtos.SaveGroupDto;
import lk.andunaechomedia.models.DeviceGroup;

import java.util.List;
import java.util.Set;

public interface GroupService {
    public SaveGroupDto saveGroup(SaveGroupDto group);
    public Set<DeviceGroup> getDeviceGroupsByStatus(Boolean groupStatus);
    public List<DeviceGroup> getAll();
    public DeviceGroup changeStatus(String id) throws Exception;
}
