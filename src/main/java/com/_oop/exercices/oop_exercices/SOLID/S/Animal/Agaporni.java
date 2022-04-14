package com._oop.exercices.oop_exercices.SOLID.S.Animal;

public class Agaporni extends Animal {
    int numColors;

    public Agaporni(int age, boolean isAlive, String name, String sound, String sex, int numColors) {
        super(age, isAlive, name, sound, sex);
        this.numColors = numColors;
    }
}
