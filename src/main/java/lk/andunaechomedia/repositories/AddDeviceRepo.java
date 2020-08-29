package lk.andunaechomedia.repositories;

import lk.andunaechomedia.models.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddDeviceRepo extends JpaRepository<Device,String> {
}
