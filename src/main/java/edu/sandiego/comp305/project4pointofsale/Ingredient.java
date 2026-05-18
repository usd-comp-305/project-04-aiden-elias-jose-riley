package edu.sandiego.comp305.project4pointofsale;

public class Ingredient {

    public String name;

    private int quantity;

    public Ingredient(final String name, final int quantity){
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(final int used){
        if (used > quantity){
            this.quantity = 0;
        } else {
            quantity -= used;
        }
    }
}
