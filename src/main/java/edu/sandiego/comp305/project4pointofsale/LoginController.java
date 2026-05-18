package edu.sandiego.comp305.project4pointofsale;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private PasswordField pinField;

    @FXML
    private Label messageLabel;

    private final LoginService loginService =
            new LoginService(new StaffRepository());

    @FXML
    private void handleLogin() throws IOException {
        String pin = pinField.getText();

        Staff staff = loginService.login(pin);

        if (staff == null) {
            messageLabel.setText("Invalid PIN");
        } else if (staff.getRole() == StaffRole.SERVER) {
            Stage stage = (Stage) pinField.getScene().getWindow();
            SceneManager.switchScene(stage,
                    "server-view.fxml",
                    "Server Dashboard");
        } else if (staff.getRole() == StaffRole.CHEF) {
            messageLabel.setText("Welcome Chef: " + staff.getName());
            Stage stage = (Stage) pinField.getScene().getWindow();
            SceneManager.switchScene(stage,
                    "chef-view.fxml",
                    "Chef Dashboard");
        }
    }

}