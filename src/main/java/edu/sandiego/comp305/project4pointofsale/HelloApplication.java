package edu.sandiego.comp305.project4pointofsale;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(final Stage stage) throws IOException {
        final FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource("login-view.fxml"));

        final Scene scene = new Scene(fxmlLoader.load(), 400, 300);

        stage.setTitle("Restaurant POS Login!");
        stage.setScene(scene);
        stage.setWidth(800);
        stage.setHeight(550);
        stage.setMinWidth(700);
        stage.setMinHeight(500);
        stage.show();
    }
}
