package edu.sandiego.comp305.project4pointofsale;

import java.util.ArrayList;
import java.util.List;

public class IngredientRepository {
    private static List<Ingredient> possibleIngredients;

    public IngredientRepository() {
        possibleIngredients = generateStandardIngredients();
    }

    private static List<Ingredient> generateStandardIngredients() {
        // create ingredients
        Ingredient steak = new Ingredient("steak", 15);
        Ingredient veganSteak = new Ingredient(
                "veganSteak", 20);
        Ingredient glutenFreeSteak = new Ingredient(
                "glutenFreeSteak", 20);
        Ingredient pasta = new Ingredient("pasta", 1.50);
        Ingredient veganPasta = new Ingredient(
                "veganPasta", 20);
        Ingredient glutenFreePasta = new Ingredient(
                "glutenFreePasta", 2.50);
        Ingredient patty = new Ingredient(
                "patty", 0.50);
        Ingredient veganPatty = new Ingredient(
                "veganPatty", 0.75);
        Ingredient glutenFreePatty = new Ingredient(
                "glutenFreePatty", 0.75);
        Ingredient cheese = new Ingredient(
                "cheese", 0.25);
        Ingredient lettuce = new Ingredient("lettuce", 0.10);
        Ingredient tomato = new Ingredient("tomato", 0.10);
        Ingredient onion = new Ingredient("onion", 0.10);
        Ingredient bun = new Ingredient("bun", 0.50);
        Ingredient pastaSauce = new Ingredient(
                "pastaSauce", 2.50);

        // make empty list for ingredients
        List<Ingredient> ingredients = new ArrayList<>();

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

    public double getPrice(final String ingredientName) {
        return findIngredientByName(ingredientName).getPrice();
    }

    public Ingredient getIngredient(final String ingredientName) {
        return findIngredientByName(ingredientName);
    }

    private Ingredient findIngredientByName(final String ingredientName) {
        for (Ingredient i : possibleIngredients) {
            if (i.getName().equals(ingredientName)) {
                return i;
            }
        }

        throw new IllegalArgumentException("Ingredient does not exist");
    }
}
