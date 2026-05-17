package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

    @Test
    void getName() {
        Ingredient ingredient = new Ingredient("vegetable", 4);

        assertEquals("vegetable", ingredient.getName());
    }

    @Test
    void getQuantity() {
        Ingredient ingredient = new Ingredient("vegetable", 4);

        assertEquals(4, ingredient.getQuantity());
    }

    @Test
    void reduceQuantity() {
        Ingredient ingredient = new Ingredient("vegetable", 4);

        ingredient.reduceQuantity(1);

        assertEquals(3, ingredient.getQuantity());
    }

    @Test
    void reduceQuantityNeverBelow0() {
        Ingredient ingredient = new Ingredient("vegetable", 4);

        ingredient.reduceQuantity(5);

        assertEquals(0, ingredient.getQuantity());

    }
}
