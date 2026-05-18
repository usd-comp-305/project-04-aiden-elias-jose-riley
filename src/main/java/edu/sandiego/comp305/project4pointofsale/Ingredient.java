package edu.sandiego.comp305.project4pointofsale;

import java.util.Objects;

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

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Ingredient casted = (Ingredient) o;
        return casted.name.equals(this.name)
                && this.price == casted.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
