package com.javaupskill.class_design.bindings;

public class ParentClass {
    public int childVariable = 30;

    public static void printSomething() {
        System.out.println("parent");
    }

    public void printSomethingNonStatic() {
        System.out.println("parent");
    }

}
