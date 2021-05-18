package controller;

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

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/game.fxml"));
        Parent newGameParent = fxmlLoader.load();
        Stage newGameStage = (Stage) newGameButton.getScene().getWindow();
        Scene newGameScene = new Scene(newGameParent);
        newGameStage.setScene(newGameScene);

    }

    @FXML
    private void historyButtonClick() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/history.fxml"));
        Parent historyParent = fxmlLoader.load();
        Stage historyStage = (Stage) historyButton.getScene().getWindow();
        Scene historyScene = new Scene(historyParent);
        historyStage.setScene(historyScene);

    }

    @FXML
    private void exitButtonClick() {

        Stage mainStage = (Stage) exitButton.getScene().getWindow();
        mainStage.close();

    }

}
