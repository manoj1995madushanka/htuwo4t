package com.sunTravel.sunRest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="T475_Hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="hotel_id")
    private long id;
    @Column(name="hotel_name")
    private String hotel_name;
    @Column(name="hotel_location")
    private String hotel_location;
    @Column(name="hotel_email")
    private String hotel_email;
    @Column(name="hotel_telephone")
    private String hotel_telephone;


    public Hotel(){}

    public Hotel(String hotel_name, String hotel_location, String hotel_email, String hotel_telephone) {
        this.hotel_name = hotel_name;
        this.hotel_location = hotel_location;
        this.hotel_email = hotel_email;
        this.hotel_telephone = hotel_telephone;
    }

    public long getHotel_id() {
        return id;
    }

    public void setHotel_id(long hotel_id) {
        this.id = hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_location() {
        return hotel_location;
    }

    public void setHotel_location(String hotel_location) {
        this.hotel_location = hotel_location;
    }

    public String getHotel_email() {
        return hotel_email;
    }

    public void setHotel_email(String hotel_email) {
        this.hotel_email = hotel_email;
    }

    public String getHotel_telephone() {
        return hotel_telephone;
    }

    public void setHotel_telephone(String hotel_telephone) {
        this.hotel_telephone = hotel_telephone;
    }
}
