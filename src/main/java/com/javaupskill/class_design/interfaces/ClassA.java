package com.javaupskill.class_design.interfaces;

public class ClassA implements InterfaceExample, InterfaceExample2 {

    public void test() {
        testMethod();
        testDefaultMethod();
    }

    @Override
    public void testMethod() {

    }
}
