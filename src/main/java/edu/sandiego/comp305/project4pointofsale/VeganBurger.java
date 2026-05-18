package edu.sandiego.comp305.project4pointofsale;

import java.util.ArrayList;
import java.util.List;

public class VeganBurger extends MenuItem {
    public VeganBurger(final List<Ingredient> ingredients){
        super(ingredients);
        this.description = "A savory plant-based burger topped with " +
                "fresh lettuce, tomato, pickles, and vegan sauce " +
                "on a toasted bun.";
        this.cost = 29.99;
    }

    public VeganBurger(){
        IngredientRepository ir = new IngredientRepository();

        this.description = "A savory plant-based burger topped with " +
                "fresh lettuce, tomato, pickles, and vegan sauce " +
                "on a toasted bun.";
        this.cost = 29.99;
        this.ingredients = new ArrayList<>(List.of(
                ir.getIngredient("bun"),
                ir.getIngredient("veganPatty"),
                ir.getIngredient("cheese"), ir.getIngredient("lettuce"),
                ir.getIngredient("onion"), ir.getIngredient("cheese"),
                ir.getIngredient("lettuce"), ir.getIngredient("onion"),
                ir.getIngredient("tomato")
        ));
    }
}
