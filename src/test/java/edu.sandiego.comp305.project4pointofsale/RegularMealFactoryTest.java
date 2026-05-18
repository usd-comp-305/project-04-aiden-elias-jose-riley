package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegularMealFactoryTest {

    @Test
    public void factoryCreatesCorrectBurger(){
        final RegularMealFactory factory = new RegularMealFactory();
        final MenuItem burger = factory.createBurger();

        assertEquals(new RegularBurger().getIngredients().toString(),
                burger.getIngredients().toString());
    }

    @Test
    public void factoryCreatesCorrectPasta(){
        final RegularMealFactory factory = new RegularMealFactory();
        final MenuItem pasta = factory.createPasta();

        assertEquals(new RegularPasta().getIngredients().toString(),
                pasta.getIngredients().toString());
    }

    @Test
    public void factoryCreatesCorrectSteak(){
        final RegularMealFactory factory = new RegularMealFactory();
        final MenuItem steak = factory.createSteak();

        assertEquals(new RegularSteak().getIngredients().toString(),
                steak.getIngredients().toString());
    }
}
