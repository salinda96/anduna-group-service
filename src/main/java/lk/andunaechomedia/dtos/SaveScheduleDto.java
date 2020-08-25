package lk.andunaechomedia.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveScheduleDto {
    private String scheduleId;
    private int version;
    private  String startTime;
}
