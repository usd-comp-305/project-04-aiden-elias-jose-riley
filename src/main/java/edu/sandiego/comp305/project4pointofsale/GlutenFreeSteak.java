package edu.sandiego.comp305.project4pointofsale;

import java.util.ArrayList;
import java.util.List;

public class GlutenFreeSteak extends MenuItem {
    public GlutenFreeSteak(final List<Ingredient> ingredients){
        super(ingredients);
        this.description = "A tender gluten-free steak, grilled" +
                " to perfection and served with fresh " +
                "herbs and savory sauce.\n";
        this.cost = 34.99;
    }

    public GlutenFreeSteak(){
        IngredientRepository ir = new IngredientRepository();

        this.description = "A tender gluten-free steak, grilled" +
                " to perfection and served with fresh " +
                "herbs and savory sauce.\n";
        this.cost = 34.99;
        this.ingredients = new ArrayList<>(List.of(
                ir.getIngredient("glutenFreeSteak")));
    }
}
