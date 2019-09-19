package com.sunTravel.sunRest.service;

import com.sunTravel.sunRest.exception.ResourceNotFoundException;
import com.sunTravel.sunRest.model.Contract;
import com.sunTravel.sunRest.repository.ContractRepository;
import com.sunTravel.sunRest.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private HotelRepository hotelRepository;

    public List<Contract> getAllContracts(){
        return contractRepository.findAll();
    }

    public List<Contract> findByHotelId(Long hotelId,Pageable pageable){
        return contractRepository.findByHotelId(hotelId, pageable);
    }

    public Contract getContract(Long id){
        return contractRepository.findById(id).get();
    }

    public void addContract(Contract contract){
        contractRepository.save(contract);
    }

    public Contract addContract(Long hotelId, Contract contract){
        return hotelRepository.findById(hotelId).map(Hotel -> {
            contract.setHotel(Hotel);
            /*contract.setContractId(contract.getContractId());*/
            return contractRepository.save(contract);
        }).orElseThrow(() -> new ResourceNotFoundException("HotelId " + hotelId + " not found"));
    }

    public void updateContract(Contract contract, Long contractId){
        contract.setContractId(contractId);
        contractRepository.save(contract);
    }

    public Contract updateContract(Long hotelId,Long contractId,Contract contract){
        if(!hotelRepository.existsById(hotelId)) {
            throw new ResourceNotFoundException("HotelId " + hotelId + " not found");
        }

        return contractRepository.findById(contractId).map(Contract -> {
            Contract.setSt_date(contract.getSt_date());
            Contract.setEnd_date(contract.getEnd_date());
            return contractRepository.save(Contract);
        }).orElseThrow(() -> new ResourceNotFoundException("ContractId " + contractId + "not found"));
    }

    public void deleteContract(Long contract_id) {
        contractRepository.deleteById(contract_id);
    }

    public ResponseEntity<?> deleteContract(long hotelId, long contractId){
        return contractRepository.findByContractIdAndHotelId(contractId, hotelId).map(Contract -> {
            contractRepository.delete(Contract);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Comment not found with ContractId " + contractId + " and hotelId " + hotelId));
    }
}
