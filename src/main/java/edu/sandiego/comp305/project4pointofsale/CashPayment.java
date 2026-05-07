package edu.sandiego.comp305.project4pointofsale;

public class CashPayment implements PaymentMethod{
    private double cashReceived;

    public CashPayment(final double cashReceived){
        this.cashReceived = cashReceived;
    }

    @Override
    public boolean pay(final double amount){
        return false;
    }

    public double calculateChange(){
        return 0.0;
    }
}
