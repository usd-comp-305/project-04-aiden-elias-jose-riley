package edu.sandiego.comp305.project4pointofsale;


import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private static final int
            STANDARD_NUMBER_OF_STARTING_INGREDIENTS = 100;

    private static Map<Ingredient, Integer> ingredientQuantities;

    private Inventory() {

    }

    static {
        ingredientQuantities = populateIngredients();
    }

    private static void populateIngredientsWithStandardAmount() {
        final Map<Ingredient, Integer> newIQ = new HashMap<>();
        for(Ingredient i : IngredientRepository.getIngredientOptions()) {
            ingredientQuantities.put(i,STANDARD_NUMBER_OF_STARTING_INGREDIENTS);
        }
        ingredientQuantities = newIQ;
    }

    private static void restockIngredients(final int num) {
        for(Ingredient i : IngredientRepository.getIngredientOptions()) {
            ingredientQuantities.put(i,STANDARD_NUMBER_OF_STARTING_INGREDIENTS);
        }
        ingredientQuantities = newIQ;
    }

    public boolean takeIngredient(final Ingredient ingredient, final int quantity) {
        if(ingredientQuantities.containsKey(ingredient)) {
            final int currentStock = ingredientQuantities.get(ingredient);

            if(currentStock >= quantity) {
                ingredientQuantities.put(ingredient, currentStock - quantity);
                return true;
            }
        }

        return false;
    }
}
