package edu.sandiego.comp305.project4pointofsale;


import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private static final int
            STANDARD_NUMBER_OF_STARTING_INGREDIENTS = 100;

    // all caps to cooperate with checkstyle
    private static final Map<Ingredient, Integer>
            INGREDIENT_QUANTITY_MAP = new HashMap<>();

    private Inventory() {

    }

    static {
        populateIngredients();
    }

    private static void populateIngredients() {
        restockIngredients(STANDARD_NUMBER_OF_STARTING_INGREDIENTS);
    }

    public static int getIngredientQuantity(final Ingredient ingredient) {
        if (!INGREDIENT_QUANTITY_MAP.containsKey(ingredient)) {
            return 0;
        }
        return INGREDIENT_QUANTITY_MAP.get(ingredient);
    }

    public static void restockIngredients(final int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException(
                    "Restock quantity cannot be negative: " + quantity);
        }
        for (Ingredient i :
                IngredientRepository.getIngredientOptions()) {
            INGREDIENT_QUANTITY_MAP.put(i, quantity);
        }
    }

    public static boolean takeIngredient(final Ingredient ingredient,
                                         final int quantity) {
        if(INGREDIENT_QUANTITY_MAP.containsKey(ingredient)) {
            final int currentStock = INGREDIENT_QUANTITY_MAP.get(ingredient);

            if(currentStock >= quantity) {
                INGREDIENT_QUANTITY_MAP.put(
                        ingredient, currentStock - quantity);
                return true;
            }
        }

        return false;
    }
}
