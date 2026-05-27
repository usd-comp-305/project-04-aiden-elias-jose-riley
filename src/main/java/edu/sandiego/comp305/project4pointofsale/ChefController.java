package edu.sandiego.comp305.project4pointofsale;

import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChefController {
    public static final POSSystem
            POS_SYSTEM = new POSSystem();

    // hard coded until login is set up
    private final Chef currentChef =
            new Chef(3, "Riley", "2345");

    // java fx bindings
    @FXML private ListView<KitchenTicket>
            ticketListView;

    @FXML private ListView<String>
            orderItemsListView;

    @FXML private ListView<String>
            ingredientsListView;

    @FXML private Label orderInfoLabel;

    @FXML private Label statusLabel;

    @FXML private Label ingredientsTitleLabel;

    @FXML private Button startTicketButton;

    @FXML private Button markReadyButton;

    @FXML private Button markDeliveredButton;

    // backing lists
    private final ObservableList<KitchenTicket> observableTickets =
            FXCollections.observableArrayList();

    private final ObservableList<String> observableItems =
            FXCollections.observableArrayList();

    private final ObservableList<String> observableIngredients =
            FXCollections.observableArrayList();

    // auto-refresh timer
    private Timeline refreshTimeline;

    // initialization
    @FXML
    public void initialize() {
        // match list views to observable lists
        ticketListView.setItems(observableTickets);
        orderItemsListView.setItems(observableItems);
        ingredientsListView.setItems(observableIngredients);

        // create executable for fx to run when needing to update item
        ticketListView.setCellFactory(listView -> new ListCell<>() {
            // overriding Cell's updateItem
            @Override
            protected void updateItem(final KitchenTicket ticket,
                                      final boolean empty) {
                super.updateItem(ticket, empty);
                if (empty || ticket == null) {
                    setText(null);
                    setStyle("");
                } else {
                    setText("Ticket #" + ticket.getTicketId()
                            + "  ·  " + ticket.getStatus());
                    // color code for status to mimic real life kitchen display
                    switch (ticket.getStatus()) {
                        case ORDERED     -> setStyle(
                                "-fx-text-fill: #e67e22; " +
                                        "-fx-font-weight: bold;");
                        case IN_PROCESS  -> setStyle(
                                "-fx-text-fill: #2980b9; " +
                                        "-fx-font-weight: bold;");
                        case COMPLETED   -> setStyle(
                                "-fx-text-fill: #27ae60;" +
                                        " -fx-font-weight: bold;");
                        case DELIVERED   -> setStyle(
                                "-fx-text-fill: #7f8c8d;");
                        default          -> setStyle("");
                    }
                }
            }
        });

        // clicking order item shows its ingredients
        orderItemsListView.setCellFactory(listView -> new ListCell<>() {
            @Override
            protected void updateItem(final String item, final boolean empty) {
                super.updateItem(item, empty);
                if(empty) {
                    setText(null);
                } else {
                    setText(item);
                }
            }
        });

        // populates detail panel when ticket is selected
        ticketListView.getSelectionModel().selectedItemProperty()
                .addListener((obs,
                              oldVal, newVal) -> showTicketDetails(newVal));

        // show ingredients
        orderItemsListView.getSelectionModel().selectedIndexProperty()
                .addListener((obs, oldIdx, newIdx) -> {
                    final KitchenTicket selected =
                            ticketListView.getSelectionModel()
                            .getSelectedItem();
                    if (selected == null
                            || newIdx.intValue() < 0) {
                        return;
                    }

                    final List<MenuItem> items =
                            selected.getTicketOrder().getItems();
                    final int idx = newIdx.intValue();
                    if (idx < items.size()) {
                        showIngredients(items.get(idx));
                    }
                });

        // waits for ticket to be selected to let action buttons work
        startTicketButton.setDisable(true);
        markReadyButton.setDisable(true);
        markDeliveredButton.setDisable(true);

        refreshTickets();

        // auto refresh every 5 seconds so
        // new tickets appear without manual refresh
        refreshTimeline = new Timeline(
                new KeyFrame(Duration.seconds(5), e -> refreshTickets())
        );
        refreshTimeline.setCycleCount(Timeline.INDEFINITE);
        refreshTimeline.play();
    }

    private void refreshTickets() {
        final KitchenTicket previousSelection =
                ticketListView.getSelectionModel().getSelectedItem();

        final List<KitchenTicket> latest = POS_SYSTEM.getPlacedKitchenTickets();
        observableTickets.setAll(latest);

        // restore selection if the ticket still exists
        if (previousSelection != null) {
            for (KitchenTicket t : observableTickets) {
                if (t.getTicketId() == previousSelection.getTicketId()) {
                    ticketListView.getSelectionModel().select(t);
                    break;
                }
            }
        }
    }

    private void showTicketDetails(final KitchenTicket ticket) {
        observableItems.clear();
        observableIngredients.clear();

        if (ticket == null) {
            orderInfoLabel.setText("Select a ticket to view details.");
            statusLabel.setText("");
            ingredientsTitleLabel.setText("Ingredients");
            startTicketButton.setDisable(true);
            markReadyButton.setDisable(true);
            markDeliveredButton.setDisable(true);
            return;
        }

        final Order order = ticket.getTicketOrder();
        orderInfoLabel.setText("Order #" + order.getOrderId()
                + "  |  Server: " + order.getServerName()
                + "  |  Total: $" +
                String.format("%.2f", order.calculateTotal()));
        statusLabel.setText("Status: " + ticket.getStatus());

        // TODO: change to jose's overridden toString
        for (MenuItem item : order.getItems()) {
            observableItems.add(item.getDescription()
                    + "  —  $" + String.format("%.2f", item.getCost()));
        }

        ingredientsTitleLabel.setText(
                "Ingredients  (select a menu item above)");

        setButtonStates(ticket);
    }

    private void showIngredients(final MenuItem menuItem) {
        observableIngredients.clear();
        ingredientsTitleLabel.setText(
                "Ingredients for: " + menuItem.getDescription());

        final List<Ingredient> ingredients = new ArrayList<Ingredient>();
        try {
            // uses assert statement to check ingredients list is not null
            final List<Ingredient> newIngredients = menuItem.getIngredients();
            // abide by checkstyle final modifier
            ingredients.addAll(newIngredients);
        } catch (AssertionError e) {
            observableIngredients.add("(no ingredients listed)");
            return;
        }

        if (ingredients == null || ingredients.isEmpty()) {
            observableIngredients.add("(no ingredients listed)");
            return;
        }

        for (Ingredient ing : ingredients) {
            observableIngredients.add("• " + ing.getName()
                    + "  —  $" + String.format("%.2f", ing.getPrice()));
        }
    }

    private void setButtonStates(final KitchenTicket ticket) {
        if (ticket == null) {
            startTicketButton.setDisable(true);
            markReadyButton.setDisable(true);
            markDeliveredButton.setDisable(true);
            return;
        }

        final Status s = ticket.getStatus();
        // only enable buttons when respective status is achieved
        startTicketButton.setDisable(s != Status.ORDERED);
        markReadyButton.setDisable(s != Status.IN_PROCESS);
        markDeliveredButton.setDisable(s != Status.COMPLETED);
    }

    // EVENT HANDLERS

    @FXML
    private void handleStartTicket() {
        final KitchenTicket ticket =
                ticketListView.getSelectionModel().getSelectedItem();
        if (ticket == null) {
            return;
        }

        currentChef.startTicket(ticket);
        refreshTickets();

        showTicketDetails(ticket);
    }

    @FXML
    private void handleMarkReady() {
        final KitchenTicket ticket =
                ticketListView.getSelectionModel().getSelectedItem();
        if (ticket == null) {
            return;
        }

        currentChef.markTicketReady(ticket);
        refreshTickets();
        showTicketDetails(ticket);
    }

    @FXML
    private void handleMarkDelivered() {
        final KitchenTicket ticket =
                ticketListView.getSelectionModel().getSelectedItem();
        if (ticket == null) {
            return;
        }

        currentChef.markTicketDelivered(ticket);
        refreshTickets();
        showTicketDetails(ticket);
    }

    @FXML
    private void handleRefresh() {
        refreshTickets();
    }

    //TODO: make this not go to the active order screen but the login screen
    @FXML
    private void handleBack() throws IOException {
        if (refreshTimeline != null) {
            refreshTimeline.stop();
        }
        final Stage stage = (Stage) ticketListView.getScene().getWindow();
        SceneManager.switchScene(
                stage, "active-order-view.fxml", "POS — Active Order");
    }
}
