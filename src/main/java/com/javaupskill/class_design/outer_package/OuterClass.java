package com.javaupskill.class_design.outer_package;

public class OuterClass {
    int defaultAccessInt;
    protected int protectedInt;

    public static int fridgeTemperature = 4;
    private int privateInt = 5;

    public static final double PI = 3.14;
    public int publicInt = 5;

    public void showInts() {
        System.out.println(defaultAccessInt + " " + protectedInt);
    }
}

// not recommended below:
class Class2 {

}

class Class3 {

}
