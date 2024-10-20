package com.javaupskill.class_design.composition;

public class AmericanKitchen implements Kitchen {
    @Override
    public void prepareMenu() {
        System.out.println("Burger");
    }
}
