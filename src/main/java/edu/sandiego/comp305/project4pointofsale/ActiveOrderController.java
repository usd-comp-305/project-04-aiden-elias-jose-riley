package edu.sandiego.comp305.project4pointofsale;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ActiveOrderController {

    @FXML
    private BorderPane root;

    @FXML
    private void handleBack() throws IOException{
        final Stage stage = (Stage) root.getScene().getWindow();
        SceneManager.switchScene(stage, "server-view.fxml",
                "Server Dashboard");
    }
}
