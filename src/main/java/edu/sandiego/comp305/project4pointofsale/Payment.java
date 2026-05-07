package edu.sandiego.comp305.project4pointofsale;

public class Payment {

    private int paymentId;

    private double amount;

    private PaymentStatus paymentStatus;

    private PaymentMethod paymentMethod;

    public Payment(final int paymentId,
                   final double amount,
                   final PaymentMethod paymentMethod) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public boolean processPayment(){
        return false;
    }

    public boolean refundPayment(){
        return false;
    }

    public int getPaymentId(){
        return paymentId;
    }

    public double getAmount(){
        return amount;
    }

    public PaymentStatus getPaymentStatus(){
        return paymentStatus;
    }

    public PaymentMethod getPaymentMethod(){
        return paymentMethod;
    }
}
