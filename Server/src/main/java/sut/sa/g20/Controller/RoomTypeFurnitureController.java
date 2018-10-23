package sut.sa.g20.Controller;
import sut.sa.g20.entity.*;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sut.sa.g20.Repository.*;

import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RoomTypeFurnitureController {
    @Autowired 
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private FurnitureRepository furnitureRepository;

    private RoomTypeFurnitureManyToManyRepository roomTypeFurnitureManyToManyRepository;

    public RoomTypeFurnitureController(RoomTypeFurnitureManyToManyRepository roomTypeFurnitureManyToManyRepository) {
        this.roomTypeFurnitureManyToManyRepository = roomTypeFurnitureManyToManyRepository;
    }
    @GetMapping("/roomtypefurniture/{roomtype}/{furniture}")
    public RoomTypeFurnitureManyToManyEntity newRoomType(@PathVariable final String  roomtype, @PathVariable final String furniture){
        FurnitureEntity fr = furnitureRepository.findByName(furniture);
        RoomTypeEntity rt = roomTypeRepository.findByName(roomtype);
        RoomTypeFurnitureManyToManyEntity rtf = new RoomTypeFurnitureManyToManyEntity();
        rtf.setFurnitureFurnitureRoomTypeManyMany(fr);
        rtf.setRoomtypeFurnitureMany(rt);
        return roomTypeFurnitureManyToManyRepository.save(rtf);
    }
    @GetMapping("/roomtypefurnitures")
    public Collection<RoomTypeFurnitureManyToManyEntity> roomtype_furniture() {
        return roomTypeFurnitureManyToManyRepository.findAll().stream().collect(Collectors.toList());
    }

}
