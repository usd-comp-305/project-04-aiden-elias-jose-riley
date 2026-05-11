package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChefTest {

    @Test
    void getRole() {
        Chef chef = new Chef(22, "Elias", "hello2");

        assertEquals(StaffRole.CHEF, chef.getRole());
    }

    @Test
    void createOrder() {
    }

    @Test
    void sendOrder() {
    }
}