package sut.sa.g20.Controller;
import java.util.Collection;
import java.util.stream.Collectors;

import sut.sa.g20.entity.HotelEntity;
import sut.sa.g20.entity.MemberHotelEntity;
import sut.sa.g20.entity.ProvinceEntity;
import sut.sa.g20.Repository.HotelRepository;
import sut.sa.g20.Repository.MemberHotelRepository;
import sut.sa.g20.Repository.ProvinceRepository;

import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MemberHotelController{
    @Autowired 
    private HotelRepository hotelRepository;

    @Autowired
    private MemberHotelRepository memberHotelRepository;
    
    public MemberHotelController (MemberHotelRepository memberHotelRepository){
        this.memberHotelRepository = memberHotelRepository;
    }
    @GetMapping("/memberhotels")
    public Collection<MemberHotelEntity> memberhotel() {
        return memberHotelRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/memberhotel/{username}/{password}")
    public MemberHotelEntity newMember(@PathVariable String username,@PathVariable Long password){
        MemberHotelEntity member = new MemberHotelEntity();
        member.setMemberHotelName(username);
        member.setMemberHotelPassword(password);
        return memberHotelRepository.save(member);
    }

    @GetMapping("/memberlogin/{username}/{password}")
    public Boolean isLogin(@PathVariable String username,@PathVariable Long password){
        Long m = memberHotelRepository.isLogin(username,password);
        if(m!=null)
            return true;
        return false;
    }
}