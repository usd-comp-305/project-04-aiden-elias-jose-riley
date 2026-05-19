package edu.sandiego.comp305.project4pointofsale;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    private void handleSendToKitchen() throws IOException {
        // grab all cart items
        final ObservableList<MenuItem> cartItems =
                cartList.getItems();

        if (cartItems.isEmpty()) {
            // show alert & reset state
            final Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Empty Cart");
            alert.setHeaderText(null);
            alert.setContentText("Please add " +
                    "at least one item before sending to the kitchen.");
            alert.showAndWait();
            return;
        }

        // build order for Server to take
        final Order order =
                ChefController.POS_SYSTEM.createOrder(currentServer);
        for (MenuItem item : cartItems) {
            order.addItem(item);
        }

        ChefController.POS_SYSTEM.placeOrder(order);

        // clear cart to start fresh for next
        cartList.getItems().clear();
        totalLabel.setText("Total: $0.00");

        // navigate to the chef screen so ticket is immediately visible
        final Stage stage = (Stage) cartList.getScene().getWindow();
        SceneManager.switchScene(stage,
                "chef-view.fxml", "POS — Chef Dashboard");
    }

    @FXML
    private void handlePay() {
        // show confirmation & clear cart
        if (cartList.getItems().isEmpty()) {
            final Alert alert =
                    new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Empty Cart");
            alert.setHeaderText(null);
            alert.setContentText("There is nothing to pay for.");
            alert.showAndWait();
            return;
        }

        final Alert confirm =
                new Alert(Alert.AlertType.INFORMATION);
        confirm.setTitle("Payment");
        confirm.setHeaderText(null);
        confirm.setContentText("Payment processed. Thank you!");
        confirm.showAndWait();

        cartList.getItems().clear();
        totalLabel.setText("Total: $0.00");
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
