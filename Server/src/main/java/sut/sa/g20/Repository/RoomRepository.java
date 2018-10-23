package sut.sa.g20.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sut.sa.g20.entity.HotelEntity;
import sut.sa.g20.entity.RoomEntity;
import sut.sa.g20.entity.RoomStatusEntity;
import sut.sa.g20.entity.RoomTypeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
    @Query("SELECT t.roomNumber FROM RoomEntity t WHERE t.roomNumber = :Name")
    Integer findByRoomNumber(@Param("Name")int Name);

    @Query("SELECT t.hotel.hotelId FROM RoomEntity t WHERE t.hotel.hotelId = :id and t.roomNumber = :roomNumber")
    Long findByHotelId(@Param("id")Long id,@Param("roomNumber")int roomNumber);

 /*   @Query("UPDATE RoomEntity t SET t.roomNumber = :roomNumber, t.roomPrice = :price, t.hotel = :hotel, t.roomtype = :roomType, t.roomstatus = :roomStatus WHERE t.roomsId = :roomsId")
    void editRoom(@Param("roomsId") Long roomsId,@Param("roomNumber")int roomNumber,@Param("price")int price ,@Param("hotel")HotelEntity hotel,@Param("roomType")RoomTypeEntity roomType, @Param("roomStatus")RoomStatusEntity roomStatus);*/
}