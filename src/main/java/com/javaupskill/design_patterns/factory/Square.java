package com.javaupskill.design_patterns.factory;

public class Square implements Shape {
    @Override
    public void printShape() {
        System.out.println("Square");
    }

    @Override
    public String toString() {
        return "Square{}";
    }
}
