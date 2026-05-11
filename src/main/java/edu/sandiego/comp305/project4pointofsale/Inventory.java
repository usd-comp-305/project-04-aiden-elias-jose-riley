package edu.sandiego.comp305.project4pointofsale;

public class Inventory {
    private static double income = 0.0;

    public static void addIncome(final double amount){
        income += amount;
    }

    public static double getIncome(){
        return income;
    }

    //mainly for testing
    public static void resetIncome(){
        income = 0.0;
    }

    public void checkStock(){}

    public void updateStock(){}
}
