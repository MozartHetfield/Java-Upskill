package com.javaupskill.class_design.bindings;

public class ChildClass extends ParentClass {
    public int childVariable = 3;

    public void childMethod() {
        System.out.println("method");
    }

    public static void printSomething() {
        System.out.println("child");
    }

    public void printSomethingNonStatic() {
        System.out.println("child");
    }


}
