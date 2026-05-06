package edu.sandiego.comp305.project4pointofsale;

import java.util.List;

public class VeganPasta extends MenuItem {
    public VeganPasta(final List<Ingredient> ingredients){
        super(ingredients);
    }

    public VeganPasta(){}

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public double getCost() {
        return 0;
    }
}
