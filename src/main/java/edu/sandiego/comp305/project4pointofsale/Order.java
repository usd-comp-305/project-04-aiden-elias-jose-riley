package edu.sandiego.comp305.project4pointofsale;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int orderId;

    private final Server server;

    private final List<MenuItem> items;

    public Order(final Order order) {
        this.orderId = order.orderId;
        this.server = order.server;
        this.items = new ArrayList<>(order.items);
    }

    public Order(final int orderId, final Server server){
        this.orderId = orderId;
        this.server = server;
        this.items = new ArrayList<>();
    }


    public int getOrderId(){
        return orderId;
    }

    public Server getServer(){
        return server;
    }


    public void addItem(final MenuItem item){
        items.add(item);
    }

    public List<MenuItem> getItems(){
        return new ArrayList<>(items);
    }

    public double calculateTotal(){
        double total = 0.0;

        for (MenuItem item : items){
            total += item.getCost();
        }

        return total;
    }
}
