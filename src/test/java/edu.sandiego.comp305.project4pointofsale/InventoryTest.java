package edu.sandiego.comp305.project4pointofsale;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {

    @Test
    void getIngredientQuantity() {
        Inventory.restockIngredients(100);
        final Ingredient ingredient =
                IngredientRepository.getIngredientOptions().get(0);

        final int quantity = Inventory.getIngredientQuantity(ingredient);

        assertEquals(100, quantity);
    }

    @Test
    void restockIngredients() {
        Inventory.restockIngredients(50);
        final Ingredient ingredient =
                IngredientRepository.getIngredientOptions().get(0);

        assertEquals(50, Inventory.getIngredientQuantity(ingredient));
    }

    @Test
    void restockIngredientsNegativeThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> Inventory.restockIngredients(-1));
    }

    @Test
    void takeIngredient() {
        Inventory.restockIngredients(100);
        final Ingredient ingredient =
                IngredientRepository.getIngredientOptions().get(0);

        final boolean taken = Inventory.takeIngredient(ingredient, 10);

        assertTrue(taken);
        assertEquals(90, Inventory.getIngredientQuantity(ingredient));
    }

    @Test
    void takeIngredientInsufficientStock() {
        Inventory.restockIngredients(5);
        final Ingredient ingredient =
                IngredientRepository.getIngredientOptions().get(0);

        final boolean taken = Inventory.takeIngredient(ingredient, 10);

        assertFalse(taken);
        assertEquals(5, Inventory.getIngredientQuantity(ingredient));
    }
}
