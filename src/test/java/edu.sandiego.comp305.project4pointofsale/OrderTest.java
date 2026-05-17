package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void getOrderInfoFromConstructor() {
        Server server = new Server(2, "elias", "hello");
        Order order = new Order(1, server);

        assertEquals(1, order.getOrderId());
        assertEquals(server, order.getServer());
    }

    @Test
    void orderStartsEmpty() {
        Server server = new Server(2, "elias", "hello");
        Order order = new Order(1, server);

        assertTrue(order.getItems().isEmpty());
    }


    @Test
    void addItem() {
        Server server = new Server(2, "elias", "hello");
        Order order = new Order(1, server);
        MenuItem menuItem = new VeganBurger();

        order.addItem(menuItem);

        assertEquals(1, order.getItems().size());

    }

    @Test
    void getItems() {
        Server server = new Server(2, "elias", "hello");
        Order order = new Order(1, server);
        MenuItem menuItem = new VeganBurger();

        order.addItem(menuItem);

        assertInstanceOf(VeganBurger.class, order.getItems().getFirst());
    }

    @Test
    void calculateTotal() {
        Server server = new Server(2, "elias", "hello");
        Order order = new Order(1, server);
        List<Ingredient> ingredients = new ArrayList<>();

        MenuItem menuItem = new VeganBurger(ingredients);

        order.addItem(menuItem);

        assertEquals(29.99, order.calculateTotal());

    }
}
