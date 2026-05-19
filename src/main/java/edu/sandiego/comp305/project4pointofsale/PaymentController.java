package edu.sandiego.comp305.project4pointofsale;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class PaymentController {

    @FXML
    private VBox root;

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
    private void initialize(){
    }

    public void setOrder(final Order order){
        this.order = order;
    }

    @FXML
    private void handleBack() throws IOException{
        final Stage stage = (Stage) root.getScene().getWindow();
        SceneManager.switchScene(stage, "server-view.fxml",
                "Server Dashboard");
    }

    @FXML
    private void handleConfirm(){
    }
}
