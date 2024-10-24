package com.javaupskill.class_design.exceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Exceptions {
    public static void main(String[] args) {

//        simpleTry();
//        tryWithResources(); // preferred


        try {
            validateAge(10);
        }
        catch (TooYoungException e) {
            throw new RuntimeException(e);
        }
        catch (InvalidAgeException e) {
            throw new RuntimeException(e);
        }
//        catch (InvalidAgeException | TooYoungException e) {
//            System.out.println("invalid age");
//        }
    }

    private static void tryWithResources() {
        try (Scanner scanner = new Scanner(new File("test.txt"));) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }

    private static void simpleTry() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("test.txt"));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    public static boolean validateAge(int age) throws InvalidAgeException, TooYoungException {
        if (age <= 0) {
            throw new InvalidAgeException("Age is not valid");
        } else if (age < 18) {
            throw new TooYoungException("Age is under 18");
        }
        return true;
    }

    private static void testExceptionTypes() {
        try {
            openMissingFile();
        } catch (FileNotFoundException e) {
            System.out.println("am gasit eroare");
        } finally {
            System.out.println("finally");
        }


//        divideByZero();
        System.out.println(sumUntilN(100));
    }

    // checked exception
    public static void openMissingFile() throws FileNotFoundException {
        File file = new File("i'm not even a path");
        BufferedReader br = new BufferedReader(new FileReader(file));
    }
    // unchecked
    public static void divideByZero() {
        int a = 3;
        int b = 0;

        System.out.println(a / b);
    }

    // error
    public static int sumUntilN(int N) {
        if (N == 1) return 1;

        return N + sumUntilN(N - 1);
    }

    // tail recursion, but IT DOESN'T WORK IN JAVA!!
    public static int sumUntilN(int N, int accumulator) {
        if (N == 1) return accumulator + N;

        return sumUntilN(N - 1, accumulator + N);
    }

}
