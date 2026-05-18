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
        IngredientRepository ir = new IngredientRepository();

        this.description = "A juicy gluten-free burger wrapped " +
                "in crisp lettuce and topped with fresh veggies " +
                "and savory sauce.";
        this.cost = 13.99;
        this.ingredients = new ArrayList<>(List.of(
                ir.getIngredient("bun"),
                ir.getIngredient("glutenFreePatty"),
                ir.getIngredient("cheese"), ir.getIngredient("lettuce"),
                ir.getIngredient("onion"), ir.getIngredient("cheese"),
                ir.getIngredient("lettuce"), ir.getIngredient("onion"),
                ir.getIngredient("tomato")));
    }
}
