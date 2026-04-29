import java.util.List;

public abstract class MenuItem {
    String description;
    List<Ingredient> ingredients;
    double cost;

    public MenuItem(List<Ingredient> ingredients){
        this.ingredients = ingredients;
    }

    String getDescription(){
        return description;
    }
    double getCost(){
        return cost;
    }
}
