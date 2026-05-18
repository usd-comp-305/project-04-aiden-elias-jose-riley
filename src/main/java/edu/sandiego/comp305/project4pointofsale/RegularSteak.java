package edu.sandiego.comp305.project4pointofsale;

import java.util.ArrayList;
import java.util.List;

public class RegularSteak extends MenuItem {
    public RegularSteak(final List<Ingredient> ingredients){
        super(ingredients);
        this.description = "Chargrilled Rosemary Steak\n" +
                "A tender, flame-grilled steak " +
                "seasoned with cracked pepper, " +
                "sea salt, and fresh rosemary. Served " +
                "with a savory garlic butter glaze and " +
                "finished with a side of roasted vegetables " +
                "and creamy mashed potatoes.";
        this.cost = 35.99;
    }

    public RegularSteak(){
        final IngredientRepository ir = new IngredientRepository();

        this.description = "Chargrilled Rosemary Steak\n" +
                "A tender, flame-grilled steak " +
                "seasoned with cracked pepper, " +
                "sea salt, and fresh rosemary. Served " +
                "with a savory garlic butter glaze and " +
                "finished with a side of roasted vegetables " +
                "and creamy mashed potatoes.";
        this.cost = 35.99;
        this.ingredients = new ArrayList<>(List.of(
                ir.getIngredient("steak")));
    }
}
