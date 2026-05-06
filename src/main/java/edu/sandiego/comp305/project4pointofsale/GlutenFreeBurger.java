package edu.sandiego.comp305.project4pointofsale;

import java.util.List;

public class GlutenFreeBurger extends MenuItem {
    public GlutenFreeBurger(final List<Ingredient> ingredients){
        super(ingredients);
    }

    public GlutenFreeBurger(){}

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public double getCost() {
        return 0;
    }
}
