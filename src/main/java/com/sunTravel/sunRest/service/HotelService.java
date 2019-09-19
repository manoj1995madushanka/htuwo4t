package com.sunTravel.sunRest.service;

import com.sunTravel.sunRest.exception.ResourceNotFoundException;
import com.sunTravel.sunRest.model.Hotel;
import com.sunTravel.sunRest.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getAllHotels(){
        return hotelRepository.findAll();
    }

    public Hotel getHotel(long id){
        return hotelRepository.findById(id).get();
    }

    public void addHotel(Hotel hotel){
        hotelRepository.save(hotel);
    }

    public Hotel updateHotel(Hotel hotel, long hotelId){
        /*hotel.setHotel_id(hotelId);
        hotelRepository.save(hotel);*/

        return hotelRepository.findById(hotelId).map(Hotel -> {
            Hotel.setHotel_name(hotel.getHotel_name());
            Hotel.setHotel_location(hotel.getHotel_location());
            Hotel.setHotel_email(hotel.getHotel_email());
            Hotel.setHotel_telephone(hotel.getHotel_telephone());
            return hotelRepository.save(Hotel);
        }).orElseThrow(() -> new ResourceNotFoundException("HotelId " + hotelId + " not found"));
    }

    public ResponseEntity<Object> deleteHotel(long id) {
        /*hotelRepository.deleteById(id);*/

        return hotelRepository.findById(id).map(Hotel -> {
            hotelRepository.delete(Hotel);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("HotelId " + id + " not found"));
    }
}
