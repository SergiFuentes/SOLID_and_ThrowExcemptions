package com._oop.exercices.oop_exercices.SOLID.D.BadExemple;


public class ServicePerson {

    public void savePerson(Person person) {
        MySql mysql = new MySql();
        mysql.savePerson(person);
    }

}