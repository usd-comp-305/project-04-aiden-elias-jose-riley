package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void removeItemLeavesCartEmpty(){
        final Server server = new Server(2, "elias", "hello");
        final Order order = new Order(1, server);
        final MenuItem menuItem = new VeganBurger();

        order.addItem(menuItem);
        order.removeItem(menuItem);

        assertTrue(order.getItems().isEmpty());
    }

    @Test
    void removeItemWithDuplicatesLeavesOne(){

    }

    @Test
    void removeItemUpdatesTotal(){

    }

    @Test
    void removeItemNotInCartThrowsException(){

    }

    @Test
    void getOrderInfoFromConstructor() {
        final Server server = new Server(2, "elias", "hello");
        final Order order = new Order(1, server);

        assertEquals(1, order.getOrderId());
        assertEquals(server.getId(), order.getServerId());
    }

    @Test
    void orderStartsEmpty() {
        final Server server = new Server(2, "elias", "hello");
        final Order order = new Order(1, server);

        assertTrue(order.getItems().isEmpty());
    }


    @Test
    void addItem() {
        final Server server = new Server(2, "elias", "hello");
        final Order order = new Order(1, server);
        final MenuItem menuItem = new VeganBurger();

        order.addItem(menuItem);

        assertEquals(1, order.getItems().size());

    }

    @Test
    void getItems() {
        final Server server = new Server(2, "elias", "hello");
        final Order order = new Order(1, server);
        final MenuItem menuItem = new VeganBurger();

        order.addItem(menuItem);

        assertInstanceOf(VeganBurger.class, order.getItems().getFirst());
    }

    @Test
    void calculateTotal() {
        final Server server = new Server(2, "elias", "hello");
        final Order order = new Order(1, server);
        final List<Ingredient> ingredients = new ArrayList<>();

        final MenuItem menuItem = new VeganBurger(ingredients);

        order.addItem(menuItem);

        assertEquals(29.99, order.calculateTotal());

    }
}
