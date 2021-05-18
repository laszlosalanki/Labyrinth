package labyrinthgame.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import labyrinthgame.GameClass;
import labyrinthgame.Timer;

import java.io.IOException;

import static javafx.animation.Animation.Status.RUNNING;

public class LabyrinthGameController {

    private Timer timer;
    private Circle golyo;

    @FXML
    private Button exitGameButton;

    @FXML
    private Label timerLabel, playerLabel;

    @FXML
    private GridPane gameGridPane;

    @FXML
    private Pane mainPane;

    private void drawMap() {

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
                    //var golyo = new Circle(25.0f);
                    //square.getChildren().add(golyo);
                    square.getStyleClass().add("border-all");
                    gameGridPane.add(golyo, j, i);
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

        golyo = new Circle(25.0f);
        golyo.setFill(Color.BLUE);
        mainPane.requestFocus();

        drawMap();

        timer = new Timer();
        timerLabel.textProperty().bind(timer.hhmmssProperty());
        timer.start();

        playerLabel.textProperty().set(System.getProperty("user.name"));

    }

    @FXML
    private void handleKeyEvent(KeyEvent event) {

        //TODO: log instead of println

        System.out.println("Pressed key code: " + event.getCode());

        int r_idx;
        int c_idx;

        switch (event.getCode()) {

            case W:
                r_idx = GridPane.getRowIndex(golyo);
                c_idx = GridPane.getColumnIndex(golyo);

                while (new GameClass(r_idx, c_idx, gameGridPane).canGoTo(r_idx-1, c_idx)) {

                    ObservableList<Node> childrens = gameGridPane.getChildren();
                    for (Node node : childrens) {
                        if (node instanceof Circle && GridPane.getRowIndex(node) == r_idx && GridPane.getColumnIndex(node) == c_idx) {
                            gameGridPane.getChildren().remove(node);
                            break;
                        }
                    }

                    gameGridPane.add(golyo, c_idx, r_idx-1);
                    System.out.println("Moved from (" + r_idx + ", " + c_idx + ") " + "to (" + (r_idx-1) + ", " + c_idx + ")");

                    r_idx -= 1;
                }
                break;
            case S:
                r_idx = GridPane.getRowIndex(golyo);
                c_idx = GridPane.getColumnIndex(golyo);

                while (new GameClass(r_idx, c_idx, gameGridPane).canGoTo(r_idx+1, c_idx)) {

                    ObservableList<Node> childrens = gameGridPane.getChildren();
                    for (Node node : childrens) {
                        if (node instanceof Circle && GridPane.getRowIndex(node) == r_idx && GridPane.getColumnIndex(node) == c_idx) {
                            gameGridPane.getChildren().remove(node);
                            break;
                        }
                    }

                    gameGridPane.add(golyo, c_idx, r_idx+1);

                    r_idx += 1;
                }
                break;
            case A:
                r_idx = GridPane.getRowIndex(golyo);
                c_idx = GridPane.getColumnIndex(golyo);

                while (new GameClass(r_idx, c_idx, gameGridPane).canGoTo(r_idx, c_idx-1)) {

                    ObservableList<Node> childrens = gameGridPane.getChildren();
                    for (Node node : childrens) {
                        if (node instanceof Circle && GridPane.getRowIndex(node) == r_idx && GridPane.getColumnIndex(node) == c_idx) {
                            gameGridPane.getChildren().remove(node);
                            break;
                        }
                    }

                    gameGridPane.add(golyo, c_idx-1, r_idx);

                    c_idx -= 1;
                }
                break;
            case D:
                r_idx = GridPane.getRowIndex(golyo);
                c_idx = GridPane.getColumnIndex(golyo);

                while (new GameClass(r_idx, c_idx, gameGridPane).canGoTo(r_idx, c_idx+1)) {

                    ObservableList<Node> childrens = gameGridPane.getChildren();
                    for (Node node : childrens) {
                        if (node instanceof Circle && GridPane.getRowIndex(node) == r_idx && GridPane.getColumnIndex(node) == c_idx) {
                            gameGridPane.getChildren().remove(node);
                            break;
                        }
                    }

                    gameGridPane.add(golyo, c_idx+1, r_idx);

                    c_idx += 1;
                }
                break;
            default:
                break;
        }

        r_idx = GridPane.getRowIndex(golyo);
        c_idx = GridPane.getColumnIndex(golyo);

        if (r_idx == 5 && c_idx == 2) {
            if (timer.getStatus() == RUNNING) {
                timer.stop();
            }
            //TODO: save result, log
            System.out.println("Task completed in " + timer.hhmmssProperty().get());
        }
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
