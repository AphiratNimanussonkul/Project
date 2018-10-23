package sut.sa.g20.Controller;
import java.util.Collection;
import java.util.stream.Collectors;

import sut.sa.g20.Repository.ProvinceRepository;

import sut.sa.g20.entity.ProvinceEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProvincesController{
    private ProvinceRepository provinceRepository;

    public ProvincesController(ProvinceRepository provinceRepository){
        this.provinceRepository = provinceRepository;
    }
    @GetMapping("/provinces")
    public Collection<ProvinceEntity> provinces() {
        return provinceRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/province/{name}")
    public ProvinceEntity newProvince(@PathVariable String name) {
        ProvinceEntity p = new ProvinceEntity(name);
        return this.provinceRepository.save(p);
    }
}