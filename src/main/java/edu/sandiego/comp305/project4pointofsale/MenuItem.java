package edu.sandiego.comp305.project4pointofsale;

import java.util.List;

public abstract class MenuItem {


    String description;


    List<Ingredient> ingredients;

    double cost;

    public List<Ingredient> getIngredients() {
        return null;
    }

    String getDescription(){
        return description;
    }

    double getCost(){
        return cost;
    }
}
