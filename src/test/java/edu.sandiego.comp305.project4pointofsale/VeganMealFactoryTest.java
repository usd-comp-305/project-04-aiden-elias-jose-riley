package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VeganMealFactoryTest {

    @Test
    public void factoryCreatesCorrectBurger(){
        final VeganMealFactory factory = new VeganMealFactory();
        final MenuItem burger = factory.createBurger();

        assertEquals(new VeganBurger().getIngredients().toString(),
                burger.getIngredients().toString());
    }

    @Test
    public void factoryCreatesCorrectPasta(){
        final VeganMealFactory factory = new VeganMealFactory();
        final MenuItem pasta = factory.createPasta();

        assertEquals(new VeganPasta().getIngredients().toString(),
                pasta.getIngredients().toString());
    }

    @Test
    public void factoryCreatesCorrectSteak(){
        final VeganMealFactory factory = new VeganMealFactory();
        final MenuItem steak = factory.createSteak();

        assertEquals(new VeganSteak().getIngredients().toString(),
                steak.getIngredients().toString());
    }
}
