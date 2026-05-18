package edu.sandiego.comp305.project4pointofsale;

import java.util.ArrayList;
import java.util.List;

public class GlutenFreeBurger extends MenuItem {
    public GlutenFreeBurger(final List<Ingredient> ingredients){
        super(ingredients);
        this.description = "A juicy gluten-free burger wrapped " +
                "in crisp lettuce and topped with fresh veggies " +
                "and savory sauce.";
        this.cost = 13.99;
    }

    public GlutenFreeBurger(){
        this.description = "A juicy gluten-free burger wrapped " +
                "in crisp lettuce and topped with fresh veggies " +
                "and savory sauce.";
        this.cost = 13.99;
        this.ingredients = new ArrayList<>(List.of(
                IngredientRepository.getIngredient("bun"),
                IngredientRepository.getIngredient("glutenFreePatty"),
                IngredientRepository.getIngredient("cheese"),
                IngredientRepository.getIngredient("lettuce"),
                IngredientRepository.getIngredient("onion"),
                IngredientRepository.getIngredient("cheese"),
                IngredientRepository.getIngredient("lettuce"),
                IngredientRepository.getIngredient("onion"),
                IngredientRepository.getIngredient("tomato")));
    }
}
