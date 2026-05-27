package edu.sandiego.comp305.project4pointofsale;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class PaymentController {

    private static final String CASH = "Cash";

    private static final String CREDIT_CARD = "Credit Card";

    private static final String MOBILE = "Mobile";

    @FXML
    private BorderPane root;

    @FXML
    private Label totalLabel;

    @FXML
    private ComboBox<String> methodCombo;

    @FXML
    private VBox cashPanel;

    @FXML
    private VBox creditPanel;

    @FXML
    private VBox mobilePanel;

    @FXML
    private TextField cashReceivedField;

    @FXML
    private TextField cardNumberField;

    @FXML
    private TextField cardHolderField;

    @FXML
    private TextField providerField;

    @FXML
    private Label resultLabel;

    private Order order;

    @FXML
    private void initialize() {
        methodCombo.getItems().addAll(CASH, CREDIT_CARD, MOBILE);
        methodCombo.setValue(CASH);
    }

    public void setOrder(final Order order){
        this.order = new Order(order);
        final double total = Math.round(
                order.calculateTotal() * 100.0) / 100.0;
        totalLabel.setText("Total: $" + total);
    }

    @FXML
    private void handleBack() throws IOException{
        final Stage stage = (Stage) root.getScene().getWindow();
        SceneManager.switchScene(stage, "server-view.fxml",
                "Server Dashboard");
    }

    @FXML
    private void handleMethodChange(){
        showPanelForMethod(methodCombo.getValue());
    }

    @FXML
    private void handleConfirm(){
        final PaymentMethod strategy = buildStrategy();
        if (strategy == null){
            return;
        }

        final double total = order.calculateTotal();
        final Payment payment = new Payment(
                order.getOrderId(), total, strategy);

        final boolean success = payment.processPayment();

        if (success) {
            String message = "Payment approved";
            if (strategy instanceof CashPayment){
                final CashPayment cash = (CashPayment) strategy;
                final double change = Math.round(
                        cash.calculateChange() * 100.0) / 100.0;
                message = message + ". Change: $" + change;
            }
            resultLabel.setText(message);
        } else {
            resultLabel.setText("Payment declined");
        }
    }

    private PaymentMethod buildStrategy(){
        final String method = methodCombo.getValue();

        if (CASH.equals(method)){
            return buildCashStrategy();
        }
        if (CREDIT_CARD.equals(method)){
            return new CreditCardPayment(
                    cardNumberField.getText(),
                    cardHolderField.getText());
        }
        if (MOBILE.equals(method)){
            return new MobilePayment(providerField.getText());
        }
        return null;
    }

    private PaymentMethod buildCashStrategy(){
        try{
            final double cashReceived = Double.parseDouble(
                    cashReceivedField.getText());
            return new CashPayment(cashReceived);
        }catch(NumberFormatException e){
            resultLabel.setText("Invalid cash amount");
            return null;
        }
    }

    private void showPanelForMethod(final String method){
        setPanelVisibility(cashPanel, CASH.equals(method));
        setPanelVisibility(creditPanel, CREDIT_CARD.equals(method));
        setPanelVisibility(mobilePanel, MOBILE.equals(method));
    }

    private void setPanelVisibility(final VBox panel, final boolean show){
        panel.setVisible(show);
        panel.setManaged(show);
    }
}
