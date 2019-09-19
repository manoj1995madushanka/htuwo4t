package com.sunTravel.sunRest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "T475_Contract")
public class  Contract implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contractId")
    private long contractId;

    @Column(name="start_date")
    private Date st_date;

    @Column(name="end_date")
    private Date end_date;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "hotel_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    /*@JsonIgnore*/
    private Hotel hotel;


    /*@OneToMany(
            mappedBy = "contract",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ContractRoom> rooms = new ArrayList<>();*/

    public Contract(){}

    public Contract(Date st_date, Date end_date) {
        this.st_date = st_date;
        this.end_date = end_date;
    }

    public long getContractId() {
        return contractId;
    }

    public void setContractId(long contractId) {
        this.contractId = contractId;
    }

    public Date getSt_date() {
        return st_date;
    }

    public void setSt_date(Date st_date) {
        this.st_date = st_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    /*public List<ContractRoom> getRooms() {
        return rooms;
    }

    public void setRooms(List<ContractRoom> rooms) {
        this.rooms = rooms;
    }*/

    /*Notice that the Post entity features the addTag and removeTag utility methods which are needed by every
    bidirectional association so that all sides of the association stay in sync.

    While we could have added the same add/remove methods to the Tag entity, it’s unlikely that these
    associations will be set from the Tag entity because the users operate with Post entities.*/

    //

    /*public void addRoom(Room room, int roomCount, double roomPrice){
        ContractRoom contractRoom = new ContractRoom(this,room, roomCount, roomPrice);
        rooms.add(contractRoom);
        room.getContracts().add(contractRoom);
    }

    public void removeRoom(Room room){
        for(Iterator<ContractRoom> iterator = rooms.iterator();
        iterator.hasNext();
        ){
            ContractRoom contractRoom = iterator.next();
            if(contractRoom.getContract().equals(this) && contractRoom.getRoom().equals(room)){
                iterator.remove();
                contractRoom.getRoom().getContracts().remove(contractRoom);
                contractRoom.setContract(null);
                contractRoom.setRoom(null);
            }
        }
    }*/

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Contract contract = (Contract) o;
        return Objects.equals(title, post.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }*/
}
