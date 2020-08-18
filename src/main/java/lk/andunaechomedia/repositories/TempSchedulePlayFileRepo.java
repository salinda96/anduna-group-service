package lk.andunaechomedia.repositories;

import lk.andunaechomedia.models.TempSchedulePlayFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TempSchedulePlayFileRepo extends JpaRepository<TempSchedulePlayFile,Integer> {
    void deleteByTempScheduleId(String tempSchedule);
    Set<TempSchedulePlayFile> findByTempScheduleId(String tempSchedule);
}
