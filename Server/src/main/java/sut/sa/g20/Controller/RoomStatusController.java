package sut.sa.g20.Controller;
import java.util.Collection;
import java.util.stream.Collectors;
import sut.sa.g20.Repository.RoomStatusRepository;
import sut.sa.g20.entity.RoomStatusEntity;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RoomStatusController{
    private RoomStatusRepository roomStatusRepository;
    public RoomStatusController(RoomStatusRepository roomStatusRepository){
        this.roomStatusRepository = roomStatusRepository;
    }
    @GetMapping("/roomstatuses")
    public Collection<RoomStatusEntity> roomStatus() {
        return roomStatusRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/roomstatus/{name}")
    public RoomStatusEntity newRoomStatus(@PathVariable String name) {
        RoomStatusEntity rst = new RoomStatusEntity(name);
        return this.roomStatusRepository.save(rst);
    }
}