package com.javaupskill.collections_generics.generics.class_generics;

public class Generics<T extends MyClass & MyInterface & MyInterface2> {
    T data;

    public void printArguments(Integer x, Integer y, Integer z) {
        System.out.println(x + " " + y + " " + z);
    }
    public void printArguments(Integer x, Integer y) {
        System.out.println(x + " " + y);
    }
}
