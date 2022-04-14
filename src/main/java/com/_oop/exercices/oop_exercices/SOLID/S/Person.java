package com._oop.exercices.oop_exercices.SOLID.S;

import com._oop.exercices.oop_exercices.SOLID.S.LivingBeings;

public class Person extends LivingBeings {
    String lenguage;
    String eyesColor;

    public Person(int age, boolean isAlive, String name, String lenguage, String eyesColor) {
        super(age, isAlive, name);
        this.lenguage = lenguage;
        this.eyesColor = eyesColor;
    }
}
