package edu.sandiego.comp305.project4pointofsale;

public class Ingredient {

    public String name;

    private int quantity;

    public Ingredient(String name){
        this.name = name;
        quantity = 100;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
