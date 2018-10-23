package sut.sa.g20.Repository;

import sut.sa.g20.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource
public interface ProvinceRepository extends JpaRepository<ProvinceEntity, Long> {
    @Query("SELECT t FROM ProvinceEntity t WHERE t.provinceName = :Name")
    ProvinceEntity findByName(@Param ("Name") String Name);
}


