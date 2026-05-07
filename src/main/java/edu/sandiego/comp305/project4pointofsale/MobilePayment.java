package edu.sandiego.comp305.project4pointofsale;

public class MobilePayment implements PaymentMethod {
    private String provider;

    public MobilePayment(final String provider){
        this.provider = provider;
    }

    @Override
    public boolean pay(double amount){
        return false;
    }

    public boolean verifyAccount(){
        return false;
    }
}
