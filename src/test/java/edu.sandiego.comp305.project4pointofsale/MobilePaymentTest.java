package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MobilePaymentTest {

    @Test
    public void validMobilePaymentIsApproved() {
        final MobilePayment payment = new MobilePayment("Apple Pay");

        final boolean result = payment.pay(20.00);

        assertTrue(result);
    }

    @Test
    public void mobilePaymentFailsWithEmptyProvider() {
        final MobilePayment payment = new MobilePayment("");

        final boolean result = payment.pay(20.00);

        assertFalse(result);
    }

    @Test
    public void mobilePaymentFailsWithNullProvider() {
        final MobilePayment payment = new MobilePayment(null);

        final boolean result = payment.pay(20.00);

        assertFalse(result);
    }

    @Test
    public void mobilePaymentFailsWithBlankProvider() {
        final MobilePayment payment = new MobilePayment("   ");

        final boolean result = payment.pay(20.00);

        assertFalse(result);
    }

    @Test
    public void mobilePaymentFailsWithInvalidAmount() {
        final MobilePayment payment = new MobilePayment("Apple Pay");

        final boolean result = payment.pay(0.00);

        assertFalse(result);
    }

    @Test
    public void verifyAccountReturnsTrueForValidProvider() {
        final MobilePayment payment = new MobilePayment("Google Pay");

        final boolean result = payment.verifyAccount();

        assertTrue(result);
    }

    @Test
    public void verifyAccountReturnsFalseForInvalidProvider() {
        final MobilePayment payment = new MobilePayment("");

        final boolean result = payment.verifyAccount();

        assertFalse(result);
    }
}
