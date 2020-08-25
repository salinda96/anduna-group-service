package lk.andunaechomedia.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "temp_schedule")
public class TempSchedule{

    @Id
    private String tempId;
    private int version;
    private int noOf_devices;

    @JsonBackReference(value = "DeviceGroup-TempSchedule")
    @OneToMany(mappedBy = "tempSchedule", cascade = {
            CascadeType.ALL
    })
    private Set<DeviceGroup> groups;

    public int getNoOf_devices() {
        return noOf_devices;
    }

    public void setNoOf_devices(int noOf_devices) {
        this.noOf_devices = noOf_devices;
    }

    public Set<DeviceGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<DeviceGroup> groups) {
        this.groups = groups;
    }

    public String getTempId() {
        return tempId;
    }

    public void setTempId(String temp_id) {
        this.tempId = temp_id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }


}
