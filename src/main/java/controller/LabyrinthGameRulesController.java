package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LabyrinthGameRulesController {

    @FXML
    private Button closeButton;

    @FXML
    private void closeButtonClick() {

        Stage mainStage = (Stage) closeButton.getScene().getWindow();
        mainStage.close();

    }

}
