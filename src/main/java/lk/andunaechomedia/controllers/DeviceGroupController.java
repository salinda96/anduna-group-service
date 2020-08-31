package lk.andunaechomedia.controllers;

import lk.andunaechomedia.dtos.getDtos.SaveGroupDto;
import lk.andunaechomedia.models.DeviceGroup;
import lk.andunaechomedia.services.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController

@RequestMapping("/group")
@CrossOrigin(origins = "http://localhost:3000")
public class DeviceGroupController {
    @Autowired
    private GroupService groupService;

    Logger logger = LoggerFactory.getLogger(DeviceGroupController.class);

    @RequestMapping(method = RequestMethod.POST, value ="/add")
    public HttpEntity<SaveGroupDto> addGroup(@RequestBody SaveGroupDto group) {
        System.out.println( "oky");
            return  new ResponseEntity(groupService.saveGroup(group), HttpStatus.CREATED);
    }

    @RequestMapping(value="/get/all/filter/status",method = RequestMethod.POST)
    public HttpEntity<Set<DeviceGroup>> getAllDeviceWithFilterStatus(@RequestParam Boolean status){
        return new ResponseEntity<>(groupService.getDeviceGroupsByStatus(status),HttpStatus.OK);
    }

    @RequestMapping(value = "/get/all",method = RequestMethod.GET)
    public HttpEntity<List<DeviceGroup>> getAllDeviceGroup(){
    return new ResponseEntity( groupService.getAll(),HttpStatus.OK);
    }

    @RequestMapping(value = "/change/status",method = RequestMethod.PUT)
    public HttpEntity<DeviceGroup> onOffDevice(@RequestParam String id){
        try {
            return new ResponseEntity<>(groupService.changeStatus(id),HttpStatus.OK);
        }
        catch (Exception e){
            logger.error(e.toString());
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

    }
}
