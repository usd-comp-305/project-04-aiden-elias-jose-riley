package edu.sandiego.comp305.project4pointofsale;

public class MobilePayment implements PaymentMethod {
    private final String provider;

    public MobilePayment(final String provider) {
        this.provider = provider;
    }

    @Override
    public boolean pay(final double amount) {
        return amount > 0 && verifyAccount();
    }

    public boolean verifyAccount() {
        return provider != null && !provider.trim().isEmpty();
    }
}
