package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CashPaymentTest {

    @Test
    public void cashPaymentApprovesWhenCashIsEnough() {
        final CashPayment payment = new CashPayment(20.00);

        final boolean result = payment.pay(15.00);

        assertTrue(result);
    }

    @Test
    public void cashPaymentFailsWhenNotEnoughCash() {
        final CashPayment payment = new CashPayment(10.00);

        final boolean result = payment.pay(15.00);

        assertFalse(result);
    }

    @Test
    public void calculatesCorrectChange() {
        final CashPayment payment = new CashPayment(20.00);

        payment.pay(15.00);

        assertEquals(5.00, payment.calculateChange());
    }
}
