package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GlutenFreeMealFactoryTest {

    @Test
    public void factoryCreatesCorrectBurger(){
        GlutenFreeMealFactory factory = new GlutenFreeMealFactory();
        MenuItem burger = factory.createBurger();

        assertEquals(new GlutenFreeBurger().getIngredients(), burger.getIngredients());
    }

    @Test
    public void factoryCreatesCorrectPasta(){
        GlutenFreeMealFactory factory = new GlutenFreeMealFactory();
        MenuItem pasta = factory.createPasta();

        assertEquals(new GlutenFreePasta().getIngredients(), pasta.getIngredients());
    }

    @Test
    public void factoryCreatesCorrectSteak(){
        GlutenFreeMealFactory factory = new GlutenFreeMealFactory();
        MenuItem steak = factory.createSteak();

        assertEquals(new GlutenFreeSteak().getIngredients(), steak.getIngredients());
    }
}
