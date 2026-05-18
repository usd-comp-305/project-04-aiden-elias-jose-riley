package edu.sandiego.comp305.project4pointofsale;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class SceneManager {
    public void sceneManager(){

    }

    public static void switchScene(final Stage stage,
                                   final String fxmlFile,
                                   final String title) throws IOException{

        URL fxmlLocation = HelloApplication.class.getResource(fxmlFile);

        if (fxmlLocation == null){
            throw new IOException("cant find: " + fxmlFile);
        }

        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        Scene scene = new Scene(loader.load(), 600, 400);

        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}
