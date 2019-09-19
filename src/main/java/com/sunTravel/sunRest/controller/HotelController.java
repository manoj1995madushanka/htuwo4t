package com.sunTravel.sunRest.controller;

import com.sunTravel.sunRest.model.Hotel;
import com.sunTravel.sunRest.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @RequestMapping("/hotels")
    public List<Hotel> getAllHotels(){
        return this.hotelService.getAllHotels();
    }

    @RequestMapping("/hotels/{hotelId}")
    public Hotel getHotel(@PathVariable("hotelId") long id){
        return this.hotelService.getHotel(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "hotels")
    public void addHotel(@RequestBody Hotel hotel){
        hotelService.addHotel(hotel);
    }

    @RequestMapping(method = RequestMethod.PUT, value= "hotels/{hotelId}")
    public void updateHotel(@RequestBody Hotel hotel, @PathVariable long hotelId){
        hotelService.updateHotel(hotel,hotelId);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "hotels/{hotelId}")
    public void deleteHotel(@PathVariable("hotelId") int id){
        hotelService.deleteHotel(id);
    }
}
