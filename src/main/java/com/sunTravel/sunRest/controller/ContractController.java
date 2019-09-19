package com.sunTravel.sunRest.controller;

import com.sunTravel.sunRest.model.Contract;
import com.sunTravel.sunRest.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ContractController {
    @Autowired
    private ContractService contractService;

    // for get all contracts without consider hotel
    @RequestMapping("/contracts")
    public List<Contract> getAllContracts(){
        return this.contractService.getAllContracts();
    }

    //get contracts related to specific hotel
    @GetMapping("/hotels/{hotelId}/contracts")
    public List<Contract> getAllContractsByHotelId(@PathVariable (value = "hotelId") Long hotelId,
                                                 Pageable pageable) {
        return this.contractService.findByHotelId(hotelId, pageable);
    }

    // get contract only using contract id
    @RequestMapping("/contracts/{contractId}")
    public Contract getContract(@PathVariable("contractId") Long id){
        return this.contractService.getContract(id);
    }
    // add contract without hotel not necessary method
    @RequestMapping(method = RequestMethod.POST, value = "contracts")
    public void addContract(@RequestBody Contract contract){
        contractService.addContract(contract);
    }

    // create contract for specific hotel id
    @PostMapping("/hotels/{hotelId}/contracts")
    public void createContract(@PathVariable (value = "hotelId") Long hotelId,
                                 @Valid @RequestBody Contract contract) {
        this.contractService.addContract(hotelId,contract);
    }

    // update contract using contract id
    @RequestMapping(method = RequestMethod.PUT, value= "contracts/{contractId}")
    public void updateContract(@RequestBody Contract contract, @PathVariable Long contractId){
        contractService.updateContract(contract,contractId);
    }

    // update contract using hotel id and contract id as parameter
    @PutMapping("/hotels/{hotelId}/contracts/{contractId}")
    public void updateContract(@PathVariable (value = "hotelId") Long hotelId,
                                 @PathVariable (value = "contractId") Long contractId,
                                 @Valid @RequestBody Contract contract) {
        this.contractService.updateContract(hotelId,contractId,contract);
    }

    // delete contract using contract id
    @RequestMapping(method = RequestMethod.DELETE, value = "contracts/{contractId}")
    public void deleteContract(@PathVariable("contractId") Long id){
        contractService.deleteContract(id);
    }

    // delete contract related to hotel id
    @DeleteMapping("/hotels/{hotelId}/contracts/{contractId}")
    public void deleteComment(@PathVariable (value = "hotelId") Long hotelId,
                                           @PathVariable (value = "contractId") Long contractId) {
        this.contractService.deleteContract(hotelId, contractId);
    }
}
