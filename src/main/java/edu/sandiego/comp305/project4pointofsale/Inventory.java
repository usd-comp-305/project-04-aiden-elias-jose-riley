package edu.sandiego.comp305.project4pointofsale;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Ingredient> ingredients;
    private static double income = 0.0;

    public Inventory(){
        this.ingredients = new ArrayList<>();
    }

    private void loadDefaultIngredients(){

    }

    public int getIngredientCount(){
        return 0;
    }

    public Ingredient findIngredient(final String name){
        return null;
    }


    public void updateStock(){

    }

    // Riley's Stuff, he will implement these
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

}
