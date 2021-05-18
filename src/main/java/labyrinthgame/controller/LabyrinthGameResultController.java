package labyrinthgame.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import labyrinthgame.result.Result;

import java.io.IOException;

public class LabyrinthGameResultController {

    private String username, time;
    private int steps;

    @FXML
    private Button mainMenuResultButton;

    @FXML
    private Label userResultLabel, timeResultLabel, stepsResultLabel;

    @FXML
    private void initialize() {
        Platform.runLater(() -> {
            userResultLabel.setText(username);
            timeResultLabel.setText(time);
            stepsResultLabel.setText(String.valueOf(steps));
        });
    }

    public void setData(Result r) {
        this.username = r.getUsername();
        this.time = r.getTime_s();
        this.steps = r.getSteps();
    }

    @FXML
    private void mainMenuButtonClick() throws IOException {

        //TODO: save result

        Parent mainParent = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        Stage mainStage = (Stage) mainMenuResultButton.getScene().getWindow();
        Scene mainScene = new Scene(mainParent);
        mainStage.setScene(mainScene);
    }

}
