package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

    @Test
    void getName() {
        final Ingredient ingredient = new Ingredient("vegetable", 0.5);

        assertEquals("vegetable", ingredient.getName());
    }

    @Test
    void getPrice() {
        final Ingredient ingredient = new Ingredient("vegetable", 0.5);

        assertEquals(0.5, ingredient.getPrice());
    }

    @Test
    void setNormalPrice() {
        final Ingredient ingredient = new Ingredient("vegetable", 0.5);

        ingredient.setPrice(0.75);

        assertEquals(0.75, ingredient.getPrice());
    }

    @Test
    void setNegativePrice() {
        final Ingredient ingredient = new Ingredient("vegetable", 0.5);

        assertThrows(IllegalArgumentException.class, () -> {
            ingredient.setPrice(-1);
        });

    }

    @Test
    void setZeroPrice() {
        final Ingredient ingredient = new Ingredient("vegetable", 0.5);

        ingredient.setPrice(0);

        assertEquals(0, ingredient.getPrice());

    }

}
