package lk.andunaechomedia.controllers;

import lk.andunaechomedia.dtos.SaveGroupDto;
import lk.andunaechomedia.models.DeviceGroup;
import lk.andunaechomedia.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/group")
public class DeviceGroupController {
    @Autowired
    private GroupService groupService;


    @RequestMapping(method = RequestMethod.POST, value ="/add")
    public HttpEntity<SaveGroupDto> addGroup(@RequestBody SaveGroupDto group) {
        System.out.println( "oky");
            return  new ResponseEntity(groupService.saveGroup(group), HttpStatus.CREATED);
    }

    @RequestMapping(value="/get/all/filter/status",method = RequestMethod.POST)
    public HttpEntity<Set<DeviceGroup>> getAllDeviceWithFilterStatus(@RequestParam Boolean status){
        return new ResponseEntity<>(groupService.getDeviceGroupsByStatus(status),HttpStatus.OK);
    }
    @RequestMapping(value = "/get/all",method = RequestMethod.POST)
    public List<DeviceGroup> getAllDeviceGroup(){
    return groupService.getAll();
    }

    @RequestMapping(value = "/change/status",method = RequestMethod.PUT)
    public DeviceGroup onOffDevice(@RequestParam String id){
        return groupService.changeStatus(id);
    }
}
