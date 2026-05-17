package edu.sandiego.comp305.project4pointofsale;

public class Ingredient {

    public final String name;

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


}
