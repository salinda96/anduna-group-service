package lk.andunaechomedia.dtos.mapper;

import lk.andunaechomedia.constant.GPSStatus;
import lk.andunaechomedia.dtos.SaveGroupDto;
import lk.andunaechomedia.models.DeviceGroup;
import lk.andunaechomedia.models.TempSchedule;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

public class GroupMapper {
   static public DeviceGroup fromSaveDto(SaveGroupDto groupDto){

        DeviceGroup group=new DeviceGroup();
        group.setGroupId(groupDto.getGroupId());
        group.setDescription(groupDto.getDescription());
        group.setGpsRepeat(groupDto.getGPSRepeatGap());
        group.setGpsStatus(groupDto.isGpsStatus() ? GPSStatus.ON : GPSStatus.OFF);
        group.setGroupName(groupDto.getName());
        group.setBroadCastTime(LocalTime.parse(groupDto.getStartTime()));
        return group;
    }
}
