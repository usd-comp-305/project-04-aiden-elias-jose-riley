package edu.sandiego.comp305.project4pointofsale;

import java.util.List;

public class GlutenFreeSteak extends MenuItem {
    public GlutenFreeSteak(final List<Ingredient> ingredients){
        super(ingredients);
    }

    public GlutenFreeSteak(){}

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public double getCost() {
        return 0;
    }
}
