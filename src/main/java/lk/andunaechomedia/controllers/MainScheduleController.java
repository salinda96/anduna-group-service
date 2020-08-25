package lk.andunaechomedia.controllers;

import java.util.*;

import lk.andunaechomedia.dtos.GetVersionDto;
import lk.andunaechomedia.dtos.SaveScheduleDto;
import lk.andunaechomedia.models.DeviceGroup;
import lk.andunaechomedia.models.File;
import lk.andunaechomedia.models.MainSchedule;
import lk.andunaechomedia.models.MainSchedulePlayFile;
import lk.andunaechomedia.repositories.DeviceGroupRepo;
import lk.andunaechomedia.repositories.FileRepo;

import lk.andunaechomedia.repositories.MainSchedulePlayFileRepo;
import lk.andunaechomedia.repositories.MainScheduleRepo;
import lk.andunaechomedia.services.FileService;
import lk.andunaechomedia.services.MainScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@Transactional
@RequestMapping(value = "/mainSchedule")
//@CrossOrigin(origins = "http://159.203.185.33:3000")
public class MainScheduleController {
    @Autowired
    MainScheduleRepo mainScheduleRepo;

    @Autowired
    DeviceGroupRepo groupRepo;

    DeviceGroup deviceGroup;

    @Autowired
    FileRepo fileRepo;

    @Autowired
    MainScheduleService scheduleService;

    @Autowired
    FileService fileService;
    @Autowired
    MainSchedulePlayFileRepo mainSchedulePlayFileRepo;

    @RequestMapping(value = "/get/schedules/{groupId}", method = RequestMethod.GET)
    public HttpEntity<Set<MainSchedulePlayFile>> getScheduleByGroup(@PathVariable String groupId){
        return new ResponseEntity(scheduleService.getScheduleByGroup(groupId),HttpStatus.OK);
    }

    @RequestMapping(method = {RequestMethod.POST}, path = {"/add/main_schedule"})
    public HttpEntity<SaveScheduleDto> mainScheduleUpload(@RequestBody SaveScheduleDto main_schedule) {
        return new ResponseEntity(scheduleService.save(main_schedule), HttpStatus.CREATED);
    }

    @RequestMapping(method = {RequestMethod.POST}, path = {"/add/main_schedule/videos/{groupid}"})
    public String addVideo(@RequestBody ArrayList<HashMap<String, String>> videoId, @PathVariable String groupid) {
        String result = null;

        DeviceGroup group = groupRepo.getOne(groupid);
        MainSchedule mainSchedule = group.getMainSchedule();
        mainSchedulePlayFileRepo.deleteByMainSchedule(mainSchedule.getScheduleId());



        try {
            videoId.forEach((item) -> {
                File file = fileRepo.getOne(item.get("id"));
                mainSchedulePlayFileRepo.save(new MainSchedulePlayFile(mainSchedule.getScheduleId(),
                        file.getFile_id(),
                        Integer.parseInt(item.get("point"))));


            });
            mainSchedule.setNoOf_devices(group.getDevices().size());
            mainScheduleRepo.save(mainSchedule);
            mainSchedule.setVersion(mainSchedule.getVersion()+1);
            result = "Successfully added main Schedule to " + group.getGroupName() + "group";
        } catch (Exception e) {
            System.out.println(deviceGroup);
            result = "Oops..! \nSomething have error";
        }

        return result;
    }

    @RequestMapping(value = "/finish/{id}",method = RequestMethod.GET)
    public HttpEntity<String> finishDownload(@PathVariable String id){
       return new ResponseEntity<>(scheduleService.decrementDevicesList(id),HttpStatus.OK) ;

    }

    @RequestMapping(value = "/findFile/{fileId}", method = RequestMethod.GET)
    public HttpEntity<Boolean> searchFile(@PathVariable String fileId){
        return new ResponseEntity(fileService.findFile(fileId),HttpStatus.OK);
    }

    @RequestMapping(method = {RequestMethod.GET}, value = {"/get/main_schedule/{id}"})
    @ResponseBody
    public Optional<MainSchedule> getSchedule(@PathVariable String id) {
        System.out.println(id);
        return this.mainScheduleRepo.findById(id);
    }
    @GetMapping("/get/version/{deviceId}")
    public HttpEntity<GetVersionDto> getMainScheduleVersion(@PathVariable String deviceId){
       return new  ResponseEntity(scheduleService.getCurrentVersion(deviceId),HttpStatus.ACCEPTED);
    }
}
