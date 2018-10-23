
package sut.sa.g20.entity;
import javax.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@Table (name = "TableRoomtype")
public class RoomTypeEntity {
    @Id
    @SequenceGenerator(name="roomtype_seq",sequenceName="roomtype_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="roomtype_seq")  
    @Column(name="roomtypeId",unique = true, nullable = false)
    private Long roomtypeId;
    private @NonNull String roomType;
    private @NonNull String bedType;
    private @NonNull int numberOfBed;
    private @NonNull int maxPeople ;
    
    public RoomTypeEntity(){ }
    public RoomTypeEntity(String roomType, String bedType, int numberOfBed, int maxPeople){
        this.numberOfBed = numberOfBed;
        this.roomType = roomType;
        this.bedType = bedType;
        this.maxPeople = maxPeople;
    }

    public Long getRoomtypeId() {
        return roomtypeId;
    }
    public void setRoomtypeId(Long roomtypeId) {
        this.roomtypeId = roomtypeId;
    }
    public String getRoomType() {
        return roomType;
    }
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    public String getBedType() {
        return bedType;
    }
    public void setBedType(String bedType) {
        this.bedType = bedType;
    }
    public int getNumberOfBed() {
        return numberOfBed;
    }
    public void setNumberOfBed(int bedNumber) {
        this.numberOfBed = bedNumber;
    }
    public int getMaxPeople() {
        return maxPeople;
    }
    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }
}