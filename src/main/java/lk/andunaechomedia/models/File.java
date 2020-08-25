package lk.andunaechomedia.models;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "file")
public class File{
    public File() {
    }

    public File(String file_id) {
        this.file_id=file_id;
    }

    private static  final long serialVersionUID=1L;

    @Id
    String file_id;
    String file_path;



    public String getFile_id(){
        return file_id;
    }
    public void setFile_id(String file_id){
        this.file_id=file_id;
    }

    public String getFile_path(){

        return file_path;
    }
    public void setFile_path(String file_path){

        this.file_path=file_path;
    }

}
//    @JsonBackReference(value = "MainSchedulePlayFile-File")
//    @OneToMany(mappedBy = "file",cascade = {CascadeType.ALL})
//    Set<MainSchedulePlayFile> mainSchedulePlayFiles;
//
//    @JsonBackReference(value = "TempSchedulePlayFile-File")
//    @OneToMany(mappedBy = "tempSchedule")
//    @JsonBackReference(value = "TempSchedulePlayFile-File")
//    @OneToMany(mappedBy = "file",cascade = {CascadeType.ALL})
//    Set<TempSchedulePlayFile> tempScheduleHasFiles;
//
//
//    public Set<TempSchedulePlayFile> getTempScheduleHasFiles() {
//        return tempScheduleHasFiles;
//    }
//
//    public void setTempScheduleHasFiles(Set<TempSchedulePlayFile> tempScheduleHasFiles) {
//        this.tempScheduleHasFiles = tempScheduleHasFiles;
//    }
//
//    public Set<MainSchedulePlayFile> getMainSchedulePlayFiles() {
//        return mainSchedulePlayFiles;
//    }
//
//    public void setMainSchedulePlayFiles(Set<MainSchedulePlayFile> mainSchedule) {
//        this.mainSchedulePlayFiles = mainSchedule;
//    }