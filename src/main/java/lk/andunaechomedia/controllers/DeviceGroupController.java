package lk.andunaechomedia.controllers;

import lk.andunaechomedia.dtos.SaveGroupDto;
import lk.andunaechomedia.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/group")
public class DeviceGroupController {
    @Autowired
    private GroupService groupService;


    public DeviceGroupController() {
    }

    @RequestMapping(method = {RequestMethod.POST}, value = {"/add"})
    @ResponseBody
    public HttpEntity<SaveGroupDto> addGroup(@RequestBody SaveGroupDto group) {
        System.out.println( "oky");
            return  new ResponseEntity(groupService.saveGroup(group), HttpStatus.CREATED);
    }
}
