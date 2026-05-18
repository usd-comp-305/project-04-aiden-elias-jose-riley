package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegularMealFactoryTest {

    @Test
    public void factoryCreatesCorrectIngredients(){
        RegularMealFactory factory = new RegularMealFactory();
        MenuItem burger = factory.createBurger();

        assertEquals(new RegularBurger().getIngredients(), burger.getIngredients());
    }
}
