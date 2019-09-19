package com.sunTravel.sunRest.model;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ContractRoomId implements Serializable {

    @Column(name = "contractId")
    private Long contractId;

    @Column(name = "room_type")
    private String room_type;

    private ContractRoomId() {}

    public ContractRoomId(Long contractId, String room_type) {
        this.contractId = contractId;
        this.room_type = room_type;
    }

    //Getters omitted for brevity


    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        ContractRoomId that = (ContractRoomId) o;
        return Objects.equals(contractId, that.contractId) &&
                Objects.equals(room_type, that.room_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractId, room_type);
    }
}
