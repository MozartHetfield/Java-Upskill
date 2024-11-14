package com.javaupskill.concurrency;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 8; i++) {
            System.out.println("MyRunnable: " + i);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
