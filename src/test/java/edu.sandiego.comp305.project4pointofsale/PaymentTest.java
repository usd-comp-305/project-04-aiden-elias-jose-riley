package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentTest {

    @Test
    public void constructorSetsPaymentIdAmountMethodAndPendingStatus() {
        final PaymentMethod method = new SuccessfulPaymentMethod();
        final Payment payment = new Payment(1, 25.00, method);

        assertEquals(1, payment.getPaymentId());
        assertEquals(25.00, payment.getAmount(), 0.001);
        assertEquals(PaymentStatus.PENDING, payment.getPaymentStatus());

    }

    @Test
    public void processPaymentApprovesSuccessfulPayment() {
        final PaymentMethod method = new SuccessfulPaymentMethod();
        final Payment payment = new Payment(1, 25.00, method);

        final boolean result = payment.processPayment();

        assertTrue(result);
        assertEquals(PaymentStatus.APPROVED, payment.getPaymentStatus());
    }

    @Test
    public void processPaymentDeclinesFailedPayment() {
        final PaymentMethod method = new FailedPaymentMethod();
        final Payment payment = new Payment(1, 25.00, method);

        final boolean result = payment.processPayment();

        assertFalse(result);
        assertEquals(PaymentStatus.DECLINED, payment.getPaymentStatus());
    }

    @Test
    public void processPaymentDeclinesInvalidAmount() {
        final PaymentMethod method = new SuccessfulPaymentMethod();
        final Payment payment = new Payment(1, 0.00, method);

        final boolean result = payment.processPayment();

        assertFalse(result);
        assertEquals(PaymentStatus.DECLINED, payment.getPaymentStatus());
    }


    private static class SuccessfulPaymentMethod implements PaymentMethod {
        @Override
        public boolean pay(final double amount) {
            return true;
        }
    }

    private static class FailedPaymentMethod implements PaymentMethod {
        @Override
        public boolean pay(final double amount) {
            return false;
        }
    }
}