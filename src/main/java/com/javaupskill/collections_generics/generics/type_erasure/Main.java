package com.javaupskill.collections_generics.generics.type_erasure;

import java.lang.reflect.Method;

public class Main {
    public static void main (String args[]) {
        IntegerNode integerNode = new IntegerNode();
        for (Method method : integerNode.getClass().getDeclaredMethods()) {
            System.out.println(method.getName() + " " + method.isBridge() + " "
                    + method.getParameters()[0]);
        }

//        integerNode.setData(3);

        Node node = integerNode;
        node.setData("THIS IS NOT INT");
    }
}
