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
        final Server server = new Server(2, "elias", "hello");
        final Order order = new Order(1, server);
        final MenuItem menuItem = new VeganBurger();

        order.addItem(menuItem);
        order.addItem(menuItem);
        order.removeItem(menuItem);

        assertEquals(1, order.getItems().size());
    }

    @Test
    void removeItemUpdatesTotal(){
        final Server server = new Server(2, "elias", "hello");
        final Order order = new Order(1, server);
        final MenuItem veganBurger = new VeganBurger();
        final MenuItem regularBurger = new RegularBurger();

        order.addItem(veganBurger);
        order.addItem(regularBurger);
        order.removeItem(veganBurger);

        assertEquals(13.99, order.calculateTotal());
    }

    @Test
    void removeItemNotInCartThrowsException(){
        final Server server = new Server(2, "elias", "hello");
        final Order order = new Order(1, server);
        final MenuItem menuItem = new VeganBurger();

        try {
            order.removeItem(menuItem);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {

        }
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

    @Test
    void removeItemAfterMarkingAsSentThrowsException(){
        final Server server = new Server(2, "elias", "hello");
        final Order order = new Order(1, server);
        final MenuItem menuItem = new VeganBurger();

        order.addItem(menuItem);
        order.markItemsAsSent();

        try{
            order.removeItem(menuItem);
            fail("Expected IllegalArgumentException to be thrown");
        }catch (IllegalArgumentException e){

        }
    }

    @Test
    void removeItemAddedAfterMarkAsSentWorks(){
        final Server server = new Server(2, "elias", "hello");
        final Order order = new Order(1, server);
        final MenuItem firstItem = new VeganBurger();
        final MenuItem secondItem = new RegularBurger();

        order.addItem(firstItem);
        order.markItemsAsSent();
        order.addItem(secondItem);
        order.removeItem(secondItem);

        assertEquals(1, order.getItems().size());
    }

    @Test
    void removeItemWithSentAndNonSentDuplicateRemovesNonSent(){
        final Server server = new Server(2, "elias", "hello");
        final Order order = new Order(1, server);
        final MenuItem firstBurger = new VeganBurger();
        final MenuItem secondBurger = new VeganBurger();

        order.addItem(firstBurger);
        order.markItemsAsSent();
        order.addItem(secondBurger);
        order.removeItem(secondBurger);

        assertEquals(1, order.getItems().size());
    }

    @Test
    void getItemsReturnsAllItemsIncludingSent(){
        final Server server = new Server(2, "elias", "hello");
        final Order order = new Order(1, server);
        final MenuItem firstItem = new VeganBurger();
        final MenuItem secondItem = new RegularBurger();

        order.addItem(firstItem);
        order.markItemsAsSent();
        order.addItem(secondItem);

        assertEquals(2, order.getItems().size());
    }
}
