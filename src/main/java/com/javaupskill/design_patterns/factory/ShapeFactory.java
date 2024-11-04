package com.javaupskill.design_patterns.factory;

public class ShapeFactory {

    public Shape getShape(String type) {
        if (type == null) {
            throw new IllegalArgumentException("null type");
        }

        return switch(type) {
            case "Circle" -> new Circle();
            case "Square" -> new Square();
            default -> throw new IllegalArgumentException("unknown shape");
        };
    }
}
