package edu.sandiego.comp305.project4pointofsale;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuItem {


    String description;


    List<Ingredient> ingredients;

    double cost;

    public List<Ingredient> getIngredients() {
        List<Ingredient> returnIngredients = new ArrayList<>(ingredients);
        return returnIngredients;
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


    public void addIngredients(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
