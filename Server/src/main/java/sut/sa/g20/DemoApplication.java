package sut.sa.g20;

import sut.sa.g20.Repository.HotelRepository;
import sut.sa.g20.entity.*;
import sut.sa.g20.Repository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.stream.Stream;
@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    
    @Bean
    ApplicationRunner init(MemberHotelRepository memberHotelRepository,RoomStatusRepository roomStatusRepository, ProvinceRepository provinceRepositoy, HotelRepository hotelRepository, FurnitureRepository furnitureRepository, RoomTypeRepository roomTypeRepository, RoomRepository roomRepository, RoomTypeFurnitureManyToManyRepository roomTypeFurnitureManyToManyRepository) {
        return args -> {
            //Create RoomStatusEntity
            Stream.of("ว่าง","จอง","พัก").forEach(roomstatus ->{
                RoomStatusEntity rst = new RoomStatusEntity(roomstatus);
                roomStatusRepository.save(rst);
            });
            //Create Provinces
            Stream.of("กรุงเทพมหานคร","กระบี่","กาญจนบุรี","กาฬสินธุ์","กำแพงเพชร","ขอนแก่น","จันทบุรี","ฉะเชิงเทรา","ชลบุรี","ชัยนาท"
                ,"ชัยภูมิ","ชุมพร","เชียงราย","เชียงใหม่","ตรัง","ตราด","ตาก","นครนายก","นครปฐม","นครพนม","นครราชสีมา","นครศรีธรรมราช"
                ,"นครสวรรค์","นนทบุรี","นราธิวาส","น่าน","บึงกาฬ","บุรีรัมย์","ปทุมธานี","ประจวบคีรีขันธ์","ปราจีนบุรี","ปัตตานี","พระนครศรีอยุธยา"
                ,"พังงา","พัทลุง","พิจิตร","พิษณุโลก","เพชรบุรี","เพชรบูรณ์","แพร่","พะเยา","ภูเก็ต","มหาสารคาม","มุกดาหาร","แม่ฮ่องสอน"
                ,"ยะลา","ยโสธร","ร้อยเอ็ด","ระนอง","ระยอง","ราชบุรี","ลพบุรี","ลำปาง","ลำพูน","เลย","ศรีสะเกษ","สกลนคร","สงขลา","สตูล"
                ,"สมุทรปราการ","สมุทรสงคราม","สมุทรสาคร","สระแก้ว","สระบุรี","สิงห์บุรี","สุโขทัย","สุพรรณบุรี","สุราษฎร์ธานี","สุรินทร์","หนองคาย"
                ,"หนองบัวลำภู","อ่างทอง","อุดรธานี","อุทัยธานี","อุตรดิตถ์","อุบลราชธานี","อำนาจเจริญ").forEach(province -> {
                ProvinceEntity provinces = new ProvinceEntity(province);
                provinceRepositoy.save(provinces);
            });
            //Create Furniture
            Stream.of("Table","OfficeTable","Microwave","Sofa").forEach(furniture -> {
                FurnitureEntity fr = new FurnitureEntity(furniture);
                furnitureRepository.save(fr);
            });
            //Create RoomType
            Stream.of("Standard","Suite","Deluxe","Superior").forEach(roomType -> {
                if(roomType == "Standard"){
                    RoomTypeEntity rt = new RoomTypeEntity();
                    rt.setRoomType(roomType);
                    rt.setBedType("Single");
                    rt.setNumberOfBed(1);
                    rt.setMaxPeople(2);
                    roomTypeRepository.save(rt);
                }
                if(roomType == "Suite"){
                    RoomTypeEntity rt = new RoomTypeEntity();
                    rt.setRoomType(roomType);
                    rt.setBedType("Twice");
                    rt.setNumberOfBed(1);
                    rt.setMaxPeople(3);
                    roomTypeRepository.save(rt);
                }
                if(roomType == "Deluxe"){
                    RoomTypeEntity rt = new RoomTypeEntity();
                    rt.setRoomType(roomType);
                    rt.setBedType("Twice");
                    rt.setNumberOfBed(1);
                    rt.setMaxPeople(3);
                    roomTypeRepository.save(rt);
                }
                if(roomType == "Superior"){
                    RoomTypeEntity rt = new RoomTypeEntity();
                    rt.setRoomType(roomType);
                    rt.setBedType("Twice");
                    rt.setNumberOfBed(2);
                    rt.setMaxPeople(6);
                    roomTypeRepository.save(rt);
                }
            });
            //Create RoomTypeNameManyToMany
            Stream.of("Table","OfficeTable","Microwave","Sofa").forEach(furniture -> {
                Stream.of("Standard","Suite","Deluxe","Superior").forEach(roomType -> {
                    FurnitureEntity fr = furnitureRepository.findByName(furniture);
                    RoomTypeEntity rt = roomTypeRepository.findByName(roomType);
                    RoomTypeFurnitureManyToManyEntity rtf = new RoomTypeFurnitureManyToManyEntity(fr,rt);
                    roomTypeFurnitureManyToManyRepository.save(rtf);
                });
                
            });
            //Create Member
            MemberHotelEntity mem = new MemberHotelEntity();
            mem.setMemberHotelName("Aphirat");
            mem.setMemberHotelPassword(1234L);
            memberHotelRepository.save(mem);

            MemberHotelEntity mem2 = new MemberHotelEntity();
            mem2.setMemberHotelName("Pitchayut");
            mem2.setMemberHotelPassword(1234L);
            memberHotelRepository.save(mem2);

            //Create Hotel
            ProvinceEntity p = provinceRepositoy.findByName("นครราชสีมา");
            MemberHotelEntity m = memberHotelRepository.findByName("Aphirat");
            MemberHotelEntity m2 = memberHotelRepository.findByName("Pitchayut");
            HotelEntity hotels = new HotelEntity("พิมายอินทร์","PhimaiIn",25,"403","-","หนองบัว","-","-","Boat","Phimai",30110,"0862505906","044442222","14646454",p,m);
            hotelRepository.save(hotels);
            HotelEntity hotel = new HotelEntity("อมาทารา","Amathra",25,"425","-","ในเมือง","-","-","Naimung","Phimai",30110,"0844444466","044125365","4451121",p,m2);
            hotelRepository.save(hotel);
            
        };

    }

}
