package edu.sandiego.comp305.project4pointofsale;

public class Order {
    private final int orderId;

    public Order(final int orderId){
        this.orderId = orderId;
    }

    public Order(){
        this.orderId = -1;
    }

    public Order(final Order other){
        this.orderId = other.orderId;
    }

    public void addItem(final MenuItem item){}

    public double calculateTotal(){
        return 0;
    }
}
