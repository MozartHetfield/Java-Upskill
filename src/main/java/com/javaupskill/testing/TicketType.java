package com.javaupskill.testing;

public enum TicketType {
    CategoryA(200),
    CategoryB(100),
    VIP(300);

    int funds;

    TicketType(int funds) {
        this.funds = funds;
    }
}
