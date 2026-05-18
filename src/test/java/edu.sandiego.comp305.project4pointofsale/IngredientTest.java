package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

    @Test
    void getName() {
        final Ingredient ingredient = new Ingredient("vegetable", 4);

        assertEquals("vegetable", ingredient.getName());
    }

    @Test
    void getQuantity() {
        final Ingredient ingredient = new Ingredient("vegetable", 4);

        assertEquals(4, ingredient.getQuantity());
    }

    @Test
    void reduceQuantity() {
        final Ingredient ingredient = new Ingredient("vegetable", 4);

        ingredient.reduceQuantity(1);

        assertEquals(3, ingredient.getQuantity());
    }

    @Test
    void reduceQuantityNeverBelow0() {
        final Ingredient ingredient = new Ingredient("vegetable", 4);

        ingredient.reduceQuantity(5);

        assertEquals(0, ingredient.getQuantity());

    }
}
