package edu.sandiego.comp305.project4pointofsale;

import java.util.ArrayList;
import java.util.List;

public class VeganPasta extends MenuItem {
    public VeganPasta(final List<Ingredient> ingredients){
        super(ingredients);
        this.description = "A creamy vegan pasta tossed with fresh " +
                "vegetables, herbs, and a rich plant-based sauce.";
        this.cost = 22.99;
    }

    public VeganPasta(){
        final IngredientRepository ir = new IngredientRepository();

        this.description = "A creamy vegan pasta tossed with fresh " +
                "vegetables, herbs, and a rich plant-based sauce.";
        this.cost = 22.99;
        this.ingredients = new ArrayList<>(List.of(
                ir.getIngredient("veganPasta"),
                ir.getIngredient("pastaSauce")));
    }
}
