package edu.sandiego.comp305.project4pointofsale;

public class Inventory {
    private static Ingredient steak = new Ingredient("steak",100);
    private static Ingredient veganSteak = new Ingredient("veganSteak", 100);
    private static Ingredient glutenFreeSteak = new Ingredient("glutenFreeSteak", 100);
    private static Ingredient pasta = new Ingredient("pasta", 100);
    private static Ingredient veganPasta = new Ingredient("veganPasta", 100);
    private static Ingredient glutenFreePasta = new Ingredient("glutenFreePasta", 100);
    private static Ingredient patty = new Ingredient("patty", 100);
    private static Ingredient veganPatty = new Ingredient("veganPatty", 100);
    private static Ingredient glutenFreePatty = new Ingredient("glutenFreePatty", 100);
    private static Ingredient cheese = new Ingredient("cheese", 100);
    private static Ingredient lettuce = new Ingredient("lettuce", 100);
    private static Ingredient tomato = new Ingredient("tomato", 100);
    private static Ingredient onion = new Ingredient("onion", 100);
    private static Ingredient bun = new Ingredient("bun", 100);
    private static Ingredient pastaSauce = new Ingredient("pastaSauce", 100);

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

    public static Ingredient getBun() {
        return bun;
    }

    public static Ingredient getVeganSteak() {
        return veganSteak;
    }

    public static Ingredient getVeganPasta() {
        return veganPasta;
    }

    public static Ingredient getGlutenFreePasta() {
        return glutenFreePasta;
    }

    public static Ingredient getGlutenFreeSteak() {
        return glutenFreeSteak;
    }

    public static Ingredient getVeganPatty() {
        return veganPatty;
    }

    public static Ingredient getGlutenFreePatty() {
        return glutenFreePatty;
    }

    public static Ingredient getPastaSauce() {
        return pastaSauce;
    }

}
