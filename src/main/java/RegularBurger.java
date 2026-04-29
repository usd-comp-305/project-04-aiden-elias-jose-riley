import java.util.List;

public class RegularBurger extends MenuItem {
    private final double cost = 12.99;

    public RegularBurger(List<Ingredient> ingredients){
        super(ingredients);
    }


    @Override
    public String getDescription() {
        return "Grass fed patty with cheese, lettuce, tomato, and onions";
    }

    @Override
    public double getCost() {
        return cost;
    }
}
