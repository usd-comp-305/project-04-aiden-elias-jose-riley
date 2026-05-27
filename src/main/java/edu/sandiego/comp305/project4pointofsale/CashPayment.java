package edu.sandiego.comp305.project4pointofsale;

public class CashPayment implements PaymentMethod {
    private final double cashReceived;

    private double amountPaid;

    public CashPayment(final double cashReceived) {
        this.cashReceived = cashReceived;
        this.amountPaid = 0.0;
    }

    @Override
    public boolean pay(final double amount) {
        if (cashReceived >= amount){
            amountPaid += amount;
            return true;
        }
        return false;
    }

    public double calculateChange() {
        return cashReceived - amountPaid;
    }

    public double getCashReceived() {
        return cashReceived;
    }
}
