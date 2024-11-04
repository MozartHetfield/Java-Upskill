package com.javaupskill.design_patterns;

import com.javaupskill.design_patterns.builder.Burger;
import com.javaupskill.design_patterns.factory.Circle;
import com.javaupskill.design_patterns.factory.Shape;
import com.javaupskill.design_patterns.factory.ShapeFactory;
import com.javaupskill.design_patterns.singleton.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        singleton();
//        factory();
//        builder();
    }

    private static void builder() {
        Burger.Builder burgerBuilder = new Burger.Builder();
        Burger burger = burgerBuilder.setBun("integral")
                .setOnion("true")
                .setMeat("pork")
                .setSauce("mayo")
                .build();
        System.out.println(burger);
    }

    private static void factory() {
        ShapeFactory shapeFactory = new ShapeFactory();
        List<Shape> shapes = new ArrayList<>();
        shapes.add(shapeFactory.getShape("Circle"));
        shapes.add(shapeFactory.getShape("Circle"));
        shapes.add(shapeFactory.getShape("Square"));

        System.out.println(shapes);
    }

    private static void singleton() {
        Logger singletonClass = Logger.getInstance();
        System.out.println(singletonClass);
        singletonClass = Logger.getInstance();
        System.out.println(singletonClass);
    }
}
