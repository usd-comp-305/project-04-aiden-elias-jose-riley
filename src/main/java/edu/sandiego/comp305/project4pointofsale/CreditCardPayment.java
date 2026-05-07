package edu.sandiego.comp305.project4pointofsale;

public class CreditCardPayment implements PaymentMethod {

    private String cardNumber;

    private String cardHolderName;

    public CreditCardPayment(final String cardNumber,
                             final String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public boolean pay(final double amount){
        return false;
    }

    public boolean validateCard(){
        return false;
    }
}
