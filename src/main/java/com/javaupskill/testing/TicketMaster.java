package com.javaupskill.testing;

public class TicketMaster {
    public TicketType buyColdplayTickets(int funds) {
        if (funds == 300) {
            return TicketType.VIP;
        }
        if (funds == 200) {
            return TicketType.CategoryA;
        }
        if (funds == 100) {
            return TicketType.CategoryB;
        }

        return TicketType.Invalid;
    }
}
