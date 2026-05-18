package edu.sandiego.comp305.project4pointofsale;


public class Inventory {
    private static Ingredient steak = new Ingredient("steak",100);

    private static Ingredient veganSteak = new Ingredient(
            "veganSteak", 100);

    private static Ingredient glutenFreeSteak = new Ingredient(
            "glutenFreeSteak", 100);

    private static Ingredient pasta = new Ingredient("pasta", 100);

    private static Ingredient veganPasta = new Ingredient(
            "veganPasta", 100);

    private static Ingredient glutenFreePasta = new Ingredient(
            "glutenFreePasta", 100);

    private static Ingredient patty = new Ingredient(
            "patty", 100);

    private static Ingredient veganPatty = new Ingredient(
            "veganPatty", 100);

    private static Ingredient glutenFreePatty = new Ingredient(
            "glutenFreePatty", 100);

    private static Ingredient cheese = new Ingredient(
            "cheese", 100);

    private static Ingredient lettuce = new Ingredient("lettuce", 100);

    private static Ingredient tomato = new Ingredient("tomato", 100);

    private static Ingredient onion = new Ingredient("onion", 100);

    private static Ingredient bun = new Ingredient("bun", 100);

    private static Ingredient pastaSauce = new Ingredient(
            "pastaSauce", 100);

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
        return new Ingredient(steak.getName(),steak.getPrice());
    }

    public static Ingredient getPasta() {
        return new Ingredient(pasta.getName(),pasta.getPrice());
    }

    public static Ingredient getPatty() {
        return new Ingredient(patty.getName(),patty.getPrice());
    }

    public static Ingredient getCheese() {
        return new Ingredient(cheese.getName(),cheese.getPrice());
    }

    public static Ingredient getLettuce() {
        return new Ingredient(lettuce.getName(),lettuce.getPrice());
    }

    public static Ingredient getTomato() {
        return new Ingredient(tomato.getName(),tomato.getPrice());
    }

    public static Ingredient getOnion() {
        return new Ingredient(onion.getName(),onion.getPrice());
    }

    public static Ingredient getBun() {
        return new Ingredient(bun.getName(),bun.getPrice());
    }

    public static Ingredient getVeganSteak() {
        return new Ingredient(veganSteak.getName(),veganSteak.getPrice());
    }

    public static Ingredient getVeganPasta() {
        return new Ingredient(veganPasta.getName(),veganPasta.getPrice());
    }

    public static Ingredient getGlutenFreePasta() {
        return new Ingredient(glutenFreePasta.getName(),glutenFreePasta.getPrice());
    }

    public static Ingredient getGlutenFreeSteak() {
        return new Ingredient(glutenFreeSteak.getName(),glutenFreeSteak.getPrice());
    }

    public static Ingredient getVeganPatty() {
        return new Ingredient(veganPatty.getName(),veganPatty.getPrice());
    }

    public static Ingredient getGlutenFreePatty() {
        return new Ingredient(glutenFreePatty.getName(),glutenFreePatty.getPrice());
    }

    public static Ingredient getPastaSauce() {
        return new Ingredient(pastaSauce.getName(),pastaSauce.getPrice());
    }

}
