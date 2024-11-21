package com.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import com.languageapp.App;

public class SectionController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("StartScreen");
    }

    @FXML
    private void switchToEasy() throws IOException {
        App.setRoot("EasyLessons");
    }

    @FXML
    private void switchToMedium() throws IOException {
        App.setRoot("MediumLessons");
    }
}
