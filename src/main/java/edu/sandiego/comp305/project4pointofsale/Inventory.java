package edu.sandiego.comp305.project4pointofsale;

public class Inventory {
    private static Ingredient steak = new Ingredient("steak");
    private static Ingredient pasta = new Ingredient("pasta");
    private static Ingredient patty = new Ingredient("patty");
    private static Ingredient cheese = new Ingredient("cheese");
    private static Ingredient lettuce = new Ingredient("lettuce");
    private static Ingredient tomato = new Ingredient("tomato");
    private static Ingredient onion = new Ingredient("onion");

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

    public static Ingredient getSteak(){
        return steak;
    }

    public static Ingredient getPasta() {
        return pasta;
    }

    public static Ingredient getPatty() {
        return patty;
    }

    public static Ingredient getCheese() {
        return cheese;
    }

    public static Ingredient getLettuce() {
        return lettuce;
    }

    public static Ingredient getTomato() {
        return tomato;
    }

    public static Ingredient getOnion() {
        return onion;
    }
}
