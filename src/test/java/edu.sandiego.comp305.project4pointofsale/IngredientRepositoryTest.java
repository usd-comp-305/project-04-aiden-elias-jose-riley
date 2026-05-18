package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IngredientRepositoryTest {
    
    private static IngredientRepository ingredientRepository = null;

    @BeforeAll
    static void setup(){
        final ingredientRepository = new IngredientRepository();
    }

    @Test
     void getPriceOfIngredientInRepo() {
        final double storedPrice = ingredientRepository.getPrice("steak");

        assertEquals(15, storedPrice);
    }

    @Test
     void getPriceOfIngredientNotInRepo() {
        assertThrows(IllegalArgumentException.class, () -> ingredientRepository.getPrice("a"));
    }

    @Test
    void getIngredientInRepo() {
        final Ingredient testSteak = new Ingredient("steak", 15);

        assertEquals(testSteak,ingredientRepository.getIngredient("steak"));
    }
}
