package com.javaupskill.class_design.interfaces;

public interface InterfaceExample {
    int var = 3;

    void testMethod();

    default void testDefaultMethod() {
        System.out.println("exista implementare");
    }
}
