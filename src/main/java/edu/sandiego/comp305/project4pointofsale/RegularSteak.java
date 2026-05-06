package edu.sandiego.comp305.project4pointofsale;
import java.util.List;


public class RegularSteak extends MenuItem {
    public RegularSteak(List<Ingredient> ingredients){
        super(ingredients);
        this.description = "Chargrilled Rosemary Steak\n" +
                "A tender, flame-grilled steak " +
                "seasoned with cracked pepper, " +
                "sea salt, and fresh rosemary. Served " +
                "with a savory garlic butter glaze and " +
                "finished with a side of roasted vegetables " +
                "and creamy mashed potatoes.";
        this.cost = 35.99;
    }

    public RegularSteak(){}
}
