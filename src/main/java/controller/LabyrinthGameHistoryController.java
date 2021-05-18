package controller;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import result.Result;
import result.Results;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class LabyrinthGameHistoryController {

    private List<Result> resultList;

    @FXML
    private Button backButton;

    @FXML
    private Label bestTimeLabel;

    @FXML
    private GridPane historyGridPane;

    @FXML
    private void initialize() throws JAXBException {

        File historyFile = new File(LabyrinthGameResultController.class.getResource("/history.xml").getFile());
        JAXBContext jaxbContext = JAXBContext.newInstance(Results.class);

        Label name_header = new Label();
        Label time_header = new Label();
        Label steps_header = new Label();

        name_header.setText("Felhasználónév");

        time_header.setText("Idő");

        steps_header.setText("Lépések");

        historyGridPane.add(name_header, 0, 0);
        historyGridPane.add(time_header, 1, 0);
        historyGridPane.add(steps_header, 2, 0);

        if (historyFile.length() != 0) {
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Results results = (Results) unmarshaller.unmarshal(historyFile);
            resultList = results.getResults();

            Long best_time = resultList.get(0).getTime_s();
            for (var result : resultList) {
                if (best_time > result.getTime_s())
                    best_time = result.getTime_s();
            }

            bestTimeLabel.setText(best_time + "s");

            for (int i = 0; i < resultList.size(); i++){
                if (i > 5)
                    break;

                Label name = new Label();
                Label time = new Label();
                Label steps = new Label();
                name.setText(resultList.get(i).getUsername());
                time.setText(String.valueOf(resultList.get(i).getTime_s()));
                steps.setText(String.valueOf(resultList.get(i).getSteps()));

                historyGridPane.add(name, 0, i+1);
                historyGridPane.add(time, 1, i+1);
                historyGridPane.add(steps, 2, i+1);
            }

        } else {
            bestTimeLabel.setText("Még nincs egy előzmény sem az adatbázisban.");
        }

    }

    @FXML
    private void backButtonClick() throws IOException {

        Parent mainParent = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        Stage mainStage = (Stage) backButton.getScene().getWindow();
        Scene mainScene = new Scene(mainParent);
        mainStage.setScene(mainScene);

    }

}
