package com.sunTravel.sunRest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="T475_Room")
/*@NaturalIdCache
@Cache(
       usage =  CacheConcurrencyStrategy.READ_WRITE
)*/
public class Room implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roomId")
    private long roomId;
    /*@NaturalId*/
    @Column(name="room_type")
    private String room_type;
    @Column(name="max_adults")
    private int max_adults;

    /*@Column(name="room_count")
    private int room_count;
    @Column(name="room_price")
    private double room_price;*/

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "hotel_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    /*@JsonIgnore*/
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Hotel hotel;

    /*@OneToMany(
            mappedBy = "room",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ContractRoom> contracts = new ArrayList<>();*/

    public Room(){}

    public Room(String room_type, int max_adults, Hotel hotel) {
        this.room_type = room_type;
        this.max_adults = max_adults;
        this.hotel = hotel;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public int getMax_adults() {
        return max_adults;
    }

    public void setMax_adults(int max_adults) {
        this.max_adults = max_adults;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    /*public List<ContractRoom> getContracts() {
        return contracts;
    }

    public void setContracts(List<ContractRoom> contracts) {
        this.contracts = contracts;
    }*/

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(room_type, room.room_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room_type);
    }*/
}
