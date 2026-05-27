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
        this.description = "A savory plant-based burger topped with " +
                "fresh lettuce, tomato, pickles, and vegan sauce " +
                "on a toasted bun.";
        this.cost = 29.99;
        this.ingredients = new ArrayList<>(List.of(
                IngredientRepository.getIngredient("bun"),
                IngredientRepository.getIngredient("veganPatty"),
                IngredientRepository.getIngredient("cheese"),
                IngredientRepository.getIngredient("lettuce"),
                IngredientRepository.getIngredient("onion"),
                IngredientRepository.getIngredient("cheese"),
                IngredientRepository.getIngredient("lettuce"),
                IngredientRepository.getIngredient("onion"),
                IngredientRepository.getIngredient("tomato")
        ));
    }
}
