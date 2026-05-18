package edu.sandiego.comp305.project4pointofsale;

import java.util.ArrayList;
import java.util.List;

public class POSSystem {

    private static final int STARTING_ORDER_ID = 17000;

    private static final int STARTING_TICKET_ID = 500;

    private final List<Order> orders;

    private final List<KitchenTicket> kitchenTickets;

    private int nextOrderId;
    private int nextTicketId;

    public POSSystem(){
        this.orders = new ArrayList<>();
        this.kitchenTickets = new ArrayList<>();
        this.nextOrderId = STARTING_ORDER_ID;
        this.nextTicketId = STARTING_TICKET_ID;
    }

    public Order createOrder(final Server loggedServer){
        nextOrderId++;
        return new Order(nextOrderId, loggedServer);
    }

    public void placeOrder(final Order order){

    }

    public KitchenTicket generateTicket(final Order order){
        return null;
    }

    public int getNumOrders(){
        return 0;
    }

    public int getNumKitchenTickets(){
        return 0;
    }

    public List<KitchenTicket> getKitchenTickets(){
        return null;
    }

    public double getProfit(){
        return 0;
    }



}
