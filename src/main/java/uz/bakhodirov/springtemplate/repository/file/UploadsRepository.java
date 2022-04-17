package uz.bakhodirov.springtemplate.repository.file;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.bakhodirov.springtemplate.entity.file.Uploads;

import java.util.Optional;

public interface UploadsRepository extends JpaRepository<Uploads,Long> {
    Optional<Uploads> findByGeneratedName(String filename);
}
