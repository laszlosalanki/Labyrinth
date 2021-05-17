package labyrinthgame.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LabyrinthGameMainController {

    @FXML
    private Button newGameButton, historyButton, exitButton;

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private void newGameButtonClick() throws IOException {

        Parent newGameParent = FXMLLoader.load(getClass().getResource("/fxml/game.fxml"));
        Stage newGameStage = (Stage) newGameButton.getScene().getWindow();
        Scene newGameScene = new Scene(newGameParent);
        newGameStage.setScene(newGameScene);

    }

    @FXML
    private void historyButtonClick() throws IOException {

        Parent historyParent = FXMLLoader.load(getClass().getResource("/fxml/history.fxml"));
        Stage historyStage = (Stage) historyButton.getScene().getWindow();
        Scene historyScene = new Scene(historyParent);
        historyStage.setScene(historyScene);

    }

    @FXML
    private void exitButtonClick() {

        //TODO
        Stage mainStage = (Stage) exitButton.getScene().getWindow();
        mainStage.close();

    }

}
