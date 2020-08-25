package lk.andunaechomedia.controllers;

import lk.andunaechomedia.dtos.SaveDeviceDto;
import lk.andunaechomedia.models.Device;
import lk.andunaechomedia.services.GroupService;
import lk.andunaechomedia.services.impl.DeviceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
//@CrossOrigin(origins = "http://159.203.185.33:3000")
public class DeviceController  {

    @Autowired
    private DeviceServiceImpl deviceService;
    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/get/devices/{groupId}", method = RequestMethod.GET)
    public HttpEntity<Set<Device>> getDevices(@PathVariable String groupId){
        return new ResponseEntity(groupService.getDevicesByGroupId(groupId),HttpStatus.OK);
    }


    @RequestMapping(method = {RequestMethod.POST}, value = {"/add/Device"})
    @ResponseBody
    public HttpEntity<SaveDeviceDto> addDevice(@RequestBody SaveDeviceDto saveDeviceDto){
        try {
            return new ResponseEntity<SaveDeviceDto>(deviceService.saveDevice(saveDeviceDto), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<SaveDeviceDto>(saveDeviceDto,HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/device/{device_id}")
    public HttpEntity<String> deleteDevice(@PathVariable String device_id){

        try {
            return new ResponseEntity<String>(deviceService.removeDevice(device_id),HttpStatus.OK);

        }
        catch (Exception e){
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }



}
//    @RequestMapping(method = {RequestMethod.DELETE}, value = {"/delete/device"})
//    @ResponseBody
//    public HttpEntity<SaveDeviceDto> deleteDevice(SaveDeviceDto saveDeviceDto){
//        try {
//            return new ResponseEntity<>(deviceService.removeDevice(saveDeviceDto),HttpStatus.OK);
//        }
//        catch (Exception e){
//            return new ResponseEntity<>(saveDeviceDto,HttpStatus.NOT_ACCEPTABLE);
//        }
//    }




//    @RequestMapping(method=RequestMethod.GET,value = "/get/device/all")
//    public @ResponseBody Iterable<Device> getAll(){
//
//        return  deviceRepo.findAll();
//    }
//
//    @RequestMapping(method = RequestMethod.GET,value="/get/device/{id}")
//    public @ResponseBody
//    Device getOne(@PathVariable String id){
//        Device device=deviceRepo.findById(id).get();
//        return device;
//    }

//    @RequestMapping(method = RequestMethod.POST,value = "/add/device")
//    public @ResponseBody
//    HttpEntity <Device> addDevice(@RequestBody Device group){
//        return new HttpEntity<Device>() ;
//    }
//
//    @RequestMapping(method = RequestMethod.PUT, value = "/update/device")
//    public @ResponseBody String updateDevice(@RequestBody Device device){
//        Device updateDevice=deviceRepo.findById(device.getDeviceId()).get();
//        updateDevice.setPublishDate(device.getPublishDate());
//        updateDevice.setCustomerName(device.getCustomerName());
//        updateDevice.setTelNumber(device.getTelNumber());
//        updateDevice.setDeviceAddress(device.getDeviceAddress());
//        updateDevice.setEndPoint(device.getEndPoint());
//        updateDevice.setStartPoint(device.getStartPoint());
//        try {
//            deviceRepo.save(updateDevice);
//            return "upload successful";
//        }
//        catch (Exception e){
//            return "upload error";
//        }
//    }
//
//
//