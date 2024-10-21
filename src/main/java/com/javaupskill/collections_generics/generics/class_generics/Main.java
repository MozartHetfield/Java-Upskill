package com.javaupskill.collections_generics.generics.class_generics;

import com.javaupskill.collections_generics.generics.class_generics.Generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        printDifferentValues();
//        upperBound();
        Generics g = new Generics();
        g.printArguments(3, 4); // legacy, deprecated, but it still works!
    }

    private static void upperBound() {
        List<Number> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(3.0);
        numbers.add(5.33f);
        System.out.println(sum(numbers));
    }

    private static void printDifferentValues() {
        printClassAndValue("test");
        printClassAndValue(3);
        printClassAndValue(3.0);
    }

    private static <T extends Number> double sum(List<T> numbers) {
        double sum = 0.0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }

    public static <T> void printClassAndValue(T elem) {
        System.out.println(elem.getClass().getName() + " " + elem);
    }

}