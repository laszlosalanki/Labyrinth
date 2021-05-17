package labyrinthgame.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import labyrinthgame.Timer;

import java.io.IOException;

import static javafx.animation.Animation.Status.RUNNING;

public class LabyrinthGameController {

    private Timer timer;

    @FXML
    private Button exitGameButton, rulesButton;

    @FXML
    private Label timerLabel, playerLabel;

    @FXML
    private GridPane gameGridPane;

    private void drawmap() {

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                var square = new StackPane();

                if (i == 0 && j == 0)
                    square.getStyleClass().add("border-toprightleft");
                else if (i == 0 && j == 1)
                    square.getStyleClass().add("border-topleft");
                else if (i == 0 && j == 2)
                    square.getStyleClass().add("border-topbottom");
                else if (i == 0 && j == 3)
                    square.getStyleClass().add("border-topright");
                else if (i == 0 && j == 4)
                    square.getStyleClass().add("border-topleft");
                else if (i == 0 && j == 5)
                    square.getStyleClass().add("border-top");
                else if (i == 0 && j == 6)
                    square.getStyleClass().add("border-toprightbottom");
                else if (i == 1 && j == 0)
                    square.getStyleClass().add("border-left");
                else if (i == 1 && j == 2)
                    square.getStyleClass().add("border-top");
                else if (i == 1 && j == 4) {
                    var golyo = new Circle(25.0f);
                    golyo.setFill(Color.BLUE);
                    square.getChildren().add(golyo);
                    square.getStyleClass().add("border-all");
                }
                else if (i == 1 && j == 6)
                    square.getStyleClass().add("border-topright");
                else if (i == 2 && j == 0)
                    square.getStyleClass().add("border-left");
                else if (i == 2 && j == 1)
                    square.getStyleClass().add("border-bottom");
                else if (i == 2 && j == 2)
                    square.getStyleClass().add("border-right");
                else if (i == 2 && j == 3)
                    square.getStyleClass().add("border-left");
                else if (i == 2 && j == 5)
                    square.getStyleClass().add("border-right");
                else if (i == 2 && j == 6)
                    square.getStyleClass().add("border-rightleft");
                else if (i == 3 && j == 0)
                    square.getStyleClass().add("border-left");
                else if (i == 3 && j == 1)
                    square.getStyleClass().add("border-top");
                else if (i == 3 && j == 3)
                    square.getStyleClass().add("border-rightbottom");
                else if (i == 3 && j == 4)
                    square.getStyleClass().add("border-rightleft");
                else if (i == 3 && j == 5)
                    square.getStyleClass().add("border-left");
                else if (i == 3 && j == 6)
                    square.getStyleClass().add("border-rightbottom");
                else if (i == 4 && j == 0)
                    square.getStyleClass().add("border-bottomleft");
                else if (i == 4 && j == 3)
                    square.getStyleClass().add("border-top");
                else if (i == 4 && j == 4)
                    square.getStyleClass().add("border-bottom");
                else if (i == 4 && j == 6)
                    square.getStyleClass().add("border-topright");
                else if (i == 5 && j == 0)
                    square.getStyleClass().add("border-topleft");
                else if (i == 5 && j == 1)
                    square.getStyleClass().add("border-right");
                else if (i == 5 && j == 2) {
                    square.getChildren().add(new Label("CÉL"));
                    square.getStyleClass().add("border-rightbottomleft");
                }
                else if (i == 5 && j == 3)
                    square.getStyleClass().add("border-left");
                else if (i == 5 && j == 4)
                    square.getStyleClass().add("border-top");
                else if (i == 5 && j == 6)
                    square.getStyleClass().add("border-right");
                else if (i == 6 && j == 0)
                    square.getStyleClass().add("border-bottomleft");
                else if (i == 6 && j == 1)
                    square.getStyleClass().add("border-bottom");
                else if (i == 6 && j == 2)
                    square.getStyleClass().add("border-topbottom");
                else if (i == 6 && j == 3)
                    square.getStyleClass().add("border-rightbottom");
                else if (i == 6 && j == 4)
                    square.getStyleClass().add("border-bottomleft");
                else if (i == 6 && j == 5)
                    square.getStyleClass().add("border-rightbottom");
                else if (i == 6 && j == 6)
                    square.getStyleClass().add("border-rightbottomleft");
                else
                    square.getStyleClass().add("border-all");
                gameGridPane.add(square, j, i);
            }
        }
    }

    @FXML
    private void initialize() {

        drawmap();

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
