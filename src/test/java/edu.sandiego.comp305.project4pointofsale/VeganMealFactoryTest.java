package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VeganMealFactoryTest {

    @Test
    public void factoryCreatesCorrectBurger(){
        final VeganMealFactory factory = new VeganMealFactory();
        final MenuItem burger = factory.createBurger();

        assertEquals(new VeganBurger().getIngredients(),
                burger.getIngredients());
    }

    @Test
    public void factoryCreatesCorrectPasta(){
        final VeganMealFactory factory = new VeganMealFactory();
        final MenuItem pasta = factory.createPasta();

        assertEquals(new VeganPasta().getIngredients(),
                pasta.getIngredients());
    }

    @Test
    public void factoryCreatesCorrectSteak(){
        final VeganMealFactory factory = new VeganMealFactory();
        final MenuItem steak = factory.createSteak();

        assertEquals(new VeganSteak().getIngredients(),
                steak.getIngredients());
    }
}
