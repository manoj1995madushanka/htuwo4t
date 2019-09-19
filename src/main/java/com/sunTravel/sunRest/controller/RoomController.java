package com.sunTravel.sunRest.controller;

import com.sunTravel.sunRest.model.Room;
import com.sunTravel.sunRest.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    // for get all rooms without consider hotel
    @RequestMapping("/rooms")
    public List<Room> getAllrooms(){
        return this.roomService.getAllRooms();
    }

    //get rooms related to specific hotel
    @GetMapping("/hotels/{hotelId}/rooms")
    public List<Room> getAllRoomsByHotelId(@PathVariable(value = "hotelId") Long hotelId,
                                                   Pageable pageable) {
        return this.roomService.findByHotelId(hotelId, pageable);
    }

    // get room only using room type
    @RequestMapping("/rooms/{roomType}")
    public Room getRoom(@PathVariable("roomType") Long roomType){
        return this.roomService.getRoom(roomType);
    }
    // add contract without hotel not necessary method
    /*@RequestMapping(method = RequestMethod.POST, value = "contracts")
    public void addRoom(@RequestBody Room room){
        roomService.addRoom(room);
    }*/

    // create contract for specific hotel id
    @PostMapping("/hotels/{hotelId}/rooms")
    public void createRoom(@PathVariable (value = "hotelId") Long hotelId,
                               @Valid @RequestBody Room room) {
        this.roomService.addRoom(hotelId,room);
    }

    // update contract using contract id
    @RequestMapping(method = RequestMethod.PUT, value= "rooms/{roomType}")
    public void updateRoom(@RequestBody Room room, @PathVariable Long roomType){
        roomService.updateRoom(room,roomType);
    }

    // update contract using hotel id and contract id as parameter
    @PutMapping("/hotels/{hotelId}/rooms/{roomType}")
    public void updateRoom(@PathVariable (value = "hotelId") Long hotelId,
                               @PathVariable (value = "roomType") Long roomType,
                               @Valid @RequestBody Room room) {
        this.roomService.updateRoom(hotelId,roomType,room);
    }

    // delete contract using contract id
    @RequestMapping(method = RequestMethod.DELETE, value = "rooms/{roomType}")
    public void deleteRoom(@PathVariable("roomType") Long roomType)
    {
        roomService.deleteRoom(roomType);
    }

    // delete contract related to hotel id
//    @DeleteMapping("/hotels/{hotelId}/rooms/{roomType}")
//    public void deleteRoom(@PathVariable (value = "hotelId") Long hotelId,
//                              @PathVariable (value = "roomType") String roomType) {
//        this.roomService.deleteRoom(hotelId, roomType);
//    }
}
