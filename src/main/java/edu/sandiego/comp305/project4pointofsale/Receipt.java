package edu.sandiego.comp305.project4pointofsale;

public class Receipt {

    private int receiptId;

    private String date;

    public Receipt(final int receiptId, final String date){
        this.receiptId = receiptId;
        this.date = date;
    }

    public void printReceipt(){
    }

    public void emailReceipt(){
    }

    public int getReceiptId(){
        return receiptId;
    }

    public String getDate(){
        return date;
    }
}
