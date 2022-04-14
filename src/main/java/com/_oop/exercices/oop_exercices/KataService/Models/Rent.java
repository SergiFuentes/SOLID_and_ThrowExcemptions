package com._oop.exercices.oop_exercices.KataService.Models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Optional;

public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Car rentedCar;
    private CarUser rentingUser;
    private Date date;

    public Rent(Car rentedCar, CarUser rentingUser) {
        this.id = id;
        this.rentedCar = rentedCar ;
        this.rentingUser = rentingUser;
        this.date = new Date();
    }

    public Rent() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getRentedCar() {
        return rentedCar;
    }

    public void setRentedCar(Car rentedCar) {
        this.rentedCar = rentedCar;
    }

    public CarUser getRentingUser() {
        return rentingUser;
    }

    public void setRentingUser(CarUser rentingUser) {
        this.rentingUser = rentingUser;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
