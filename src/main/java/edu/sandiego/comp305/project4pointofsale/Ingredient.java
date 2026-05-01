package edu.sandiego.comp305.project4pointofsale;

public class Ingredient {

    public String name;

    private int quantity;

    public Ingredient(){
        name = "";
        quantity = 0;
    }

    public String getName() {
        return name;
    }
    public int getQuantity() {
        return quantity;
    }
}
