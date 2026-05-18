package edu.sandiego.comp305.project4pointofsale;

import java.util.ArrayList;
import java.util.List;

public class POSSystem {

    private static final int STARTING_ORDER_ID = 17000;

    private static final int STARTING_TICKET_ID = 500;

    private final List<Order> placedOrders;

    private final List<KitchenTicket> placedKitchenTickets;

    private int nextOrderId;

    private int nextTicketId;

    public POSSystem(){
        this.placedOrders = new ArrayList<>();
        this.placedKitchenTickets = new ArrayList<>();
        this.nextOrderId = STARTING_ORDER_ID;
        this.nextTicketId = STARTING_TICKET_ID;
    }

    public Order createOrder(final Server loggedServer){
        nextOrderId++;
        return new Order(nextOrderId, loggedServer);
    }

    public void placeOrder(final Order placedOrder){
        placedOrders.add(placedOrder);

        final KitchenTicket ticket = generateTicket(placedOrder);
        placedKitchenTickets.add(ticket);

        Inventory.addIncome(placedOrder.calculateTotal());
    }

    public KitchenTicket generateTicket(final Order placedOrder){
        nextTicketId++;
        return new KitchenTicket(nextTicketId, placedOrder);
    }

    public int getNumOrders(){
        return placedOrders.size();
    }

    public int getNumKitchenTickets(){
        return placedKitchenTickets.size();
    }

    public List<KitchenTicket> getPlacedKitchenTickets(){
        return new ArrayList<>(placedKitchenTickets);
    }

    public double getProfit(){
        return Inventory.getIncome();
    }
}
