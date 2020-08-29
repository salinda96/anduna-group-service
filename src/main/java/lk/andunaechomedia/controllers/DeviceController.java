package lk.andunaechomedia.controllers;


import lk.andunaechomedia.dtos.SaveDeviceDto;
import lk.andunaechomedia.dtos.SaveGroupDto;
import lk.andunaechomedia.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @RequestMapping(method = {RequestMethod.POST}, value = {"/add"})
    @ResponseBody
    public HttpEntity<SaveDeviceDto> addDevice(@RequestBody SaveDeviceDto device) {
        System.out.println( "oky");
        return  new ResponseEntity(deviceService.saveDevice(device), HttpStatus.CREATED);
    }
}
