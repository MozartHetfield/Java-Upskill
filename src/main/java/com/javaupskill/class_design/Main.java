package com.javaupskill.class_design;

import com.javaupskill.class_design.bindings.ChildClass;
import com.javaupskill.class_design.bindings.ParentClass;
import com.javaupskill.class_design.composition.AmericanKitchen;
import com.javaupskill.class_design.composition.AsianKitchen;
import com.javaupskill.class_design.composition.Kitchen;
import com.javaupskill.class_design.composition.Restaurant;
import com.javaupskill.class_design.inheritance.Animal;
import com.javaupskill.class_design.inheritance.Dog;

public class Main {
    public static void main(String[] args) {
    }

    private static void bindings() {
        ParentClass p = new ChildClass();
        ((ChildClass) p).childMethod();
        // ((ChildClass) p).childVariable = 5;

        System.out.println(p.childVariable); // 30
        System.out.println(((ChildClass) p).childVariable); // 3
        p.printSomething(); // not recommended
        int[] x = new int[1];
        x[3] =5;
        p.printSomethingNonStatic(); // overriding
    }
    private static void composition() {
        Kitchen asianKitchen = new AsianKitchen();
        Kitchen americanKitchen = new AmericanKitchen();

        Restaurant restaurant = new Restaurant(asianKitchen);
        restaurant.showDailyMenu();

        // vreau sa schimb bucataria
        restaurant.setKitchen(americanKitchen);
        restaurant.showDailyMenu();
    }
    private static void inheritance() {
        Animal.existingNumberOfAnimals++;
        Animal animal = new Animal();
        Animal animal2 = new Animal();
        Animal dogAnimal = new Dog();
        Dog dog = new Dog();
        System.out.println(dog.getAge());
        System.out.println(dog.getName());

        Integer x = 3;
        Long y = 3L;
        Double z = 0.3;
        printNumber(x);
        printNumber(y);
        printNumber(z);
    }
    private static void printNumber(Number x) {
        System.out.println(x);
    }

}