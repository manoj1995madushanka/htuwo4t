package com.sunTravel.sunRest.service;

import com.sunTravel.sunRest.model.ContractRoom;
import com.sunTravel.sunRest.repository.ContractRepository;
import com.sunTravel.sunRest.repository.ContractRoomRepository;
import com.sunTravel.sunRest.repository.HotelRepository;
import com.sunTravel.sunRest.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractRoomService {

    @Autowired
    private ContractRoomRepository contractRoomRepository;

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelRepository hotelRepository;

    public ContractRoom addContractRoom(Long contractId,Long roomId, ContractRoom contractRoom){
            contractRoom.setContract(contractRepository.findById(contractId).get());
            contractRoom.setRoom(roomRepository.findById(roomId).get());
            System.out.println(contractRoom.getContract().getContractId());
            return contractRoomRepository.save(contractRoom);
    }

    public ContractRoom getContractRoom(Long contractId, Long roomId){
        return null ;//contractRoomRepository.findByContractIdAndRoomId(contractId,roomId);
    }

    public List<ContractRoom> getAllContractRooms(){
        return contractRoomRepository.findAll();
    }
}
