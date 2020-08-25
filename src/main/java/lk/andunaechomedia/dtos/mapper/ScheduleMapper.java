package lk.andunaechomedia.dtos.mapper;

import lk.andunaechomedia.dtos.GetTempVersionDto;
import lk.andunaechomedia.dtos.GetVersionDto;
import lk.andunaechomedia.dtos.SaveScheduleDto;
import lk.andunaechomedia.dtos.SaveTempScheduleDto;
import lk.andunaechomedia.models.MainSchedule;
import lk.andunaechomedia.models.TempSchedule;


public class ScheduleMapper {
    static public MainSchedule mapToModel(SaveScheduleDto scheduleDto){
        MainSchedule mainSchedule = new MainSchedule();
        mainSchedule.setScheduleId(scheduleDto.getScheduleId());
        mainSchedule.setVersion(scheduleDto.getVersion());
        mainSchedule.setStartTime(scheduleDto.getStartTime());
        return mainSchedule;
    }
    static public TempSchedule mapTempToModel(SaveTempScheduleDto saveScheduleDto){
        TempSchedule tempSchedule = new TempSchedule();
        tempSchedule.setTempId(saveScheduleDto.getScheduleId());
        tempSchedule.setVersion(saveScheduleDto.getVersion());
        return tempSchedule;
    }

    static public GetVersionDto mapToGetVersionDto(MainSchedule schedule){
        GetVersionDto version=new GetVersionDto();
        version.setCurrentVersion(schedule.getVersion());
        version.setStartTime(schedule.getStartTime());
        return version;

    }
    static public GetTempVersionDto mapToGetTempVersionDto(TempSchedule tempSchedule){
        GetTempVersionDto versionDto = new GetTempVersionDto();
        versionDto.setVersion(tempSchedule.getVersion());
        return versionDto;
    }
}
