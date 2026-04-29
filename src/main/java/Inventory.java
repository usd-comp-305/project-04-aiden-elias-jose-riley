import java.util.List;

public class Inventory {
    private List<Ingredient> ingredients;
    private List<Ingredient> restock;

    public Inventory(List<Ingredient> startingIngredients, List<Ingredient> restockIngredients) {
        this.ingredients = startingIngredients;
        this.restock = restockIngredients;
    }

    public void checkStock(){}

    public void updateStock(){

    }
}
