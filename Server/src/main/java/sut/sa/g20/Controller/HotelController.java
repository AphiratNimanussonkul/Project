package sut.sa.g20.Controller;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import sut.sa.g20.entity.HotelEntity;
import sut.sa.g20.entity.MemberHotelEntity;
import sut.sa.g20.entity.ProvinceEntity;
import sut.sa.g20.Repository.HotelRepository;
import sut.sa.g20.Repository.MemberHotelRepository;
import sut.sa.g20.Repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HotelController{
    @Autowired
    MemberHotelRepository memberHotelRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    public HotelRepository getHotelrepository() {
        return hotelrepository;
    }

    public void setHotelrepository(HotelRepository hotelrepository) {
        this.hotelrepository = hotelrepository;
    }

    private HotelRepository hotelrepository;
    
    public HotelController (HotelRepository hotelrepository){
        this.hotelrepository = hotelrepository;
    }
    @GetMapping("/hotel/{hotelNameThai}/{name}/{villageNo}/{houseNo}/{building}/{village}/{alleyLane}/{road}/{subDistrictSubArea}/{districtArea}/{postCode}/{mobilePhone}/{phone}/{fax}/{province}/{memberName}")
    public HotelEntity newHotel(@PathVariable final String  name,@PathVariable String province,@PathVariable int villageNo
    ,@PathVariable String houseNo, @PathVariable String building, @PathVariable String village, @PathVariable String alleyLane,
    @PathVariable String road, @PathVariable String subDistrictSubArea, @PathVariable String districtArea, @PathVariable int postCode,
    @PathVariable String mobilePhone, @PathVariable String phone, @PathVariable String fax, @PathVariable String hotelNameThai,@PathVariable String memberName){
        ProvinceEntity p = provinceRepository.findByName(province);
        MemberHotelEntity member = memberHotelRepository.findByName(memberName);
        HotelEntity hotels = new HotelEntity();
        hotels.setHotelNameThai(hotelNameThai);
        hotels.setHotelNameEng(name);
        hotels.setVillageNo(villageNo);
        hotels.setHouseNo(houseNo);
        hotels.setBuilding(building);
        hotels.setVillage(village);
        hotels.setAlleyLane(alleyLane);
        hotels.setRoad(road);
        hotels.setSubDistrictSubArea(subDistrictSubArea);
        hotels.setDistrictArea(districtArea);
        hotels.setPostCode(postCode);
        hotels.setMobilePhone(mobilePhone);
        hotels.setPhone(phone);
        hotels.setFax(fax);
        hotels.setProvince(p);
        hotels.setMemberHotel(member);
        return hotelrepository.save(hotels);
    }
    @GetMapping("/hotels")
    public Collection<HotelEntity> hotel() {
        return hotelrepository.findAll().stream().collect(Collectors.toList());
    }
}