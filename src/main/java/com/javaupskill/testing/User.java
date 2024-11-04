package com.javaupskill.testing;

public class User {
    int numberOfTickets = 0;

    public boolean buyTicket() {
        numberOfTickets++;
        return true;
    }

    public boolean initTransaction() throws InterruptedException {
        Thread.sleep(5000);
        return true;
    }
}
