package edu.sandiego.comp305.project4pointofsale;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int orderId;

    private final int serverId;

    private final String serverName;

    private final List<MenuItem> items;

    private int sentItemCount;

    public Order(final Order order) {
        this.orderId = order.orderId;
        this.serverId = order.serverId;
        this.serverName = order.serverName;
        this.items = new ArrayList<>(order.items);
        this.sentItemCount = order.sentItemCount;
    }

    public Order(final int orderId, final Server server){
        this.orderId = orderId;
        this.serverId = server.getId();
        this.serverName = server.getName();
        this.items = new ArrayList<>();
        this.sentItemCount = 0;
    }


    public int getOrderId(){
        return orderId;
    }

    public int getServerId(){
        return this.serverId;
    }

    public String getServerName(){
        return this.serverName;
    }

    public int getSentItemCount() {
        return sentItemCount;
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

    public void removeItem(final MenuItem item){
        for (int i = sentItemCount; i < items.size(); i++) {
            if (items.get(i).equals(item)) {
                items.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("item not in cart or already sent");
    }

    public void markItemsAsSent(){
        sentItemCount = items.size();
    }
}
