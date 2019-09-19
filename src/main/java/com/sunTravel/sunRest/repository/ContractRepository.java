package com.sunTravel.sunRest.repository;

import com.sunTravel.sunRest.model.Contract;
import com.sunTravel.sunRest.model.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    /*@Query(" select contract.hotel from Contract as contract where contract.hotel.hotel_id = :hotelId  ")*/
    List<Contract> findByHotelId(Long hotelId, Pageable pageable);
    /*Optional<Contract> findByIdAndHotelId(Long id, Long hotelId);*/
    Optional<Contract> findByContractIdAndHotelId(Long contractId, Long hotelId);


}
