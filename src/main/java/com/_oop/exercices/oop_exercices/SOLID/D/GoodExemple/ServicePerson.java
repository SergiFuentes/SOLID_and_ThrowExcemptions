package com._oop.exercices.oop_exercices.SOLID.D.GoodExemple;

public class ServicePerson {


    private IPersistence persistence;

    public ServicePerson(IPersistence persistence) {
        this.persistence = persistence;
    }

    public void savePerson(Person person) {
        persistence.save(person);
    }

}
