package lk.andunaechomedia.services.impl;

import lk.andunaechomedia.dtos.SaveFileDto;
import lk.andunaechomedia.models.File;
import lk.andunaechomedia.repositories.FileRepo;
import lk.andunaechomedia.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    FileRepo fileRepo;
    @Override
    public SaveFileDto saveFile(SaveFileDto saveFileDto, MultipartFile file)
        {
            File saveFile=new File();
            saveFile.setFile_id(saveFileDto.getFileId());
            Path path=null;
            String filename= StringUtils.cleanPath(file.getOriginalFilename());
            if(!(new java.io.File(System.getProperty("user.home")+"/andunaEcho/files").exists())){
                new java.io.File(System.getProperty("user.home")+"/andunaEcho/files").mkdirs();
            }
            path= Paths.get(System.getProperty("user.home")+"/andunaEcho/files/"+filename);
            saveFile.setFile_path(path.toString());
            fileRepo.save(saveFile);
            try {
                Files.copy(file.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
            }
            catch (IOException e){
                System.out.println(e);
            }
            return saveFileDto;
        }
        @Override
    public boolean findFile(String fileId){
        return fileRepo.existsById(fileId);
        }
}
