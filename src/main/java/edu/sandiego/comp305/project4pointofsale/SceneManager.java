package edu.sandiego.comp305.project4pointofsale;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class SceneManager {
    public void sceneManager(){

    }

    public static <T> T switchScene(final Stage stage,
                                   final String fxmlFile,
                                   final String title) throws IOException{

        final URL fxmlLocation = HelloApplication.class.getResource(fxmlFile);

        if (fxmlLocation == null){
            throw new IOException("cant find: " + fxmlFile);
        }

        final FXMLLoader loader = new FXMLLoader(fxmlLocation);
        if (stage.getScene() == null){
            final Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(loader.load());
        }

        stage.setTitle(title);
        stage.show();

        return loader.getController();
    }
}
