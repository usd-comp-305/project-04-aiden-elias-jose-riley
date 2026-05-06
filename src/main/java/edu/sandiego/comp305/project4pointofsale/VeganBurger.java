package edu.sandiego.comp305.project4pointofsale;

import java.util.List;

public class VeganBurger extends MenuItem {
    public VeganBurger(List<Ingredient> ingredients){
        super(ingredients);
    }

    public VeganBurger(){}

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public double getCost() {
        return 0;
    }
}
