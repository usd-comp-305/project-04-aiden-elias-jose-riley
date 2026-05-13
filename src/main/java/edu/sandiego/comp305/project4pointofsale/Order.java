package edu.sandiego.comp305.project4pointofsale;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int orderId;
    private final Server server;
    private final List<MenuItem> items;


    public Order(final int orderId, Server server){
        this.orderId = orderId;
        this.server = server;
        this.items = new ArrayList<>();
    }

    public void addItem(final MenuItem item){}

    public double calculateTotal(){
        return 0;
    }
}
