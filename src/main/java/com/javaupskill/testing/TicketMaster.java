package com.javaupskill.testing;

import java.time.LocalDate;
import java.util.Objects;

public class TicketMaster {
    int ID = 333;

    Bank bank;

    public TicketMaster(Bank bank) {
        this.bank = bank;
    }

    public TicketType buyColdplayTickets(int funds) throws Exception {
        if (!bank.isPaymentEnabled())
        {
            throw new Exception("Payment provider not reachable");
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
