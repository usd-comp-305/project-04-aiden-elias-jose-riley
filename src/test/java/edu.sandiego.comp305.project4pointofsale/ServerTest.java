package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServerTest {

    @BeforeEach
    void resetIncomeBeforeEachTest() {
        Inventory.resetIncome();
    }

    @Test
    void getRole() {
        final Server server = new Server(22, "Elias", "hello");

        assertEquals(StaffRole.SERVER, server.getRole());
    }

    @Test
    void createOrder() {
        final POSSystem pos = new POSSystem();
        final Server server = new Server(22, "Elias", "hello");

        final Order order = server.createOrder(pos);

    }

    @Test
    void addItemToOrder() {
    }

    @Test
    void submitOrder() {
    }

    @Test
    void calculateOrderTotal() {
    }
}
