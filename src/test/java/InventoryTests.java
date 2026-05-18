import edu.sandiego.comp305.project4pointofsale.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class InventoryTests {
    private static List<Ingredient> sampleInventory;

    @BeforeAll
    public static void makeSampleInventory(){
        sampleInventory = new ArrayList<>();


    }

    @Test
    public void checkInventoryTest(){
        List<Ingredient> ingredientsContained = sampleInventory;
        List<Ingredient> restockIngredients = new ArrayList<>();

        Inventory inv = new Inventory(ingredientsContained, restockIngredients);


    }

    @Test
    public void restockInventoryTest(){
        List<Ingredient> ingredientsContained = sampleInventory;
        List<Ingredient> restockIngredients = sampleInventory;

        Inventory inv = new Inventory(ingredientsContained, restockIngredients);
    }

    @Test
    public void restockNothingTest(){
        List<Ingredient> ingredientsContained = sampleInventory;
        List<Ingredient> restockIngredients = new ArrayList<>();

        Inventory inv = new Inventory(ingredientsContained, restockIngredients);
    }

    @Test
    public void checkEmptyInventoryTest(){
        List<Ingredient> ingredientsContained = new ArrayList<>();
        List<Ingredient> restockIngredients = new ArrayList<>();

        Inventory inv = new Inventory(ingredientsContained, restockIngredients);
    }

    @Test
    public void initializeEmptyParamsTest(){
        List<Ingredient> ingredientsContained = new ArrayList<>();
        List<Ingredient> restockIngredients = new ArrayList<>();

        Assertions.assertDoesNotThrow(() -> {new Inventory(ingredientsContained, restockIngredients);});
    }
}
