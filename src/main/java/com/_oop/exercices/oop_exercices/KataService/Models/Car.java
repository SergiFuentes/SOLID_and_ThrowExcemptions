package com._oop.exercices.oop_exercices.KataService.Models;

public class Car {
    private Long id;
    private String licensePlate;
    private String brand;

    public Car(long id, String licensePlate, String brand) {
        this.id = id;
        this.licensePlate= licensePlate;
        this.brand = brand;
    }

    public Long getId() {
        return this.id;
    }
}
