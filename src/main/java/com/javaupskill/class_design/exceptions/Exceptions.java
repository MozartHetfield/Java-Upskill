package com.javaupskill.class_design.exceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Exceptions {
    public static void main(String[] args) {

        try {
            openMissingFile();
        } catch (FileNotFoundException e) {
            System.out.println("am gasit eroare");
//            throw new RuntimeException(e);
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
