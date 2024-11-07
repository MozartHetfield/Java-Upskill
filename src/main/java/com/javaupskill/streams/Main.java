package com.javaupskill.streams;

import com.javaupskill.streams.others.ComparableClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        basics();
//        comparable();
//        function();
//        predicate();
//        basicsStreams();
//        lazy();

        // string -> string.length
        // show only even numbers
        // without duplicates
        // sorted // useless if we do sum later
        // sum with reduce
        List<List<String>> texts = Arrays.asList(Arrays.asList("test", "1231", "153512351"),
                Arrays.asList("51safasd", "fasdfaw", "qerqw21", "12", "1"),
                Arrays.asList("1412123", "019241294141", "51231", "5123"));

        int sum = texts.stream()
                .flatMap((List<String> x) -> x.stream()) //.flatMap(Collection::stream) // the same thing
                .map(String::length)
                .filter(n -> n % 2 == 0)
                .distinct()
                .sorted()
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }

    private static void lazy() {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> resultList = intList.stream().filter(n -> {
            System.out.println("filter processing"); // lazy. try to remove the terminal operator
            return n % 2 == 0;
        }).toList();
    }

    private static void basicsStreams() {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Predicate<Integer> dividesByTwo = x -> x % 2 == 0;

        List<Integer> filteredIntList = intList.stream()
                            //                .filter(dividesByTwo)
                                                .filter(n -> n % 2 == 0)
                                                .collect(Collectors.toList());
        System.out.println(filteredIntList);
        System.out.println(intList);
    }

    private static void predicate() {
        Predicate<Integer> dividesByTwo = x -> x % 2 == 0;
        Predicate<Integer> dividesByThree = x -> x % 3 == 0;

        System.out.println(dividesByTwo.test(5));

        Predicate<Integer> dividesByTwoOrThree = dividesByThree.or(dividesByTwo);
        Predicate<Integer> dividesByTwoAndThree = dividesByThree.and(dividesByTwo);

        System.out.println(dividesByTwoOrThree.test(8));
        System.out.println(dividesByTwoAndThree.test(6));
        System.out.println(dividesByTwoAndThree.test(9));
    }

    private static void function() {
        Function<Integer, Integer> add = x -> x + 3;
        Function<Integer, Integer> multiply = x -> x * 2;

        Function<Integer, Integer> multiplyThenAdd = multiply.andThen(add);
        Function<Integer, Integer> multiplyThenAdd2 = add.compose(multiply);

        Function<Integer, Integer> addThenMultiply = add.andThen(multiply);
        Function<Integer, Integer> addThenMultiply2 = multiply.compose(add);

        System.out.println(multiplyThenAdd.apply(3));
        System.out.println(multiplyThenAdd2.apply(3));
        System.out.println(addThenMultiply.apply(3));
        System.out.println(addThenMultiply2.apply(3));
    }

    private static void comparable() {
        ComparableClass c1 = new ComparableClass();
        ComparableClass c2 = new ComparableClass();
        c1.compareTo(c2);

        Comparable<ComparableClass> comparableFunction = (other2) -> 2; // where this???
    }

    private static void basics() {
        NumbersProcessor doubleFunction = (x) -> System.out.println(x * x);
        doubleFunction.function(3);

        NumbersProcessor tripleFunction = z ->
        {
            System.out.println(z * z * z);
            System.out.println("triple");
        };

        tripleFunction.function(5);

        NumbersProcessor identityFunction = System.out::println;
        useNumberProcessorFunction(identityFunction, 5);


    }

    private static void useNumberProcessorFunction(NumbersProcessor processingFunction, int x) {
        processingFunction.function(x);
    }
}
