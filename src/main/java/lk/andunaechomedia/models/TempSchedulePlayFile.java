package lk.andunaechomedia.models;

import javax.persistence.*;

@Entity
@Table(name = "temp_schedule_play_file")
public class TempSchedulePlayFile{
    public TempSchedulePlayFile() {
    }

    @Id
    @GeneratedValue
    private int temp_schedule_play_file_id;

    private static final long serialVersionUID = 1L;

    private String tempScheduleId;

    private String startTime;

    private String fileId;

    private int duration;


    public TempSchedulePlayFile(String tempScheduleId, String startTime, String fileId, int duration){
        this.tempScheduleId =tempScheduleId;
        this.startTime =startTime;
        this.fileId =fileId;
        this.duration = duration;

    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getTemp_schedule_play_file_id() {
        return temp_schedule_play_file_id;
    }

    public void setTemp_schedule_play_file_id(int temp_schedule_play_file_id) {
        this.temp_schedule_play_file_id = temp_schedule_play_file_id;
    }

    public String getTempScheduleId() {
        return tempScheduleId;
    }

    public void setTempScheduleId(String tempScheduleId) {
        this.tempScheduleId = tempScheduleId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String fileId) {
        this.startTime = fileId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String mainScheduleId) {
        this.fileId = mainScheduleId;
    }

}

//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        TempSchedulePlayFile that = (TempSchedulePlayFile) o;
//        return Objects.equals(tempSchedule, that.tempSchedule) &&
//                Objects.equals(file, that.file) &&
//                Objects.equals(file_start_time, that.file_start_time);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(tempSchedule, file, file_start_time);
//    }