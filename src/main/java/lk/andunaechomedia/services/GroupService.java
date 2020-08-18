package lk.andunaechomedia.services;

import lk.andunaechomedia.dtos.SaveGroupDto;
import lk.andunaechomedia.models.Device;
import java.util.Set;

public interface GroupService {
    public SaveGroupDto saveGroup(SaveGroupDto group);
    public Set<Device> getDevicesByGroupId(String groupId);
}
