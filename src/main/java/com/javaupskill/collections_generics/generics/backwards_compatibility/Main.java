package com.javaupskill.collections_generics.generics.backwards_compatibility;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        backwards1();
//        backwards2();
//        backwards3();
    }

    private static void backwards3() {
        List<String> list = new ArrayList<>();
        list.add("test");
        breakList(list);
    }

    public static void breakList(List list) {
        list.add(Integer.valueOf(1));
        System.out.println(list);
    }

    private static void backwards2() {
        List<String> list = new ArrayList<>();
        list.add("test");
//        list.add(3);

        List list2 = list;
        list2.add("test2");
        list2.add(3);
        System.out.println(list2);
    }
    private static void backwards1() {
        List<String> stringList = new LinkedList<>();
        stringList.add("test");
        List<Integer> intList1 = new LinkedList(stringList); // not good practice, but allowed. DO NOT USE
//        List<Integer> intList2 = new LinkedList<>(stringList); // not allowed, because of generic type
        intList1.add(5);

        // compile error
//        for (Integer i : intList1) {
//            System.out.println(i);
//        }

        System.out.println(intList1);
    }
}
