package com.sunTravel.sunRest.service;

import com.sunTravel.sunRest.exception.ResourceNotFoundException;
import com.sunTravel.sunRest.model.Room;
import com.sunTravel.sunRest.repository.HotelRepository;
import com.sunTravel.sunRest.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelRepository hotelRepository;

    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    public List<Room> findByHotelId(Long hotelId, Pageable pageable){
        return roomRepository.findByHotelId(hotelId, pageable);
    }

    public Room getRoom(Long roomId){
        return roomRepository.findById(roomId).get();
    }

    public void addRoom(Room room){
        roomRepository.save(room);
    }

    public Room addRoom(Long hotelId, Room room){
        return hotelRepository.findById(hotelId).map(Hotel -> {
            room.setHotel(Hotel);
            System.out.println(hotelId);
            System.out.println(Hotel.getHotel_id());
            /*contract.setContractId(contract.getContractId());*/
            return roomRepository.save(room);
        }).orElseThrow(() -> new ResourceNotFoundException("HotelId " + hotelId + " not found"));
    }

    public void updateRoom(Room room, Long roomId){
        room.setRoomId(roomId);
        roomRepository.save(room);
    }

    public Room updateRoom(Long hotelId,Long roomId,Room room){
        if(!hotelRepository.existsById(hotelId)) {
            throw new ResourceNotFoundException("HotelId " + hotelId + " not found");
        }

        return roomRepository.findById(roomId).map(Room -> {
            Room.setMax_adults(room.getMax_adults());
            /*Room.setRoom_count(room.getRoom_count());
            Room.setRoom_price(room.getRoom_price());*/
            return roomRepository.save(Room);
        }).orElseThrow(() -> new ResourceNotFoundException("Room id " + roomId + "not found"));
    }

    public void deleteRoom(Long roomId) {
        roomRepository.deleteById(roomId);
    }

    /*public ResponseEntity<?> deleteRoom(Long hotelId, String roomType){
        return roomRepository.findRoomByHotelId(hotelId).map(Room -> {
            roomRepository.delete(Room);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Comment not found with Room type" + roomType + " and hotelId " + hotelId));
    }*/
}
