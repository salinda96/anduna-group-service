package lk.andunaechomedia.repositories;

import lk.andunaechomedia.constant.DeviceGroupStatus;
import lk.andunaechomedia.models.DeviceGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DeviceGroupRepo extends JpaRepository<DeviceGroup, String> {
    public Set<DeviceGroup> getAllByDeviceGroupStatus(DeviceGroupStatus deviceGroupStatus);
}
