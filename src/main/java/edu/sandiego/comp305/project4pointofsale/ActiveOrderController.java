package edu.sandiego.comp305.project4pointofsale;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import java.util.List;

import java.io.IOException;

public class ActiveOrderController {

    @FXML
    private BorderPane root;

    @FXML
    private ListView<MenuItem> menuList;

    @FXML
    private ListView<String> cartList;

    @FXML
    private Label totalLabel;

    /* TODO: replace with actual logged-in server, deferred to session
      management PR (will be implemented later) */
    private final Server currentServer = new Server(1, "Elias", "1234");

    private Order order;

    private final POSSystem posSystem = new POSSystem();

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
        final MenuItem selectedItem =
                menuList.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            return;
        }
        order.addItem(selectedItem);
        refreshCart();
    }

    @FXML
    private void handleRemoveItem(){
        final int selectedIndex = cartList.getSelectionModel()
                .getSelectedIndex();
        if (selectedIndex == -1) {
            return;
        }
        try {
            order.removeItem(order.getItems().get(selectedIndex));
            refreshCart();
        } catch (IllegalArgumentException e) {

        }
    }

    @FXML
    private void handleSendToKitchen(){
        if (order.getSentItemCount() == order.getItems().size()) {
            return;
        }

        final Order ticketOrder = createOrderForUnsentItems();
        posSystem.placeOrder(ticketOrder);
        order.markItemsAsSent();
        refreshCart();
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

    private void refreshCart(){
        cartList.getItems().clear();
        final List<MenuItem> items = order.getItems();
        for(int i = 0; i < items.size(); i++){
            String displayText = items.get(i).toString();
            if(i < order.getSentItemCount()){
                displayText = displayText + " (sent)";
            }
            cartList.getItems().add(displayText);
        }
        final double total = Math.round(order.calculateTotal() * 100.0) / 100.0;
        totalLabel.setText("Total: $" + total);
    }

    private Order createOrderForUnsentItems() {
        final Order ticketOrder = new Order(order.getOrderId(), currentServer);
        for (int i = order.getSentItemCount();
             i < order.getItems().size(); i++) {
            ticketOrder.addItem(order.getItems().get(i));
        }
        return ticketOrder;
    }
}
