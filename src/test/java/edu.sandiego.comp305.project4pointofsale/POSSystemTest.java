package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class POSSystemTest {

    @BeforeEach
    void resetIncome(){
        Inventory.resetIncome();
    }

    @Test
    void createOrderWithIds() {
        final POSSystem pos = new POSSystem();

        final Server elias = new Server(1, "elias", "1234");

        final Order order = pos.createOrder(elias);

        assertEquals(17001, order.getOrderId());
        assertEquals(elias.getId(), order.getServerId());
    }

    @Test
    void incrementId() {
        final POSSystem pos = new POSSystem();

        final Server elias = new Server(1, "elias", "1234");

        final Order order1 = pos.createOrder(elias);
        final Order order2 = pos.createOrder(elias);


        assertEquals(17001, order1.getOrderId());
        assertEquals(17002, order2.getOrderId());


    }

    @Test
    void PlaceOrder() {
        final POSSystem pos = new POSSystem();

        final Server elias = new Server(1, "elias", "1234");

        final Order order1 = pos.createOrder(elias);

        pos.placeOrder(order1);


        assertEquals(1, pos.getNumOrders());
    }

    @Test
    void KitchenTicketCreated() {
        final POSSystem pos = new POSSystem();

        final Server elias = new Server(1, "elias", "1234");

        final Order order1 = pos.createOrder(elias);
        pos.placeOrder(order1);


        assertEquals(1, pos.getNumKitchenTickets());
        assertEquals(501, pos.getPlacedKitchenTickets()
                .getFirst().getTicketId());

    }

    @Test
    void ProfitIsAdded() {
        final POSSystem pos = new POSSystem();

        final Server elias = new Server(1, "elias", "1234");

        final Order order1 = pos.createOrder(elias);
        final VeganBurger burger = new VeganBurger();
        order1.addItem(burger);

        pos.placeOrder(order1);


        assertEquals(29.99, pos.getProfit());
    }

}
