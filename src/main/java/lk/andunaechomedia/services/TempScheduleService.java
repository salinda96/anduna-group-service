package lk.andunaechomedia.services;

import lk.andunaechomedia.dtos.GetTempVersionDto;
import lk.andunaechomedia.dtos.SaveTempScheduleDto;
import lk.andunaechomedia.models.TempSchedulePlayFile;

import java.util.Set;

public interface TempScheduleService {
    SaveTempScheduleDto saveTemp(SaveTempScheduleDto saveScheduleDto);
    GetTempVersionDto getCurrentVersion(String deviceId);
    String decrementDeviceList(String deviceId);
    Set<TempSchedulePlayFile> getTempScheduleByGroup(String grouppId);
}
