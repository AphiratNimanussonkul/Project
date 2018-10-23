package sut.sa.g20.entity;
import javax.persistence.*;
import lombok.*;
import java.util.List;
@Entity
@Data
@Table (name = "TableProvince")
public class ProvinceEntity {
    @Id
    @SequenceGenerator(name="provinces_seq",sequenceName="provinces_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="provinces_seq")  
    @Column(name="provincesId",unique = true, nullable = false)
    private Long provinceId;
    private String provinceName;
    public ProvinceEntity(){}
    public ProvinceEntity(String province){
        this.provinceName = province;
    }
    public void setProvinceId(long id){this.provinceId = id;}
    public Long getProvinceId(){return this.provinceId;}
    public void setProvinceName(String name){this.provinceName = name;}
    public String getProvinceName(){return this.provinceName;}
}

