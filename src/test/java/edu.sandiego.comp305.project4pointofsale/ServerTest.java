package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServerTest {

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

        assertEquals(server.getId(), order.getServerId());
    }

    @Test
    void addItemToOrder() {
        final POSSystem pos = new POSSystem();
        final Server server = new Server(22, "Elias", "hello");

        final Order order = server.createOrder(pos);
        server.addItemToOrder(order, new VeganBurger());

        assertEquals(1, order.getItems().size());
    }

    @Test
    void submitOrder() {
        final POSSystem pos = new POSSystem();
        final Server server = new Server(22, "Elias", "hello");

        final Order order = server.createOrder(pos);
        server.addItemToOrder(order, new VeganBurger());
        server.submitOrder(pos, order);

        assertEquals(1, pos.getNumOrders());
    }

    @Test
    void calculateOrderTotal() {
        final POSSystem pos = new POSSystem();
        final Server server = new Server(22, "Elias", "hello");

        final Order order = server.createOrder(pos);
        server.addItemToOrder(order, new VeganBurger());

        assertEquals(29.99, server.calculateOrderTotal(order));
    }
}
