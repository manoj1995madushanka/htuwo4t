package com.sunTravel.sunRest.controller;

import com.sunTravel.sunRest.model.ContractRoom;
import com.sunTravel.sunRest.repository.ContractRoomRepository;
import com.sunTravel.sunRest.service.ContractRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ContractRoomController {

    @Autowired
    private ContractRoomService contractRoomService;


    @PostMapping("/{contractId}/{roomId}/contractrooms")
    public void createContractRoom(@PathVariable (value = "contractId") Long contractId,
                           @PathVariable (value="roomId") Long roomId,
                           @Valid @RequestBody ContractRoom contractRoom) {
        this.contractRoomService.addContractRoom(contractId,roomId,contractRoom);
    }

    @RequestMapping("/{contractId}/{roomId}")
    public List<ContractRoom> getRoom(@PathVariable("contractId") Long contractId, @PathVariable("roomId") Long roomId){
        return this.contractRoomService.getAllContractRooms();
    }
}
