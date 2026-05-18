package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IngredientRepositoryTest {

    @Test
    void getPriceOfIngredientInRepo() {
        final double storedPrice = IngredientRepository.getPrice("steak");

        assertEquals(15, storedPrice);
    }

    @Test
    void getPriceOfIngredientNotInRepo() {
        assertThrows(IllegalArgumentException.class,
                () -> IngredientRepository.getPrice("a"));
    }

    @Test
    void getIngredientInRepo() {
        final Ingredient testSteak = new Ingredient("steak", 15);

        assertEquals(testSteak,IngredientRepository.getIngredient("steak"));
    }
}
