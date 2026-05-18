package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChefTest {

    @Test
    void getRole() {
        final Chef chef = new Chef(22, "Elias", "hello2");

        assertEquals(StaffRole.CHEF, chef.getRole());
    }

    @Test
    void startTicket() {
        final Chef chef = new Chef(22, "Elias", "hello2");

        final Server server = new Server(1, "EliasServerVersion", "1234");

        Order order = new Order(30, server);

        KitchenTicket ticket = new KitchenTicket(501, order);

        chef.startTicket(ticket);

        assertEquals(Status.IN_PROCESS, ticket.getStatus());
    }

    @Test
    void markTicketReady() {
        final Chef chef = new Chef(22, "Elias", "hello2");

        final Server server = new Server(1, "EliasServerVersion", "1234");

        Order order = new Order(30, server);

        KitchenTicket ticket = new KitchenTicket(501, order);

        chef.markTicketReady(ticket);

        assertEquals(Status.COMPLETED, ticket.getStatus());
    }

    @Test
    void markTicketDelivered() {
        final Chef chef = new Chef(22, "Elias", "hello2");

        final Server server = new Server(1, "EliasServerVersion", "1234");

        Order order = new Order(30, server);

        KitchenTicket ticket = new KitchenTicket(501, order);

        chef.markTicketDelivered(ticket);

        assertEquals(Status.DELIVERED, ticket.getStatus());

    }
}
