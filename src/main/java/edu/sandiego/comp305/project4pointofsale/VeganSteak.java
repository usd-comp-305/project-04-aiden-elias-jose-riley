package edu.sandiego.comp305.project4pointofsale;

import java.util.List;

public class VeganSteak extends MenuItem {
    public VeganSteak(final List<Ingredient> ingredients){
        super(ingredients);
    }

    public VeganSteak(){}

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public double getCost() {
        return 0;
    }
}
