package lk.andunaechomedia.services;

import lk.andunaechomedia.dtos.SaveGroupDto;
import org.springframework.stereotype.Service;

@Service
public interface GroupService {
    public SaveGroupDto saveGroup(SaveGroupDto group);
}
