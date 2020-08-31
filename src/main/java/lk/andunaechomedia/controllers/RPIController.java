package lk.andunaechomedia.controllers;

import lk.andunaechomedia.dtos.sendDtos.SendRPIStatusDto;
import lk.andunaechomedia.services.RPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/RPI")
public class RPIController {
    @Autowired
    RPIService rpiService;
    @RequestMapping(value = "/get/status/{deviceId}",method = RequestMethod.GET)
    public HttpEntity<SendRPIStatusDto> getStatus(@PathVariable String deviceId){
        try {
            return new ResponseEntity(rpiService.getDeviceStatus(deviceId), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return  new ResponseEntity(null,HttpStatus.NOT_FOUND);
        }

    }
}
