package lk.andunaechomedia.repositories;

import lk.andunaechomedia.models.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepo extends JpaRepository<Device,String> {
}
