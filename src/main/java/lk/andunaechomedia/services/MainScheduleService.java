package lk.andunaechomedia.services;

import lk.andunaechomedia.dtos.GetVersionDto;
import lk.andunaechomedia.dtos.SaveScheduleDto;
import lk.andunaechomedia.models.MainSchedulePlayFile;

import java.util.Set;

public interface MainScheduleService {
    public SaveScheduleDto save(SaveScheduleDto scheduleDto);
    public GetVersionDto getCurrentVersion(String deviceId);
    public String decrementDevicesList(String deviceId);
    public Set<MainSchedulePlayFile> getScheduleByGroup(String groupId);
}
