package edu.sandiego.comp305.project4pointofsale;

import java.util.List;

public class GlutenFreePasta extends MenuItem {
    public GlutenFreePasta(final List<Ingredient> ingredients){
        super(ingredients);
    }

    public GlutenFreePasta(){}

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public double getCost() {
        return 0;
    }
}
