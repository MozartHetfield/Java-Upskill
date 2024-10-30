package com.javaupskill.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicketMasterTest {

    TicketMaster ticketMaster = new TicketMaster();

    @Test
    public void testBuyColdplayTicket_whenFundsAreTooLow_thenReturnInvalidTicket() {
        //given
        int funds = 301;

        //when
        TicketType ticketType = ticketMaster.buyColdplayTickets(funds);

        //then
        assertEquals(TicketType.VIP, ticketType, "Incorrect ticket type returned");
    }


}
