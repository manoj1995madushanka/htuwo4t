package com.sunTravel.sunRest.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "T475_ContractRoom")
public class ContractRoom {

    @EmbeddedId
    private ContractRoomId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("contractId")
    private Contract contract;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("room_type")
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

    public ContractRoom(Contract contract, Room room, int room_count, double room_price) {
        this.contract = contract;
        this.room = room;
        this.room_count = room_count;
        this.room_price = room_price;
        this.id = new ContractRoomId(contract.getContractId(),room.getRoom_type());
    }
    //Getters and setters omitted for brevity


    public ContractRoomId getId() {
        return id;
    }

    public void setId(ContractRoomId id) {
        this.id = id;
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
