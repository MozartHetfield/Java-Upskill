package com.javaupskill.testing;

import java.util.Random;

public class Bank {
    public boolean isPaymentEnabled() {
        Random randomGenerator = new Random();
        int value = randomGenerator.nextInt(2);
        return value < 1;
    }
}
