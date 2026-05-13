package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KitchenTicketTest {

    @Test
    void testConstructor() {
        Server server = new Server(1, "elias", "1234");
        Order order = new Order(3, server);
        KitchenTicket kitchenTicket = new KitchenTicket(22, order);

        assertEquals(22, kitchenTicket.getTicketId());
        assertEquals(order, kitchenTicket.getTicketOrder());
        assertEquals(Status.ORDERED, kitchenTicket.getStatus());
    }

    @Test
    void updateTicket() {
        Server server = new Server(1, "elias", "1234");
        Order order = new Order(3, server);
        KitchenTicket kitchenTicket = new KitchenTicket(22, order);

        kitchenTicket.setStatus(Status.IN_PROCESS);

        assertEquals(Status.IN_PROCESS, kitchenTicket.getStatus());
    }

}