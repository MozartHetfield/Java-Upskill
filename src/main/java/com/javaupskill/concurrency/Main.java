package com.javaupskill.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        threads();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Runnable task1 = () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("1");
        };
        Runnable task2 = () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("2");
        };
        Runnable task3 = () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("3");
        };

        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);

        executorService.shutdown();

    }

    private static void threads() throws InterruptedException {
        //        System.out.println("Before sleep");
//        Thread.sleep(2000);
//        System.out.println("After sleep");

        MyThread thread1 = new MyThread();

        MyRunnable myRunnable = new MyRunnable();
        Thread thread2 = new Thread(myRunnable);

        System.out.println("Before start");

        thread1.start();
        thread2.start();
//        thread1.run();
//        thread2.run();

        // process all we want until threads are finished
//        System.out.println("intermediary work");

        thread1.join(); // block thread0 (the main one) until thread1 finishes
        thread2.join(1000); // block thread0 (the main one) until thread2 finishes

        System.out.println("After start"); // process using thread1 resource
//        for (int i = 0; i < 1000; i++)
//            System.out.println("After start");
    }
}
