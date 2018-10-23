package sut.sa.g20.Controller;

import sut.sa.g20.Repository.*;
import sut.sa.g20.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RoomController{
    int count = 0;
    int status = 0;
    @Autowired
    private MemberHotelRepository memberHotelRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomTypeRepository roomtypeRepository;

    @Autowired
    private RoomStatusRepository roomStatusRepository;

    private RoomRepository roomsrepository;
    public RoomController(RoomRepository roomsrepository) {
        this.roomsrepository = roomsrepository;
    }
    @PostMapping("/room/{roomType}/{roomstatus}/{number}/{price}/{roomImg}/{memberUserName}")
    public Boolean update(@RequestBody String room,@PathVariable String memberUserName, @PathVariable String roomType, @PathVariable String roomstatus, @PathVariable final int number, @PathVariable int price,@PathVariable String roomImg)throws JsonParseException, IOException {
        final String decoded = URLDecoder.decode(room, "UTF-8");
        room = decoded;

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(room);
        JsonNode jsonImg = actualObj.get("imgSelect");

        if(count != 0) {
            Long mem = memberHotelRepository.findId(memberUserName);
            Long hotelIdFromName = hotelRepository.findHotelIdByMemId(mem);
            System.out.println(hotelIdFromName);
            Long hotelIdFromeId = roomsrepository.findByHotelId(hotelIdFromName,number);
            System.out.println(hotelIdFromeId);
            if(hotelIdFromeId != null )
                status = 1;
            else
                status = 0;
        }
        if(status == 0) {
            Long mem = memberHotelRepository.findId(memberUserName);
            RoomStatusEntity rst = roomStatusRepository.findByName(roomstatus);
            HotelEntity hotels = hotelRepository.findHotelByMemberId(mem);
            RoomTypeEntity rt = roomtypeRepository.findByName(roomType);
            RoomEntity no1 = new RoomEntity();
            no1.setRoomNumber(number);
            no1.setRoomPrice(price);
            no1.setHotel(hotels);
            no1.setRoomtype(rt);
            no1.setRoomstatus(rst);
            no1.setRoomImg(jsonImg.textValue());
            roomsrepository.save(no1);
            roomsrepository.findAll().stream().collect(Collectors.toList());
            count++;
            return true;  
        }
        return false;
    }
    @GetMapping("/rooms")
    public Collection<RoomEntity> Rooms() {
        return roomsrepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @PutMapping("/updateroomstatus/{roomId}/{hotel}/{roomType}/{roomstatus}/{number}/{price}")
    public RoomEntity editRoom(@RequestBody RoomEntity room,@PathVariable Long roomId,@PathVariable String hotel, @PathVariable String roomType, @PathVariable String roomstatus, @PathVariable final int number, @PathVariable int price){
        HotelEntity ho = hotelRepository.findByName(hotel);
        RoomTypeEntity rt = roomtypeRepository.findByName(roomType);
        RoomStatusEntity rst = roomStatusRepository.findByName(roomstatus);
        return roomsrepository.findById(roomId).map(roomedit ->{
                    roomedit.setRoomNumber(number);
                    roomedit.setRoomPrice(price);
                    roomedit.setRoomstatus(rst);
                    roomedit.setHotel(ho);
                    roomedit.setRoomtype(rt);
                    return roomsrepository.save(roomedit);
                }
                ).orElseGet(() ->{
                    return roomsrepository.save(room);
        });  
    }



}