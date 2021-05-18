package labyrinthgame.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class LabyrinthGameHistoryController {

    @FXML
    private Button backButton;

    @FXML
    private Label bestTimeLabel;

    @FXML
    private void initialize() {

        //TODO: load data and select the best

    }

    @FXML
    private void backButtonClick() throws IOException {

        Parent mainParent = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        Stage mainStage = (Stage) backButton.getScene().getWindow();
        Scene mainScene = new Scene(mainParent);
        mainStage.setScene(mainScene);

    }

}
