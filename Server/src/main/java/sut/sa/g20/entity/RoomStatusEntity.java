package sut.sa.g20.entity;
import javax.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Data
@Table (name = "TableRoomStatus")
public class RoomStatusEntity {
    @Id
    @SequenceGenerator(name="roomstatus_seq",sequenceName="roomstatus_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="roomstatus_seq")  
    @Column(name="roomStatusId",unique = true, nullable = false)
    private Long roomStatusId;
    private String roomStatus;
    public RoomStatusEntity(){}
    public RoomStatusEntity(String rst){
        this.roomStatus = rst;
    }
    public void setRoomStatusId(long id){
        this.roomStatusId = id;
    }
    public void setRoomStatus(String status){
        this.roomStatus = status;
    }
    public Long getRoomStatusId(){
        return this.roomStatusId;
    }
    public String getRoomStatus(){
        return this.roomStatus;
    }
}