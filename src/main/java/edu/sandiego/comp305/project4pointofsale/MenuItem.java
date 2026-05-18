package edu.sandiego.comp305.project4pointofsale;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuItem {

    String description;

    List<Ingredient> ingredients;

    double cost;

    //for custom orders, use is not yet implemented
    MenuItem(final List<Ingredient> ingredients){
        this.ingredients = new ArrayList<>(ingredients);
    }

    MenuItem(){
        this.ingredients = null;
    }

    public List<Ingredient> getIngredients() {
        assert ingredients != null;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final MenuItem casted = (MenuItem) o;
        return casted.ingredients.equals(this.ingredients)
                && this.cost == casted.cost
                && this.description.equals(casted.description);
    }
}
