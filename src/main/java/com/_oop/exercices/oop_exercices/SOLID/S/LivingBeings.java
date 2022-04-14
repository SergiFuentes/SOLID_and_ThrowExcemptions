package com._oop.exercices.oop_exercices.SOLID.S;

public abstract class LivingBeings {
    int age;
    boolean isAlive;
    String name;

    public LivingBeings(int age, boolean isAlive, String name) {
        this.age = age;
        this.isAlive = isAlive;
        this.name = name;
    }
}
