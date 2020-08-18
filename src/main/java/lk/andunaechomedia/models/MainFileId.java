package lk.andunaechomedia.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
class MainFileId implements Serializable {
    @Id
    @Column(
        name = "file_id"
    )
    String file_id;
    @Id
    @Column(
        name = "schedule_id"
    )
    String mainSchedule_id;

    public MainFileId() {
    }

    public MainFileId(String file_id, String mainSchedule_id) {
        this.file_id = file_id;
        this.mainSchedule_id = mainSchedule_id;
    }

    public String getFile_id() {
        return this.file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public String getMainSchedule_id() {
        return this.mainSchedule_id;
    }

    public void setMainSchedule_id(String mainSchedule_id) {
        this.mainSchedule_id = mainSchedule_id;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof MainFileId)) {
            return false;
        } else {
            MainFileId that = (MainFileId)o;
            return Objects.equals(this.getFile_id(), that.getFile_id()) && Objects.equals(this.getMainSchedule_id(), that.getMainSchedule_id());
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.getFile_id(), this.getMainSchedule_id()});
    }
}
