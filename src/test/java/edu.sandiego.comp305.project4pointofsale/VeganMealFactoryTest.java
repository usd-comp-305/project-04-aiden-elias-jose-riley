package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VeganMealFactoryTest {

    @Test
    public void factoryCreatesCorrectBurger(){
        VeganMealFactory factory = new VeganMealFactory();
        MenuItem burger = factory.createBurger();

        assertEquals(new VeganBurger().getIngredients(), burger.getIngredients());
    }

    @Test
    public void factoryCreatesCorrectPasta(){
        VeganMealFactory factory = new VeganMealFactory();
        MenuItem pasta = factory.createPasta();

        assertEquals(new VeganPasta().getIngredients(), pasta.getIngredients());
    }

    @Test
    public void factoryCreatesCorrectSteak(){
        VeganMealFactory factory = new VeganMealFactory();
        MenuItem steak = factory.createSteak();

        assertEquals(new VeganSteak().getIngredients(), steak.getIngredients());
    }
}
