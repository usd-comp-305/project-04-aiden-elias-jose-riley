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

    private static class SuccessfulPaymentMethod implements PaymentMethod {
        @Override
        public boolean pay(final double amount) {
            return true;
        }
    }
}