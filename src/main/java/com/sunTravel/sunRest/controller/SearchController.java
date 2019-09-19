package com.sunTravel.sunRest.controller;

import com.sunTravel.sunRest.model.Contract;
import com.sunTravel.sunRest.model.ContractRoom;
import com.sunTravel.sunRest.repository.ContractRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private ContractRoomRepository contractRoomRepository;

    @RequestMapping(method = RequestMethod.POST, value = "search/{roomCount}")
    public List addHotel(@RequestBody Contract contract, @PathVariable (value = "roomCount") int roomCount){
        return contractRoomRepository.findByAvl(roomCount,contract.getSt_date(),contract.getEnd_date());
    }
}
