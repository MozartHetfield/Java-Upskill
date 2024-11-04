package com.javaupskill.testing;

import java.time.LocalDate;

public class TicketMaster {
    int ID = 333;

    Bank bank;
    User user;

    public TicketMaster(Bank bank, User user) {
        this.bank = bank;
        this.user = user;
    }

    public TicketType buyColdplayTickets(int funds) throws Exception {

        user.buyTicket();
        user.initTransaction();

        if (bank.isLimitReached(funds))
        {
            throw new Exception("Limit reached");
        }

        if (!bank.isPaymentEnabled())
        {
            throw new Exception("Payment provider not reachable");
        }

        int tax = 5;
        if (!bank.areFundsAvailable(funds + tax, null))
        {
            throw new Exception("Not enough funds");
        }

        if (!areColdplayTicketsPurchaseable(LocalDate.now()))
        {
            throw new Exception("Tickets are no longer available");
        }

        if (funds == 300) {
            return TicketType.VIP;
        }
        if (funds == 200) {
            return TicketType.CategoryA;
        }
        if (funds == 100) {
            return TicketType.CategoryB;
        }

        throw new Exception("Invalid amount of funds");
    }

    public boolean areColdplayTicketsPurchaseable(LocalDate currentTime) {
        LocalDate lastDate = LocalDate.of(2025, 4, 25); // should be configurable, not hardcoded
        return lastDate.isAfter(currentTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketMaster that = (TicketMaster) o;
        return ID == that.ID;
    }

//    // equal from object
//    public boolean equals(Object obj) {
//        return (this == obj);
//    }

    //    public boolean areColdplayTicketsPurchaseable() {
//        LocalDate lastDate = LocalDate.of(2025, 4, 25);
//        return lastDate.isAfter(LocalDate.now());
//    }
}
