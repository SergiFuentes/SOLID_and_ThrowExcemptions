package com._oop.exercices.oop_exercices.SOLID.S.Animal;

public class Turttle extends Animal {
    String shellColor;

    public Turttle(int age, boolean isAlive, String name, String sound, String sex, String shellColor) {
        super(age, isAlive, name, sound, sex);
        this.shellColor = shellColor;
    }
}
