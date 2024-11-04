package com.javaupskill.design_patterns.factory;

public class Circle implements Shape {
    @Override
    public void printShape() {
        System.out.println("Circle");
    }

    @Override
    public String toString() {
        return "Circle{}";
    }
}
