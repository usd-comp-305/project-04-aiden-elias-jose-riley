package edu.sandiego.comp305.project4pointofsale;

import java.util.ArrayList;
import java.util.List;

public class VeganSteak extends MenuItem {
    public VeganSteak(final List<Ingredient> ingredients){
        super(ingredients);
        this.description = "A hearty plant-based steak, seared and" +
                " seasoned, served with herbs and a savory " +
                "vegan sauce.\n";
        this.cost = 49.99;
    }

    public VeganSteak(){
        final IngredientRepository ir = new IngredientRepository();

        this.description = "A hearty plant-based steak, seared and" +
                " seasoned, served with herbs and a savory " +
                "vegan sauce.\n";
        this.cost = 49.99;
        this.ingredients = new ArrayList<>(List.of(
                ir.getIngredient("veganSteak")));
    }
}
