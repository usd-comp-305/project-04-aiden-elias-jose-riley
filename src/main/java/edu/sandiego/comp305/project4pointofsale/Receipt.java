package edu.sandiego.comp305.project4pointofsale;

public class Receipt {
    private final int receiptId;
    private final String date;
    private boolean printed;
    private boolean emailed;

    public Receipt(final int receiptId, final String date) {
        this.receiptId = receiptId;
        this.date = date;
        this.printed = false;
        this.emailed = false;
    }

    public int getReceiptId() {
        return receiptId;
    }

    public String getDate() {
        return date;
    }

    public boolean isPrinted() {
        return printed;
    }

    public boolean isEmailed() {
        return emailed;
    }

    public void printReceipt() {
        printed = true;
    }

    public void emailReceipt() {
        emailed = true;
    }
}