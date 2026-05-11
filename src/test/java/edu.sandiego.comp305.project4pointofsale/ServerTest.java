package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServerTest {

    @Test
    void getRole() {
        Server server = new Server(22, "Elias", "hello");

        assertEquals(StaffRole.SERVER, server.getRole());
    }

    @Test
    void viewTickets() {
    }

    @Test
    void updateOrderStatus() {
    }

    @Test
    void checkInventory() {
    }
}