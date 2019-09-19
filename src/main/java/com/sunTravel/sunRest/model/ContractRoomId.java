package com.sunTravel.sunRest.model;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ContractRoomId implements Serializable {

    @Column(name = "contractId")
    private Long contractId;

    @Column(name = "roomId")
    private Long roomId;

    private ContractRoomId() {}

    public ContractRoomId(Long contractId, Long roomId) {
        this.contractId = contractId;
        this.roomId = roomId;
    }

    //Getters omitted for brevity


    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        ContractRoomId that = (ContractRoomId) o;
        return Objects.equals(contractId, that.contractId) &&
                Objects.equals(roomId, that.roomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractId, roomId);
    }
}
