//package lk.andunaechomedia.models;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Date;
//import java.util.Objects;
//
//@Entity
//@Table(name = "temp_schedule_has_file")
//public class TempScheduleHasFile implements Serializable {
//    public TempScheduleHasFile() {
//    }
//
//    private static final long serialVersionUID = 1L;
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "schedule_id")
//    TempSchedule tempSchedule;
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "file_id")
//    File file;
//    Date file_start_time;//time
//
//    public TempSchedule getTempSchedule() {
//        return tempSchedule;
//    }
//
//    public void setTempSchedule(TempSchedule tempSchedule) {
//        this.tempSchedule = tempSchedule;
//    }
//
//    public File getFile() {
//        return file;
//    }
//
//    public void setFile(File file) {
//        this.file = file;
//    }
//
//    public Date getFile_start_time(){
//
//     return file_start_time;
//    }
//
//    public void setFile_start_time(Date file_start_time) {
//
//     this.file_start_time = file_start_time;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        TempScheduleHasFile that = (TempScheduleHasFile) o;
//        return Objects.equals(tempSchedule, that.tempSchedule) &&
//                Objects.equals(file, that.file) &&
//                Objects.equals(file_start_time, that.file_start_time);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(tempSchedule, file, file_start_time);
//    }
//}
