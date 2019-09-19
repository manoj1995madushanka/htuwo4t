package com.sunTravel.sunRest.repository;

import com.sunTravel.sunRest.model.Room;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {

    List<Room> findByHotelId(Long hotelId, Pageable pageable);
    /*Optional<Room> findByRoom_TypeAndHotelId(String roomId, Long hotelId);*/
    /*Optional<Room> findRoomByHotelId(String roomId, Long hotelId);*/
}
