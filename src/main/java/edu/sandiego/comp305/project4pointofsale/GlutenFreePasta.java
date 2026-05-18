package edu.sandiego.comp305.project4pointofsale;

import java.util.ArrayList;
import java.util.List;

public class GlutenFreePasta extends MenuItem {
    public GlutenFreePasta(final List<Ingredient> ingredients){
        super(ingredients);
        this.description = "Tender gluten-free pasta tossed with " +
                "fresh ingredients and a flavorful house sauce.\n";
        this.cost = 15.99;
    }

    public GlutenFreePasta(){
        final IngredientRepository ir = new IngredientRepository();

        this.description = "Tender gluten-free pasta tossed with " +
                "fresh ingredients and a flavorful house sauce.\n";
        this.cost = 15.99;
        this.ingredients = new ArrayList<>(List.of(
                ir.getIngredient("glutenFreePasta"), ir.getIngredient("pastaSauce")));
    }
}
