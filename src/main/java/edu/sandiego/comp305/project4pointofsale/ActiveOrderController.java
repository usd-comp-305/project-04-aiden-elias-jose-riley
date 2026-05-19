package edu.sandiego.comp305.project4pointofsale;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.ListView;

import java.io.IOException;

public class ActiveOrderController {

    @FXML
    private BorderPane root;

    @FXML
    private ListView<MenuItem> menuList;

    @FXML
    private ListView<MenuItem> cartList;

    @FXML
    private Label totalLabel;

    /* TODO: replace with actual logged-in server, deferred to session
      management PR (will be implemented later) */
    private final Server currentServer = new Server(1, "Elias", "1234");

    private Order order;

    @FXML
    private void handleBack() throws IOException{
        final Stage stage = (Stage) root.getScene().getWindow();
        SceneManager.switchScene(stage, "server-view.fxml",
                "Server Dashboard");
    }

    @FXML
    private void initialize() {
        order = new Order(1, currentServer);
        populateMenuList();
    }

    @FXML
    private void handleAddItem(){
    }

    @FXML
    private void handleRemoveItem(){
    }

    @FXML
    private void handleSendToKitchen(){
    }

    @FXML
    private void handlePay(){
    }

    private void populateMenuList(){
        addMealsFromFactory(new RegularMealFactory());
        addMealsFromFactory(new VeganMealFactory());
        addMealsFromFactory(new GlutenFreeMealFactory());
    }

    private void addMealsFromFactory(final MealFactory factory){
        menuList.getItems().add(factory.createBurger());
        menuList.getItems().add(factory.createSteak());
        menuList.getItems().add(factory.createPasta());
    }
}
