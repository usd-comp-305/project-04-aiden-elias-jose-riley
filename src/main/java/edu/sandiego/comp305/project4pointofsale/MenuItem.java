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

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
