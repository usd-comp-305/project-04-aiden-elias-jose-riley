package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private static final double STANDARD_STARTING_BALANCE = 5000.00;

    @BeforeEach
    void resetAccountBalanceBeforeEachTest() {
        BankAccount.resetBalance();
    }

    @Test
    void getAccountBalanceReturnsStartingBalanceOnFreshAccount() {
        final double balance = BankAccount.getAccountBalance();

        assertEquals(STANDARD_STARTING_BALANCE, balance);
    }

    @Test
    void addIncomeIncreasesAccountBalance() {
        final double incomeAmount = 250.50;
        final double expectedBalance = STANDARD_STARTING_BALANCE + incomeAmount;

        BankAccount.addIncome(incomeAmount);

        assertEquals(expectedBalance, BankAccount.getAccountBalance());
    }

    @Test
    void addIncomeWithZeroDoesNotChangeBalance() {
        BankAccount.addIncome(0.0);

        assertEquals(STANDARD_STARTING_BALANCE, BankAccount.getAccountBalance());
    }

    @Test
    void addIncomeWithMultipleAmountsAccumulates() {
        final double firstIncome = 100.00;
        final double secondIncome = 200.00;
        final double expectedBalance = STANDARD_STARTING_BALANCE + firstIncome + secondIncome;

        BankAccount.addIncome(firstIncome);
        BankAccount.addIncome(secondIncome);

        assertEquals(expectedBalance, BankAccount.getAccountBalance());
    }

    @Test
    void addIncomeWithNegativeAmountThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> BankAccount.addIncome(-1.0));
    }

    @Test
    void resetBalanceRestoresStartingBalanceAfterIncome() {
        BankAccount.addIncome(1000.00);

        BankAccount.resetBalance();

        assertEquals(STANDARD_STARTING_BALANCE, BankAccount.getAccountBalance());
    }

    @Test
    void payEmployeesDailyWagesReturnsTrueWhenBalanceIsSufficient() {
        final boolean paymentSucceeded = BankAccount.payEmployeeesDailyWages();

        assertTrue(paymentSucceeded);
    }

    @Test
    void payEmployeesDailyWagesDoesNotChangeBalance() {
        final double balanceBeforePayment = BankAccount.getAccountBalance();

        BankAccount.payEmployeeesDailyWages();

        assertEquals(balanceBeforePayment, BankAccount.getAccountBalance());
    }
}