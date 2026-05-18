package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GlutenFreeMealFactoryTest {

    @Test
    public void factoryCreatesCorrectBurger(){
        final GlutenFreeMealFactory factory = new GlutenFreeMealFactory();
        final MenuItem burger = factory.createBurger();

        assertEquals(new GlutenFreeBurger().getIngredients().toString(),
                burger.getIngredients().toString());
    }

    @Test
    public void factoryCreatesCorrectPasta(){
        final GlutenFreeMealFactory factory = new GlutenFreeMealFactory();
        final MenuItem pasta = factory.createPasta();

        assertEquals(new GlutenFreePasta().getIngredients().toString(),
                pasta.getIngredients().toString());
    }

    @Test
    public void factoryCreatesCorrectSteak(){
        final GlutenFreeMealFactory factory = new GlutenFreeMealFactory();
        final MenuItem steak = factory.createSteak();

        assertEquals(new GlutenFreeSteak().getIngredients().toString(),
                steak.getIngredients().toString());
    }
}
