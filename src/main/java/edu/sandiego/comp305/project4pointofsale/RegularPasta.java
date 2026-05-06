package edu.sandiego.comp305.project4pointofsale;
import java.util.List;

public class RegularPasta extends MenuItem {

    public RegularPasta(List<Ingredient> ingredients){
        super(ingredients);
        this.description = "Creamy Tuscan Garden Pasta\n" +
                "A hearty bowl of penne tossed " +
                "in a rich garlic parmesan cream sauce" +
                " with sun-dried tomatoes, spinach, roasted mushrooms," +
                " and fresh basil. Finished with cracked black pepper " +
                "and a sprinkle of parmesan cheese.";
        this.cost = 15.99;
    }
}
