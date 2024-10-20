package com.javaupskill.class_design.inheritance;

public class Animal {
    private int age;
    private String name;

    public static int existingNumberOfAnimals;

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Animal() {
        System.out.println("animal");
    }

    static {
        existingNumberOfAnimals = 781212;
        System.out.println("animal static");
    }

    public void move() {
        System.out.println("animals can move");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getExistingNumberOfAnimals() {
        return existingNumberOfAnimals;
    }

    public static void setExistingNumberOfAnimals(int existingNumberOfAnimals) {
        Animal.existingNumberOfAnimals = existingNumberOfAnimals;
    }

    public void overload(long a) {
        // ...
    }

    public void overload(int a) {

    }

    public void overload(int a, int b) {

    }
}
