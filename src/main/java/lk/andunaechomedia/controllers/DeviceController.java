package lk.andunaechomedia.controllers;

import lk.andunaechomedia.dtos.getDtos.AddDeviceDto;
import lk.andunaechomedia.dtos.sendDtos.SendDeviceDto;
import lk.andunaechomedia.dtos.sendDtos.SendDeviceDetailsDto;
import lk.andunaechomedia.models.Device;
import lk.andunaechomedia.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/device")
@CrossOrigin(origins = "http://localhost:3000")
public class DeviceController {
    @Autowired
   private DeviceService deviceService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public HttpEntity<AddDeviceDto> addDevice(@RequestBody AddDeviceDto newDevice) {

        try {
            return  new ResponseEntity(deviceService.addDevice(newDevice), HttpStatus.CREATED);


        }
        catch (Exception e){
            return  new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/all/{groupId}")
    public HttpEntity<List<SendDeviceDto>> getDevicesByGroupId(@PathVariable String groupId){

        try {
           return new ResponseEntity(deviceService.findAllByGroupId(groupId),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(null,HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/changeStatus",method = RequestMethod.PUT)
    public HttpEntity<Device> changeDeviceStatus(@RequestParam String id){
        try{
            return new ResponseEntity(deviceService.changeDeviceStatus(id),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(null,HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(method = RequestMethod.GET,value = "/get/details/device/{id}")
    public HttpEntity<SendDeviceDetailsDto>  deviceReportDetails(@PathVariable String id){
        try {
            return new ResponseEntity(deviceService.deviceReportDetails(id),HttpStatus.OK);
        }
        catch (Exception e) {
            return  new ResponseEntity(null,HttpStatus.NOT_FOUND);
        }

    }


}
