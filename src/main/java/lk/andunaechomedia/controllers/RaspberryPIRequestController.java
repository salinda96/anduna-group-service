package lk.andunaechomedia.controllers;

import lk.andunaechomedia.models.MainSchedulePlayFile;
import lk.andunaechomedia.models.TempSchedulePlayFile;
import lk.andunaechomedia.repositories.DeviceRepo;
import lk.andunaechomedia.repositories.FileRepo;
import lk.andunaechomedia.repositories.MainSchedulePlayFileRepo;
import lk.andunaechomedia.repositories.TempSchedulePlayFileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


@RestController
public class RaspberryPIRequestController {
    @Autowired
    DeviceRepo deviceRepo;
    @Autowired
    MainSchedulePlayFileRepo mainSchedulePlayFileRepo;
    @Autowired
    FileRepo fileRepo;
    @Autowired
    TempSchedulePlayFileRepo tempSchedulePlayFileRepo;

    @RequestMapping(method = RequestMethod.GET,value = "/get/rapPI/schedule/{deviceId}")
    public ArrayList<HashMap<String,String> >getSchedules(@PathVariable String deviceId){

        ArrayList data =new <HashMap<String,String>>ArrayList();
        ;
       Set<MainSchedulePlayFile> mainScheduleHasFile=mainSchedulePlayFileRepo.findByMainSchedule(deviceRepo
                .findById(deviceId)
                .get().getDeviceGroup()
                .getMainSchedule().getScheduleId());

       mainScheduleHasFile.forEach((schedules)->{
           HashMap schedule=new HashMap<String,String>();
           lk.andunaechomedia.models.File file=fileRepo.findById(schedules.getFile()).get();
           String name=new File(file.getFile_path()).getName();
           schedule.put("fileId",file.getFile_id());
           schedule.put("link",ServletUriComponentsBuilder.fromCurrentContextPath().path("/download/file/").path(name).toUriString());
           schedule.put("playPoint",Integer.toString(schedules.getPlayPoint()));
            data.add(schedule);

       });




        return data;
    }

    @RequestMapping(value = "/get/rasPi/poster/{deviceId}", method = RequestMethod.GET)
    public ArrayList<HashMap<String,String>> getPoster(@PathVariable String deviceId){
        ArrayList <HashMap<String,String >> posterData = new ArrayList<>();
        Set<TempSchedulePlayFile> posters = tempSchedulePlayFileRepo.findByTempScheduleId(deviceRepo.findById(deviceId).get().getDeviceGroup().getTempSchedule().getTempId());
        posters.forEach((poster)->{
            HashMap posterSchedule = new HashMap<String ,String>();
            lk.andunaechomedia.models.File file = fileRepo.findById(poster.getFileId()).get();
            String fileName = new File(file.getFile_path()).getName();
            posterSchedule.put("startTime",poster.getStartTime());
            posterSchedule.put("id",file.getFile_id());
            posterSchedule.put("link",ServletUriComponentsBuilder.fromCurrentContextPath().path("/download/file/").path(fileName).toUriString());
            posterSchedule.put("duration",Integer.toString(poster.getDuration()));
            posterData.add(posterSchedule);

        });
        return posterData;
    }

@RequestMapping(method = RequestMethod.GET,value = "/download/file/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request){
        Path path =Paths.get(System.getProperty("user.home")+"/andunaEcho/files").toAbsolutePath().normalize().resolve(fileName).normalize();
        Resource resource=null;
        String contentType=null;
        try {
            resource=new UrlResource(path.toUri());
            if(resource.exists()){
                contentType=request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
            }
        }
        catch (MalformedURLException e){

        }
        catch (IOException ioE){

        }
         if(contentType==null){
             contentType="multipart/form-data" ;

         }


        return ResponseEntity.ok().
        contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename\""+resource.getFilename()+"\"")
                .body(resource);
    }


}

//    private static final String EXTERNAL_FILE_PATH = "/andunaEcho/files/";
//
//    @RequestMapping(value = "/download//file/{fileName:.+}",method = RequestMethod.GET)
//    public void downloadPDFResource(HttpServletRequest request, HttpServletResponse response,
//                                    @PathVariable("fileName") String fileName) throws IOException {
//
//        File file = new File(EXTERNAL_FILE_PATH + fileName);
//        if (file.exists()) {
//
//            //get the mimetype
//            String mimeType = URLConnection.guessContentTypeFromName(file.getName());
//            if (mimeType == null) {
//                //unknown mimetype so set the mimetype to application/octet-stream
//                mimeType = "application/octet-stream";
//            }
//
//            response.setContentType(mimeType);
//
//            /**
//             * In a regular HTTP response, the Content-Disposition response header is a
//             * header indicating if the content is expected to be displayed inline in the
//             * browser, that is, as a Web page or as part of a Web page, or as an
//             * attachment, that is downloaded and saved locally.
//             *
//             */
//
//            /**
//             * Here we have mentioned it to show inline
//             */
//            response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
//
//            //Here we have mentioned it to show as attachment
//            //response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));
//
//            response.setContentLength((int) file.length());
//
//            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
//
//            FileCopyUtils.copy(inputStream, response.getOutputStream());
//
//        }
//    }