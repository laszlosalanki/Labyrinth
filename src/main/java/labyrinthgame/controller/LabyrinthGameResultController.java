package labyrinthgame.controller;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import labyrinthgame.result.Result;
import labyrinthgame.result.Results;

import java.io.*;
import java.util.List;

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

    public void setData(Result r) throws JAXBException {
        this.username = r.getUsername();
        this.time = r.getTime_s();
        this.steps = r.getSteps();

        File historyFile = new File(LabyrinthGameResultController.class.getResource("/history.xml").getFile());
        JAXBContext jaxbContext = JAXBContext.newInstance(Results.class);
        if (historyFile.length() != 0) {
            //READ
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Results results = (Results) unmarshaller.unmarshal(historyFile);
            List<Result> resultList = results.getResults();
            resultList.add(r);
            results.setResults(resultList);
            //WRITE
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.marshal(results, historyFile);
        } else {
            Results results = new Results();
            List<Result> resultList = List.of(r);
            System.out.println(resultList.get(0));
            results.setResults(resultList);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.marshal(results, historyFile);
        }
    }

    @FXML
    private void mainMenuButtonClick() throws IOException {

        Parent mainParent = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        Stage mainStage = (Stage) mainMenuResultButton.getScene().getWindow();
        Scene mainScene = new Scene(mainParent);
        mainStage.setScene(mainScene);
    }

}
