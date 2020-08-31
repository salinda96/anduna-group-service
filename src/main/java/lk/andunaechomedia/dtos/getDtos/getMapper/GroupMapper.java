package lk.andunaechomedia.dtos.getDtos.getMapper;

import lk.andunaechomedia.constant.DeviceGroupStatus;
import lk.andunaechomedia.constant.GPSStatus;
import lk.andunaechomedia.dtos.getDtos.SaveGroupDto;
import lk.andunaechomedia.models.DeviceGroup;


import java.time.LocalTime;
public class GroupMapper {
   static public DeviceGroup fromSaveDto(SaveGroupDto groupDto){

        DeviceGroup group=new DeviceGroup();
        group.setGroupId(groupDto.getGroupId());
        group.setDescription(groupDto.getDescription());
        group.setGpsRepeat(groupDto.getGPSRepeatGap());
        group.setGpsStatus(groupDto.isGpsStatus() ? GPSStatus.ON : GPSStatus.OFF);
        group.setGroupName(groupDto.getName());
        group.setBroadCastTime(LocalTime.parse(groupDto.getStartTime()));
        group.setDeviceGroupStatus(DeviceGroupStatus.ACTIVATED);
        return group;
    }
}
