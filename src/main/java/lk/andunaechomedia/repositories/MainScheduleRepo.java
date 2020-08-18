package lk.andunaechomedia.repositories;

import lk.andunaechomedia.models.MainSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainScheduleRepo extends JpaRepository<MainSchedule, String> {
    MainSchedule findTopByOrderByScheduleIdDesc();

}
