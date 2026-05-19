package edu.sandiego.comp305.project4pointofsale;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.ListView;

import java.io.IOException;

public class ServerController {

    @FXML
    private ListView ordersList;

    @FXML
    private void handleLogout() throws IOException {
        final Stage stage = (Stage) ordersList.getScene().getWindow();
        SceneManager.switchScene(stage, "login-view.fxml",
                "Restaurant POS Login");
    }
}
