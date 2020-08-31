package lk.andunaechomedia.repositories;

import lk.andunaechomedia.models.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepo extends JpaRepository<Device,String> {

    public List<Device> findAllByGroupId(String id);
}
