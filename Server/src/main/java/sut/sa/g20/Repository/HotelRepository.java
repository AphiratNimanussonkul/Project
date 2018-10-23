package sut.sa.g20.Repository;

import sut.sa.g20.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource
public interface HotelRepository extends JpaRepository<HotelEntity, Long> {
    @Query("SELECT t FROM HotelEntity t WHERE t.hotelNameEng = :Name")
    HotelEntity findByName(@Param("Name")String Name);

    @Query("SELECT t.hotelId FROM HotelEntity t WHERE t.hotelNameEng = :Name")
    Long findByHotelName(@Param("Name")String Name);

    @Query("SELECT t FROM HotelEntity t WHERE t.memberHotel.memberHotelId  = :id")
    HotelEntity findHotelByMemberId(@Param("id")Long id);

    @Query("SELECT t.hotelId FROM HotelEntity t WHERE t.memberHotel.memberHotelId = :id")
    Long findHotelIdByMemId(@Param("id")Long id);
}