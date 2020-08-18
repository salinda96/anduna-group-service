package lk.andunaechomedia.controllers;

import lk.andunaechomedia.dtos.SaveDeviceDto;
import lk.andunaechomedia.dtos.SaveFileDto;
import lk.andunaechomedia.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
//@CrossOrigin(origins = "http://159.203.185.33:3000")
public class FileController {
    @Autowired
    FileService fileService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public HttpEntity<SaveFileDto> fileUpload(@ModelAttribute  SaveFileDto fileDetails, @RequestParam MultipartFile file) {
        return new  ResponseEntity(fileService.saveFile(fileDetails,file), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/poster/upload", method = RequestMethod.POST)
    public HttpEntity<SaveFileDto> posterUpload(@ModelAttribute SaveFileDto posterDetails, @RequestParam MultipartFile file){
        return new ResponseEntity<>(fileService.saveFile(posterDetails,file),HttpStatus.CREATED);
    }

}


