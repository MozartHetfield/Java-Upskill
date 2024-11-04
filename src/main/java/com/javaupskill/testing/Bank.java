package com.javaupskill.testing;

import java.util.Random;

public class Bank {
    public boolean isPaymentEnabled() throws Exception {
        System.out.println("test");
        Random randomGenerator = new Random();
        int value = randomGenerator.nextInt(2);
        return value < 1;
    }

    public boolean areFundsAvailable(int funds, String password) {
        return true;
    }

    public boolean isLimitReached(int funds) {
        return true;
    }
}
