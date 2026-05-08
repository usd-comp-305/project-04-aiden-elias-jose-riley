package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class StaffTest {

    @Test
    void constructor(){
        Staff elias = Mockito.mock(Staff.class, Mockito.withSettings().useConstructor(42, "Alex", "password").defaultAnswer(Mockito.CALLS_REAL_METHODS));

        assertEquals(42, elias.getId());
        assertEquals("Alex", elias.getName());

    }

    @Test
    void login() {
        Staff elias = Mockito.mock(Staff.class, Mockito.withSettings().useConstructor(42, "Alex", "password").defaultAnswer(Mockito.CALLS_REAL_METHODS));

        assertTrue(elias.login("password"));
    }

    @Test
    void getId() {
        Staff elias = Mockito.mock(Staff.class, Mockito.withSettings().useConstructor(42, "Alex", "password").defaultAnswer(Mockito.CALLS_REAL_METHODS));

        assertEquals(42, elias.getId());
    }

    @Test
    void getName() {
        Staff elias = Mockito.mock(Staff.class, Mockito.withSettings().useConstructor(42, "Alex", "password").defaultAnswer(Mockito.CALLS_REAL_METHODS));

        assertEquals("Alex", elias.getName());
    }

    @Test
    void setId() {
        Staff elias = Mockito.mock(Staff.class, Mockito.withSettings().useConstructor(42, "Alex", "password").defaultAnswer(Mockito.CALLS_REAL_METHODS));

        elias.setId(1);

        assertEquals(1, elias.getId());

    }

    @Test
    void setName() {
        Staff elias = Mockito.mock(Staff.class, Mockito.withSettings().useConstructor(42, "Alex", "password").defaultAnswer(Mockito.CALLS_REAL_METHODS));

        elias.setName("Elias");

        assertEquals("Elias", elias.getName());


    }
}