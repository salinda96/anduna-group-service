package lk.andunaechomedia.repositories;

import lk.andunaechomedia.models.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepo extends JpaRepository<File,String> {

}