package lk.andunaechomedia.controllers;

import lk.andunaechomedia.dtos.GetTempVersionDto;
import lk.andunaechomedia.dtos.SaveTempScheduleDto;
import lk.andunaechomedia.models.DeviceGroup;
import lk.andunaechomedia.models.File;
import lk.andunaechomedia.models.TempSchedule;
import lk.andunaechomedia.models.TempSchedulePlayFile;
import lk.andunaechomedia.repositories.DeviceGroupRepo;
import lk.andunaechomedia.repositories.FileRepo;
import lk.andunaechomedia.repositories.TempSchedulePlayFileRepo;
import lk.andunaechomedia.repositories.TempScheduleRepo;
import lk.andunaechomedia.services.FileService;
import lk.andunaechomedia.services.TempScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@Transactional
@RequestMapping(value = "/postertype")
//@CrossOrigin(origins = "http://159.203.185.33:3000")
public class Temp_scheduleController {

    @Autowired
    TempScheduleRepo tempScheduleRepo;

    @Autowired
    DeviceGroupRepo deviceGroupRepo;

    @Autowired
    FileRepo fileRepo;

    @Autowired
    FileService fileService;

    @Autowired
    TempScheduleService tempScheduleService;

    @Autowired
    TempSchedulePlayFileRepo tempSchedulePlayFileRepo;

    @RequestMapping(path = {"/add/poster"}, method = RequestMethod.POST)
    public HttpEntity<SaveTempScheduleDto> addPosterSchedule(@RequestBody SaveTempScheduleDto saveScheduleDto) {
        try {
            return new ResponseEntity(tempScheduleService.saveTemp(saveScheduleDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(saveScheduleDto, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "get/version/{deviceId}", method = RequestMethod.GET)
    public HttpEntity<GetTempVersionDto> getVersion(@PathVariable String deviceId) {
        return new ResponseEntity(tempScheduleService.getCurrentVersion(deviceId), HttpStatus.OK);
    }

    @RequestMapping(path = {"/add/poster/images/{group_id}"}, method = RequestMethod.POST)
    public String addPoster(@RequestBody ArrayList<HashMap<String, String>> posterId, @PathVariable String group_id) {
        String result = null;
        DeviceGroup deviceGroup = deviceGroupRepo.findById(group_id).get();
        TempSchedule tempSchedule = deviceGroup.getTempSchedule();
        System.out.println(tempSchedule.getTempId());
        tempSchedulePlayFileRepo.deleteByTempScheduleId(tempSchedule.getTempId());

        try {
            posterId.forEach((poster) -> {
                File file = fileRepo.getOne(poster.get("id"));
                tempSchedulePlayFileRepo.save(new TempSchedulePlayFile(tempSchedule.getTempId(), poster.get("startTime"),
                        file.getFile_id(), Integer.parseInt(poster.get("duration"))));
            });
            tempSchedule.setNoOf_devices(deviceGroup.getDevices().size());
            tempSchedule.setVersion(tempSchedule.getVersion() + 1);
            tempScheduleRepo.save(tempSchedule);
            result = "succussfully added poster schedule to " + deviceGroup.getGroupName() + " group";
        } catch (Exception e) {
            result = "Ooops... Something went wrong...!";
        }
        return result;
    }

    @RequestMapping(value = "/finish/{device_id}", method = RequestMethod.GET)
    public HttpEntity<String> tempDownloadFinish(@PathVariable String device_id) {
        return new ResponseEntity<>(tempScheduleService.decrementDeviceList(device_id), HttpStatus.OK);
    }

    @RequestMapping(value = "/findFile/{fileId}", method = RequestMethod.GET)
    public HttpEntity<Boolean> searchFile(@PathVariable String fileId){
        return new ResponseEntity(fileService.findFile(fileId),HttpStatus.OK);
    }

    @RequestMapping(value = "/get/tempSchedule/{groupId}", method = RequestMethod.GET)
    public HttpEntity<TempSchedulePlayFile> getTempScheduleByGroup(@PathVariable String groupId){
        return new ResponseEntity(tempScheduleService.getTempScheduleByGroup(groupId),HttpStatus.OK);
    }


}
/*
//package lk.andunaechomedia.controllers;
//
//import lk.andunaechomedia.models.Temp_schedule;
//import lk.andunaechomedia.repositories.Temp_scheduleRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//
//@RestController
//public class Temp_scheduleController {
//
//    @Autowired
//    Temp_scheduleRepo temp_scheduleRepo;
//
//    @RequestMapping(method = RequestMethod.POST, path = "/upload/temp_schedule")
//    public String temp_schedule_upload(@RequestParam MultipartFile temp_schedule_file, @RequestParam String temp_id, String version){
//        Temp_schedule temp_schedule = new Temp_schedule();
//        temp_schedule.setTemp_id(temp_id);
//        temp_schedule.setVersion(version);
//        String temp_name = StringUtils.cleanPath(temp_schedule_file.getOriginalFilename());
//        Path path = Paths.get("/home/lapaty/Desktop/video/schedule/temp/"+temp_id+" "+version);
//        try {
//            Files.copy(temp_schedule_file.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        temp_scheduleRepo.save(temp_schedule);
//        return "Temp schedule upload Successfully...!";
//    }
//}
//*/
//





//    @RequestMapping(value = {"/add/temp_schedule"})
//    public HttpEntity<SaveScheduleDto> addTempSchedule(@RequestBody SaveScheduleDto saveScheduleDto){
//        return new ResponseEntity(ScheduleMapper.mapTempToModel(saveScheduleDto), HttpStatus.CREATED);
//    }
//
//    @RequestMapping(method = RequestMethod.POST,value = {"/add/temp_schedule/poster/{group_id}"})
//    public HttpEntity<String> addPoster(@RequestBody ArrayList<HashMap<String,String>> poster_id, @RequestParam String group_id){
//        String result = null;
//
//        try {
//            return new ResponseEntity<>(tempScheduleService.saveTemp(ScheduleMapper.mapTempToModel(poster_id,group_id)));
//        }
//    }
//}