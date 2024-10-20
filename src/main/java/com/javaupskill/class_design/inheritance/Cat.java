package com.javaupskill.class_design.inheritance;

public class Cat extends Animal {

    public Cat(int age, String name) {
        super(age, name);
    }

    public Cat() {
        System.out.println("cat");
    }

    static {
        System.out.println("cat static");
    }

    @Override
    public void move() {
        System.out.println("cats can run");
    }
}
