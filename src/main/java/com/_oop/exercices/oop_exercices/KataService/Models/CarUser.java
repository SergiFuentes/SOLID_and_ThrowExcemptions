package com._oop.exercices.oop_exercices.KataService.Models;

public class CarUser {
    private Long id;
    private String name;

    public CarUser(long id, String name) {
        this.id= id;
        this.name= name;
    }

    public Long getId() {
        return this.id;
    }
}
