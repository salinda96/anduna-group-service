package lk.andunaechomedia.services;

import lk.andunaechomedia.dtos.SaveFileDto;
import org.springframework.web.multipart.MultipartFile;


public interface FileService {
    public SaveFileDto saveFile(SaveFileDto saveFileDto, MultipartFile file);
    public boolean findFile(String fileId);
}
