package lk.andunaechomedia.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
//@IdClass(lk.andunaechomedia.models.MainSchedulePlayFile.class)
@Entity
@Table(
    name = "main_schedule_play_file"
)
public class MainSchedulePlayFile {

    private String mainSchedule;

    @Id
    @GeneratedValue
    private int main_schedule_play_file_id;

    private String file;
    private Integer playPoint;

    public MainSchedulePlayFile() {
    }

    public MainSchedulePlayFile(String mainSchedule, String file,Integer playPoint) {
        this.mainSchedule = mainSchedule;
        this.file = file;
        this.playPoint=playPoint;
    }

    public int getMain_schedule_play_file_id() {
        return main_schedule_play_file_id;
    }

    public void setMain_schedule_play_file_id(int main_schedule_play_file_id) {
        this.main_schedule_play_file_id = main_schedule_play_file_id;
    }

    public String getMainSchedule() {
        return this.mainSchedule;
    }

    public void setMainSchedule(String mainSchedule) {
        this.mainSchedule = mainSchedule;
    }

    public String getFile() {
        return this.file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Integer getPlayPoint() {
        return this.playPoint;
    }

    public void setPlayPoint(Integer playPoint) {
        this.playPoint = playPoint;
    }

}

//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        } else if (o != null && this.getClass() == o.getClass()) {
//            MainSchedulePlayFile that = (MainSchedulePlayFile)o;
//            return Objects.equals(this.mainSchedule, that.mainSchedule) && Objects.equals(this.file, that.file) && Objects.equals(this.playPoint, that.playPoint);
//        } else {
//            return false;
//        }
//    }
//
//    public int hashCode() {
//        return Objects.hash(new Object[]{this.mainSchedule, this.file, this.playPoint});
//    }