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
        ingredientQuantities = new HashMap<>();
        populateIngredients();
    }

    private static void populateIngredients() {
        restockIngredients(STANDARD_NUMBER_OF_STARTING_INGREDIENTS);
    }

    public static int getIngredientQuantity(final Ingredient ingredient) {
        if (!ingredientQuantities.containsKey(ingredient)) {
            return 0;
        }
        return ingredientQuantities.get(ingredient);
    }

    public static void restockIngredients(final int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException(
                    "Restock quantity cannot be negative: " + quantity);
        }
        for (Ingredient i :
                IngredientRepository.getIngredientOptions()) {
            ingredientQuantities.put(i, quantity);
        }
    }

    public boolean takeIngredient(final Ingredient ingredient,
                                  final int quantity) {
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
