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
    public boolean pay(final double amount) {
        return amount > 0 && validateCard();
    }

    public boolean validateCard() {
        return cardNumber != null
                && cardHolderName != null
                && !cardNumber.isBlank()
                && !cardHolderName.isBlank()
                && cardNumber.length() == 16
                && cardNumber.matches("\\d+");
    }

    public String getCardNumber(){
        return cardNumber;
    }

    public String getCardHolderName(){
        return cardHolderName;
    }
}
