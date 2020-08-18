package lk.andunaechomedia.dtos.mapper;

import lk.andunaechomedia.dtos.SaveGroupDto;
import lk.andunaechomedia.models.DeviceGroup;
import lk.andunaechomedia.models.TempSchedule;

public class GroupMapper {
   static public DeviceGroup mapToModel(SaveGroupDto groupDto, TempSchedule tempSchedule){
        DeviceGroup group=new DeviceGroup();
        group.setGroupId(groupDto.getGroupId());
        group.setGroupName(groupDto.getName());
        group.setTempSchedule(tempSchedule);

        return group;
    }
}
