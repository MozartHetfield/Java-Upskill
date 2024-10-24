package com.javaupskill.collections_generics.collections.implementations;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        arrayList();
//        linkedList();
//        queue();
        stack();
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
