package edu.sandiego.comp305.project4pointofsale;

public class Payment {

    private final int paymentId;

    private final double amount;

    private PaymentStatus paymentStatus;

    private final PaymentMethod paymentMethod;

    public Payment(final int paymentId,
                   final double amount,
                   final PaymentMethod paymentMethod) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public boolean processPayment(){
        if (amount <= 0 || paymentMethod == null) {
            paymentStatus = PaymentStatus.DECLINED;
            return false;
        }

        final boolean successful = paymentMethod.pay(amount);

        if (successful) {
            paymentStatus = PaymentStatus.APPROVED;
            return true;
        }

        paymentStatus = PaymentStatus.DECLINED;
        return false;
    }

    public boolean refundPayment(){
        if (paymentStatus == PaymentStatus.APPROVED) {
            paymentStatus = PaymentStatus.REFUNDED;
            return true;
        }
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

    public void setPaymentStatus(final PaymentStatus paymentStatus){
        this.paymentStatus = paymentStatus;
    }
}
