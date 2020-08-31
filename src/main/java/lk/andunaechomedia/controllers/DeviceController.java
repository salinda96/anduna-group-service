package lk.andunaechomedia.controllers;

import lk.andunaechomedia.dtos.AddDeviceDto;
import lk.andunaechomedia.services.impl.DeviceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    DeviceServiceImpl addDeviceService;


    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public HttpEntity<AddDeviceDto> addDevice(@RequestBody AddDeviceDto newDevice) {

        try {
            return  new ResponseEntity(addDeviceService.addDevice(newDevice), HttpStatus.CREATED);


        }
        catch (Exception e){
            return  new ResponseEntity(null, HttpStatus.NOT_ACCEPTABLE);
        }

    }

}
