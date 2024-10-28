package com.javaupskill.collections_generics.collections.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) {

//        outOfScope();
//        iterations();
//        removeInILoop();
    }

    private static void removeInILoop() {
        List<String> fruits = getFruits();
        for (int i = 0; i <= fruits.size(); i++) {
            fruits.remove(i);
        }
        System.out.println(fruits);
    }

    private static void outOfScope() {
        Animal animal = new Animal("1");
        Animal animal3 = new Animal("2");
        System.out.println(animal3);
        animal3 = animal;
        System.out.println(animal3);
        System.out.println(animal);

        animal.name = "new animal";
        animal = new Animal("another animal");
        System.out.println(animal3.name);
    }

    private static void iterations() {
        List<String> fruits = getFruits();
        List<Animal> animals = getAnimals();
        int[] numbers = {1, 3, 5, 8, 9};
//        removeInIterator(fruits);
//        removeInEnhLoop(fruits);

        for (String fruit : fruits) {
            fruit = "New fruit";
        }
        System.out.println(fruits);

        for (Animal animal : animals) {
            animal = new Animal("new animal");
        }
        System.out.println(animals);
    }

    private static void removeInIterator(List<String> fruits) {
        Iterator<String> it = fruits.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            it.remove();
        }
        System.out.println(fruits);
    }

    private static void removeInEnhLoop(List<String> fruits) {
        for (String fruit : fruits) {
            fruits.remove(fruit);
        }
        System.out.println(fruits);
    }

    private static List<Animal> getAnimals() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Owl"));
        animals.add(new Animal("Dog"));
        animals.add(new Animal("Shark"));
        return animals;
    }

    private static List<String> getFruits() {
        List<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Lemon");
        fruits.add("Lemon");
        fruits.add("Lemon");
        return fruits;
    }

}
