package edu.sandiego.comp305.project4pointofsale;
import java.util.List;


public class RegularSteak extends MenuItem {
    private final double cost = 36.99;

    public RegularSteak(List<Ingredient> ingredients){
        super(ingredients);
    }

    @Override
    public String getDescription() {
        return "Chargrilled Rosemary Steak\n" +
                "A tender, flame-grilled steak " +
                "seasoned with cracked pepper, " +
                "sea salt, and fresh rosemary. Served " +
                "with a savory garlic butter glaze and " +
                "finished with a side of roasted vegetables " +
                "and creamy mashed potatoes.";
    }

    @Override
    public double getCost() {
        return cost;
    }
}
