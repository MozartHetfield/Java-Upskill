package com.javaupskill.collections_generics.collections.implementations;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        arrayList();
//        linkedList();
//        queue();
//        stack();
//        set();
//        hashMap();
//        hashCodeEqualsContract();
        sorting();
    }

    private static void sorting() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(25, "Marian"));
        students.add(new Student(31, "Nicoleta"));
        System.out.println(students);

        Collections.sort(students, new ReverseAgeStudentComparator());
        System.out.println(students);

        Collections.sort(students);
        System.out.println(students);
    }

    private static void hashCodeEqualsContract() {
        HashMap<Student, String> students = new HashMap<>();
        Student s = new Student(22, "Andrei");
        students.put(s, "value 1");
        s = new Student(22, "Andrei");
        students.put(s, "value 2");

        System.out.println(students.size());
    }

    private static void hashMap() {
        Map<String, String> idToName = new HashMap<>();
        idToName.put("3", "Andrei");
        idToName.put("5", "Monica");

        System.out.println(idToName.get("3"));
        System.out.println(idToName.get("5"));
        System.out.println(idToName.get("7")); // null

        idToName.putIfAbsent("5", "George");
        System.out.println(idToName.get("5"));
    }

    private static void set() {
        List<String> animals = Arrays.asList("Owl", "Lion", "Zebra", "Shark");

        Set<String> set1 = new HashSet<>(); // ordered by hashcode
        Set<String> set2 = new TreeSet<>(); // ordered by their natural order
        Set<String> set3 = new LinkedHashSet<>(); // ordered in the same way as they were added

        for (String animal : animals) {
            set1.add(animal);
            set2.add(animal);
            set3.add(animal);

            set1.add(animal); // NO duplicates!
            set2.add(animal);
            set3.add(animal);
        }

        System.out.println(set1);
        System.out.println(set2);
        System.out.println(set3);
    }

    private static void stack() {
        Deque<Integer> stack = new ArrayDeque<>();
//        Stack<Integer> stack2 = new Stack<>();

        for (int i = 5; i >= 0; i--) {
            stack.push(i);
        }

        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }

    private static void queue() {
        Queue<Integer> q = new LinkedList<>(); // FIFO
        Queue<Integer> q2 = new PriorityQueue<>();

        for (int i = 5; i >= 0; i--) {
            q.add(i);
            q2.add(i);
        }

        System.out.println(q);
        System.out.println(q2);


//        System.out.println(q2.peek()); // 0
//        System.out.println(q2.peek()); // 0
//        System.out.println(q2.poll()); // 0
//        System.out.println(q2.poll()); // 1

        while (!q2.isEmpty()) {
            System.out.println(q2.poll());
        }
    }

    private static void linkedList() {
        // add - O(1)
        // get - O(n)
        // contains - O(n)
        // remove - O(1)
        List<Integer> list = new LinkedList<>(Arrays.asList(3, 5, 100, 22));
        System.out.println(list);

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        System.out.println(list.get(0));
        list.remove(0);
        System.out.println(list.get(0));
    }

    private static void arrayList() {
        //        List<Integer> list = new ArrayList<>();
        // add - depends. O(n) worst, O(1) the last elem
        // remove - same as above
        // get - O(1)
        // contains - O(n)
        // contains with ordered list - O(logN)

        List<Integer> list = new ArrayList<>(Arrays.asList(3, 5, 100, 22));
        System.out.println(list);

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        System.out.println(list.get(0));
        list.remove(0);
        System.out.println(list.get(0));
    }
}
