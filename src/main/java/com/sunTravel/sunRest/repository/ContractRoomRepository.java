package com.sunTravel.sunRest.repository;

import com.sunTravel.sunRest.model.ContractRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ContractRoomRepository extends JpaRepository<ContractRoom, Integer> {

    @Query( "FROM ContractRoom AS cr  JOIN cr.contract  AS con JOIN cr.room AS cons WHERE cr.room_count >= ?1 AND con.st_date <= ?2 AND con.end_date >= ?3 ")
    List findByAvl(int rooms, Date st_date, Date end_date);



    /*ContractRoom findByContractIdAndRoomId(Long contractId, Long roomId);*/
    /*@Query( "FROM ContractRoom AS cr INNER JOIN cr.Contract AS con WHERE Room >= ?1 AND con.st_date <= ?2 AND con.end_date >= ?3 ")
    List<ContractRoom> findByAvl(int rooms, LocalDate start_date, LocalDate end_date);

    @Query("SELECT ")*/

    // @Query("SELECT u FROM auth_user as u WHERE u.isEnabled AND u.id IN"
    //        + " (SELECT r.user_id FROM user_role as r WHERE r.role_id = ?1)")

}
