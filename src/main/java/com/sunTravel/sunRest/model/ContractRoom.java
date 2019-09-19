package com.sunTravel.sunRest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "T475_ContractRoom")
public class ContractRoom {

    /*@EmbeddedId
    private ContractRoomId contractRoomId;*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contractRoomId")
    private long contractRoomId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Contract contract;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Room room;

    /*@Column(name = "created_on")
    private Date createdOn = new Date();*/

    @Column(name="room_count")
    private int room_count;

    @Column(name="room_price")
    private double room_price;

    private ContractRoom() {}

    /*public PostTag(Post post, Tag tag) {
        this.post = post;
        this.tag = tag;
        this.id = new PostTagId(post.getId(), tag.getId());
    }*/

    public ContractRoom(int room_count, double room_price) {
        this.room_count = room_count;
        this.room_price = room_price;
        /*this.contractRoomId = new ContractRoomId(contract.getContractId(),room.getRoomId());*/
    }
    //Getters and setters omitted for brevity


   /* public ContractRoomId getId() {
        return contractRoomId;
    }

    public void setId(ContractRoomId id) {
        this.contractRoomId = id;
    }*/

    public long getContractRoomId() {
        return contractRoomId;
    }

    public void setContractRoomId(long contractRoomId) {
        this.contractRoomId = contractRoomId;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getRoom_count() {
        return room_count;
    }

    public void setRoom_count(int room_count) {
        this.room_count = room_count;
    }

    public double getRoom_price() {
        return room_price;
    }

    public void setRoom_price(double room_price) {
        this.room_price = room_price;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        ContractRoom that = (ContractRoom) o;
        return Objects.equals(contract, that.contract) &&
                Objects.equals(room, that.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contract, room);
    }*/
}
