package edu.sandiego.comp305.project4pointofsale;

public class Ingredient {

    public final String name;

    private double price;

    public Ingredient(final String name, final double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double p) {
        if(p < 0) {
            throw new IllegalArgumentException();
        }
        price = p;
    }
}
