package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReceiptTest {

    @Test
    public void constructorSetsReceiptIdAndDate() {
        final Receipt receipt = new Receipt(1, "2026-05-12");

        assertEquals(1, receipt.getReceiptId());
        assertEquals("2026-05-12", receipt.getDate());
    }

    @Test
    public void receiptStartsAsNotPrinted() {
        final Receipt receipt = new Receipt(1, "2026-05-12");

        assertFalse(receipt.isPrinted());
    }

    @Test
    public void printReceiptMarksReceiptAsPrinted() {
        final Receipt receipt = new Receipt(1, "2026-05-12");

        receipt.printReceipt();

        assertTrue(receipt.isPrinted());
    }

    @Test
    public void receiptStartsAsNotEmailed() {
        final Receipt receipt = new Receipt(1, "2026-05-12");

        assertFalse(receipt.isEmailed());
    }

    @Test
    public void emailReceiptMarksReceiptAsEmailed() {
        final Receipt receipt = new Receipt(1, "2026-05-12");

        receipt.emailReceipt();

        assertTrue(receipt.isEmailed());
    }
}
