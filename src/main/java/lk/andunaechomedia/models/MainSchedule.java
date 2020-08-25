package lk.andunaechomedia.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Set;
import javax.persistence.*;


@Entity
@Table(
    name = "main_schedule"
)
public class MainSchedule {
    @Id
    private String scheduleId;
    private int version;
    private int noOf_devices;
    private String startTime;

   @JsonBackReference("DeviceGroup-MainSchedule")
    @OneToMany(mappedBy = "mainSchedule",cascade = {CascadeType.ALL})
    private Set<DeviceGroup> groups;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getNoOf_devices() {
        return noOf_devices;
    }

    public void setNoOf_devices(int noOf_devices) {
        this.noOf_devices = noOf_devices;
    }

    public Set<DeviceGroup> getGroups() {
        return this.groups;
    }

    public void setGroups(Set<DeviceGroup> groups) {
        this.groups = groups;
    }

    public String getScheduleId() {
        return this.scheduleId;
    }

    public void setScheduleId(String schedule_id) {
        this.scheduleId = schedule_id;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int version) {
        this.version =version;
    }
}
