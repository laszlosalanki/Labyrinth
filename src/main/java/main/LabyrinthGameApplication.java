package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Class to create the UI for the game.
 */
public class LabyrinthGameApplication extends Application {

    /**
     * This method overrides the default start method of 'Application', and creates a scene and a stage
     * based on a given fxml file.
     * @param stage
     * @throws IOException in case of missing fxml file.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        Parent root = fxmlLoader.load();
        stage.setTitle("JavaFX Labyrinth Game");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
