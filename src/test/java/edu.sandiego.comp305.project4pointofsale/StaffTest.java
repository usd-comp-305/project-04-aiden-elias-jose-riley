package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class StaffTest {

    @Test
    void constructor(){
        final Staff elias = Mockito.mock(Staff.class, Mockito.withSettings()
                .useConstructor(42, "Alex", "password")
                .defaultAnswer(Mockito.CALLS_REAL_METHODS));

        assertEquals(42, elias.getId());
        assertEquals("Alex", elias.getName());

    }

    @Test
    void correctPassowrd() {
        final Staff elias = Mockito.mock(Staff.class, Mockito.withSettings()
                .useConstructor(42, "Alex", "password")
                .defaultAnswer(Mockito.CALLS_REAL_METHODS));

        assertTrue(elias.correctPassowrd("password"));
    }

    @Test
    void getId() {
        final Staff elias = Mockito.mock(Staff.class, Mockito.withSettings()
                .useConstructor(42, "Alex", "password")
                .defaultAnswer(Mockito.CALLS_REAL_METHODS));

        assertEquals(42, elias.getId());
    }

    @Test
    void getName() {
        final Staff elias = Mockito.mock(Staff.class, Mockito.withSettings()
                .useConstructor(42, "Alex", "password")
                .defaultAnswer(Mockito.CALLS_REAL_METHODS));
        assertEquals("Alex", elias.getName());
    }

    @Test
    void setId() {
        final Staff elias = Mockito.mock(Staff.class, Mockito.withSettings()
                .useConstructor(42, "Alex", "password")
                .defaultAnswer(Mockito.CALLS_REAL_METHODS));

        elias.setId(1);

        assertEquals(1, elias.getId());

    }

    @Test
    void setName() {
        final Staff elias = Mockito.mock(Staff.class, Mockito.withSettings()
                .useConstructor(42, "Alex", "password")
                .defaultAnswer(Mockito.CALLS_REAL_METHODS));

        elias.setName("Elias");

        assertEquals("Elias", elias.getName());


    }
}
