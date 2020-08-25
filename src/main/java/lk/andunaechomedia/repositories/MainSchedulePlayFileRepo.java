package lk.andunaechomedia.repositories;

import lk.andunaechomedia.models.MainSchedulePlayFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MainSchedulePlayFileRepo extends JpaRepository<MainSchedulePlayFile,Integer> {
    int deleteByMainSchedule(String mainSchedule);
    Set<MainSchedulePlayFile> findByMainSchedule(String mainSchedule);

}
