package com._oop.exercices.oop_exercices.SOLID.S.Animal;

import com._oop.exercices.oop_exercices.SOLID.S.LivingBeings;

public abstract class Animal extends LivingBeings {
    String sound;
    String sex;

    public Animal(int age, boolean isAlive, String name, String sound, String sex) {
        super(age, isAlive, name);
        this.sound = sound;
        this.sex = sex;
    }
}
