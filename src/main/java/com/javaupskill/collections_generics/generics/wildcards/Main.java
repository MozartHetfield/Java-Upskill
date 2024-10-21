package com.javaupskill.collections_generics.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String args[]) {
        List<?> items = new ArrayList<>();
        List<? extends Number> items2 = new ArrayList<>();
//        items.add("TEST");
//        items2.add(3);

        items.add(null);
        items2.add(null);

        List<? super Number> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(5.0);
    }

    public static List<?> returnAndPrintList(List<?> items) {
        System.out.println(items);
        //        items.add("TEST");
//        items2.add(3);
        return items;
    }
}
