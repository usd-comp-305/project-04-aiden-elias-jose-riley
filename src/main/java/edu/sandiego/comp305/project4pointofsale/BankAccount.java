package edu.sandiego.comp305.project4pointofsale;

import java.util.HashMap;
import java.util.Map;

public class BankAccount {
    private static final double STANDARD_STARTING_BALANCE
            = 5000.00;

    private static final double[] BASE_EMPLOYEE_SALARIES_FOR_DAY
            = {120.00,200.00};

    private static final int STANDARD_RESTOCK_QUANTITY
            = 100;


    private static double accountBalance
            = STANDARD_STARTING_BALANCE;

    private static double restockCost
            = STANDARD_RESTOCK_QUANTITY
              * IngredientRepository.sumCostOfEachItem();


    private static final Map<StaffRole,Double> employeeDailySalaries
            = new HashMap<>();

    private static final StaffRepository staffRepository
            = new StaffRepository();


    private BankAccount() {

    }

    public static void initializeEmployeeSalaries() {
        for (int i = 0;
             i < BASE_EMPLOYEE_SALARIES_FOR_DAY.length
                     && i < StaffRole.values().length; i++) {
            employeeDailySalaries.put(StaffRole.values()[i],
                    BASE_EMPLOYEE_SALARIES_FOR_DAY[i]);
        }
    }

    public static void updateCostOfRestock() {
        restockCost = STANDARD_RESTOCK_QUANTITY * IngredientRepository.sumCostOfEachItem();
    }

    public static void updateCostOfRestockWithCustomQuantity(
            final int numberOfEachIngredient) {
        restockCost = numberOfEachIngredient * IngredientRepository.sumCostOfEachItem();
    }

    public static boolean payEmployeeesDailyWages() {
        final double payment = calculateDailyEmployeeWages();

        if (payment > accountBalance) {
            return false;
        }

        accountBalance -= payment;
        return true;
    }

    private static double calculateDailyEmployeeWages() {
        final int[] staffRolesCounts = staffRepository.getRoleCounts();
        double wageSum = 0.0;

        for( int i = 0; i < staffRolesCounts.length; i++ ) {
            wageSum += staffRolesCounts[i]
                    * employeeDailySalaries.get(StaffRole.values()[i]);
        }

        return wageSum;
    }

    public static void addIncome(final double amount) {
        if (amount < 0.0) {
            throw new IllegalArgumentException("Income cannot be negative");
        }
        accountBalance += amount;
    }

    public static void resetBalance() {
        accountBalance = STANDARD_STARTING_BALANCE;
    }

    public static double getAccountBalance() {
        return accountBalance;
    }
}
