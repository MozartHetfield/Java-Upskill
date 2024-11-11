package com.javaupskill.others;

public class Complexity {

    public static void main(String[] args) {
        // https://www.bigocheatsheet.com/
        long N = 13;
        long M = 100 * 100 * 100 * 100;
        long Z = Long.MAX_VALUE;
        long K = 100 * 100;

        long now = System.currentTimeMillis();
        constantTime(Z);
        long end = System.currentTimeMillis();
        System.out.println("Constant time: " + (end - now));

        now = System.currentTimeMillis();
        linearTime(N * M);
        end = System.currentTimeMillis();
        System.out.println("Linear time: " + (end - now));

        now = System.currentTimeMillis();
        long iter = logTime(Z, 0);
        end = System.currentTimeMillis();
        System.out.println("Log time: " + (end - now) + " in iterations = " + iter);

//        now = System.currentTimeMillis();
//        quadraticTime(N * K);
//        end = System.currentTimeMillis();
//        System.out.println("Quadratic time: " + (end - now));
//
//        now = System.currentTimeMillis();
//        recursiveFibonacci(50);
//        end = System.currentTimeMillis();
//        System.out.println("Exponential time: " + (end - now));
//
//        now = System.currentTimeMillis();
//        factorialTime(13);
//        end = System.currentTimeMillis();
//        System.out.println("Factorial time: " + (end - now));
//        System.out.println(count);
    }

    static long constantTime(long N) {
        return N;
    }

    static long linearTime(long N) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum++;
        }
        return sum;
    }

    static long logTime(long N, int iter) {
        if (N == 0) {
            return iter;
        }
        return logTime(N / 2, iter + 1);
    }

    static long quadraticTime(long N) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum++;
            }
        }
        return sum;
    }

    static long recursiveFibonacci(long N) {
        if (N < 2) {
            return N;
        }
        return recursiveFibonacci(N - 1) + recursiveFibonacci(N - 2);
    }

    static void factorialTime(long N) {
        if (N == 0) {
//            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            factorialTime(N - 1);
        }
    }
}
