package edu.sandiego.comp305.project4pointofsale;

import java.util.ArrayList;
import java.util.List;

public class IngredientRepository {
    private static List<Ingredient> possibleIngredients;

    private IngredientRepository() {

    }

    private static void instantiateRepository() {
        possibleIngredients = generateStandardIngredients();
    }

    private static List<Ingredient> generateStandardIngredients() {
        // create ingredients
        final Ingredient steak = new Ingredient("steak", 15);
        final Ingredient veganSteak = new Ingredient(
                "veganSteak", 20);
        final Ingredient glutenFreeSteak = new Ingredient(
                "glutenFreeSteak", 20);
        final Ingredient pasta = new Ingredient("pasta", 1.50);
        final Ingredient veganPasta = new Ingredient(
                "veganPasta", 20);
        final Ingredient glutenFreePasta = new Ingredient(
                "glutenFreePasta", 2.50);
        final Ingredient patty = new Ingredient(
                "patty", 0.50);
        final Ingredient veganPatty = new Ingredient(
                "veganPatty", 0.75);
        final Ingredient glutenFreePatty = new Ingredient(
                "glutenFreePatty", 0.75);
        final Ingredient cheese = new Ingredient(
                "cheese", 0.25);
        final Ingredient lettuce = new Ingredient("lettuce", 0.10);
        final Ingredient tomato = new Ingredient("tomato", 0.10);
        final Ingredient onion = new Ingredient("onion", 0.10);
        final Ingredient bun = new Ingredient("bun", 0.50);
        final Ingredient pastaSauce = new Ingredient(
                "pastaSauce", 2.50);

        // make empty list for ingredients
        final List<Ingredient> ingredients = new ArrayList<>();

        // add each ingredient to list
        ingredients.add(steak);
        ingredients.add(veganSteak);
        ingredients.add(glutenFreeSteak);
        ingredients.add(pasta);
        ingredients.add(veganPasta);
        ingredients.add(glutenFreePasta);
        ingredients.add(patty);
        ingredients.add(veganPatty);
        ingredients.add(glutenFreePatty);
        ingredients.add(cheese);
        ingredients.add(lettuce);
        ingredients.add(tomato);
        ingredients.add(onion);
        ingredients.add(bun);
        ingredients.add(pastaSauce);

        return ingredients;
    }

    public static double getPrice(final String ingredientName) {
        verifyInstantiation();
        return findIngredientByName(ingredientName).getPrice();
    }

    public static Ingredient getIngredient(final String ingredientName) {
        verifyInstantiation();
        return findIngredientByName(ingredientName);
    }

    private static Ingredient findIngredientByName(
            final String ingredientName) {
        for (Ingredient i : possibleIngredients) {
            if (i.getName().equals(ingredientName)) {
                return i;
            }
        }

        throw new IllegalArgumentException("Ingredient does not exist");
    }

    private static void verifyInstantiation() {
        if (possibleIngredients == null) {
            instantiateRepository();
        }
    }

    public static double sumCostOfEachItem() {
        instantiateRepository();

        double sum = 0.0;

        for (final Ingredient i : possibleIngredients) {
            sum += i.getPrice();
        }

        return sum;
    }
}
