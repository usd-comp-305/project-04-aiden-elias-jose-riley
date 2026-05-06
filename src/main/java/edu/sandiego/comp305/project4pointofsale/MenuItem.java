package edu.sandiego.comp305.project4pointofsale;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuItem {

    public MenuItem(List<Ingredient> ingredients){
        this.ingredients = ingredients;
    }

    String description;

    List<Ingredient> ingredients = new ArrayList<>();

    double cost;

    public List<Ingredient> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    public String getDescription(){
        return description;
    }

    public double getCost(){
        return cost;
    }

    public void setCost(final double cost) {
        this.cost = cost;
    }


    public void addIngredients(final Ingredient ingredient){
        this.ingredients.add(ingredient);
    }

    public void setDescription(final String description) {
        this.description = description;
    }
}
