package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreditCardPaymentTest {

    @Test
    public void validCreditCardPaymentIsApproved() {
        final CreditCardPayment payment =
                new CreditCardPayment("1234567812345678", "Alex");

        final boolean result = payment.pay(25.00);

        assertTrue(result);
    }

    @Test
    public void creditCardPaymentFailsWithEmptyCardNumber() {
        final CreditCardPayment payment =
                new CreditCardPayment("", "Alex");

        final boolean result = payment.pay(25.00);

        assertFalse(result);
    }

    @Test
    public void creditCardPaymentFailsWithNullCardNumber() {
        final CreditCardPayment payment =
                new CreditCardPayment(null, "Alex");

        final boolean result = payment.pay(25.00);

        assertFalse(result);
    }

    @Test
    public void creditCardPaymentFailsWithShortCardNumber() {
        final CreditCardPayment payment =
                new CreditCardPayment("1234", "Alex");

        final boolean result = payment.pay(25.00);

        assertFalse(result);
    }

    @Test
    public void creditCardPaymentFailsWithEmptyCardholderName() {
        final CreditCardPayment payment =
                new CreditCardPayment("1234567812345678", "");

        final boolean result = payment.pay(25.00);

        assertFalse(result);
    }

    @Test
    public void creditCardPaymentFailsWithNullCardholderName() {
        final CreditCardPayment payment =
                new CreditCardPayment("1234567812345678", null);

        final boolean result = payment.pay(25.00);

        assertFalse(result);
    }

    @Test
    public void creditCardPaymentFailsWithInvalidAmount() {
        final CreditCardPayment payment =
                new CreditCardPayment("1234567812345678", "Alex");

        final boolean result = payment.pay(0.00);

        assertFalse(result);
    }
}
