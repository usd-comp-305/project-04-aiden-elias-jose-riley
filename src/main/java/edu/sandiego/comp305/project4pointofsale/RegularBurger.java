package edu.sandiego.comp305.project4pointofsale;

import java.util.ArrayList;
import java.util.List;

public class RegularBurger extends MenuItem {
    public RegularBurger(final List<Ingredient> ingredients){
        super(ingredients);
        this.description = "Grass fed patty with cheese, " +
                "lettuce, tomato, and onions";
        this.cost = 13.99;
    }

    public RegularBurger(){
        this.description = "Grass fed patty with cheese, " +
                "lettuce, tomato, and onions";
        this.cost = 13.99;
        this.ingredients = new ArrayList<>(List.of(Inventory.getBun(),
                Inventory.getPatty(), Inventory.getCheese(),
                Inventory.getLettuce(), Inventory.getOnion(),
                Inventory.getCheese(), Inventory.getLettuce(),
                Inventory.getOnion(), Inventory.getTomato()));
    }
}
