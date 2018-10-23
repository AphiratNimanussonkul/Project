package sut.sa.g20.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.sa.g20.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource
public interface RoomTypeFurnitureManyToManyRepository extends JpaRepository<RoomTypeFurnitureManyToManyEntity, Long> {
}

