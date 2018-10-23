package sut.sa.g20.entity;
import javax.persistence.*;
import lombok.*;

@Entity
@Data
@Table (name = "TableRooms")
public class RoomEntity {
    @Id
    @SequenceGenerator(name="rooms_seq",sequenceName="rooms_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="rooms_seq")  
    @Column(name="roomsId",unique = true, nullable = false)
    private Long roomsId;
    private @NonNull int roomNumber;
    private @NonNull int roomPrice;
    private String roomImg;

    //Many To One with HotelEntity
    @ManyToOne(fetch=FetchType.EAGER, targetEntity = HotelEntity.class)
    @JoinColumn(name = "hotelId")
    private HotelEntity hotel;

    //Many To One with roomtype
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = RoomTypeEntity.class)
    @JoinColumn( name = "roomtypeId")
    private RoomTypeEntity roomtype;

    //ManyToOne With RoomStatusEntity
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = RoomStatusEntity.class)
    @JoinColumn(name = "roomStatusId") 
    private RoomStatusEntity roomstatus;

    public RoomEntity(){ }
    public RoomEntity(int roomNumber, int roomPrice, HotelEntity hotel, RoomTypeEntity roomType, RoomStatusEntity rst,String roomImg){
        this.roomNumber = roomNumber;
        this.roomPrice = roomPrice;
        this.hotel = hotel;
        this.roomtype = roomType;
        this.roomstatus = rst;
        this.roomImg = roomImg;
    }

    public void setRoomsId(Long roomsId) {
        this.roomsId = roomsId;
    }
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }
    public Long getRoomsId() {
        return this.roomsId;
    }
    public int getRoomNumber() {
        return roomNumber;
    }
    public int getRoomPrice() {
        return roomPrice;
    }
    public HotelEntity getHotel() {
        return hotel;
    }
    public void setHotel(HotelEntity hotel) {
        this.hotel = hotel;
    }
    public RoomTypeEntity getRoomtype() {
        return roomtype;
    }
    public void setRoomtype(RoomTypeEntity roomtype) {
        this.roomtype = roomtype;
    }
    public RoomStatusEntity getRoomstatus() {
        return roomstatus;
    }
    public void setRoomstatus(RoomStatusEntity rst) {
        this.roomstatus = rst;
    }
    public void setRoomImg(String roomImg){
        this.roomImg = roomImg;
    }
    public String getRoomImg(){
        return this.roomImg;
    }
    
}

