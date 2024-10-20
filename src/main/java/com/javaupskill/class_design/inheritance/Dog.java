package com.javaupskill.class_design.inheritance;

public class Dog extends Animal{
    public Dog(int age, String name) {
        super(age, name);
    }

    public Dog() {
        System.out.println("dog");
    }

    static {
        System.out.println("dog static");
    }
}
