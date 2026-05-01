package edu.sandiego.comp305.project4pointofsale;

import java.util.List;

public abstract class MenuItem {


    String description;


    List<Ingredient> ingredients;

    double cost;

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    String getDescription(){
        return description;
    }

    double getCost(){
        return cost;
    }

    public void setCost(final double cost) {
        this.cost = cost;
    }

    public void setIngredients(final List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setDescription(final String description) {
        this.description = description;
    }
}
