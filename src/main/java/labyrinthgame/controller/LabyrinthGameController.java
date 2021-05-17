package labyrinthgame.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import labyrinthgame.Timer;

import java.io.IOException;

import static javafx.animation.Animation.Status.RUNNING;

public class LabyrinthGameController {

    private Image back;
    private Timer timer;

    @FXML
    private Button exitGameButton, rulesButton;

    @FXML
    private Label timerLabel, playerLabel;

    @FXML
    private GridPane gameGridPane;

    private void drawGameState() {

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                ImageView view = (ImageView) gameGridPane.getChildren().get(i * 7 + j);
                view.setImage(back);
            }
        }

    }

    @FXML
    private void initialize() {

        back = new Image(getClass().getResource("/pictures/back.png").toExternalForm());

        drawGameState();

        timer = new Timer();
        timerLabel.textProperty().bind(timer.hhmmssProperty());
        timer.start();

        playerLabel.textProperty().set(System.getProperty("user.name"));

    }

    @FXML
    private void exitGameButtonClick() throws IOException {

        if (timer.getStatus() == RUNNING)
        {
            timer.stop();

            //TODO: save result
        }

        Parent mainParent = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        Stage mainStage = (Stage) exitGameButton.getScene().getWindow();
        Scene mainScene = new Scene(mainParent);
        mainStage.setScene(mainScene);

    }

    @FXML
    private void rulesButtonClick() throws IOException {

        Stage rulesStage = new Stage();
        Parent rulesParent = FXMLLoader.load(getClass().getResource("/fxml/rules.fxml"));
        Scene rulesScene = new Scene(rulesParent);
        rulesStage.setScene(rulesScene);
        rulesStage.show();

    }

}
