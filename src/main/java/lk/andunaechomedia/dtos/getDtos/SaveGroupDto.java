package lk.andunaechomedia.dtos.getDtos;

import lk.andunaechomedia.constant.GPSStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Enumerated;
import java.time.LocalTime;

@Getter
@Setter
public class SaveGroupDto {
private String groupId;
private String name;
private String description;
private String startTime;
private boolean gpsStatus;
private Integer GPSRepeatGap;
}
