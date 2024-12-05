package com.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import com.languageapp.App;

/**
 * @author Matthew Botteon
 */
public class EasyLessonsController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("StartScreen");
    }

    @FXML
    private void switchToEasy() throws IOException {
        App.setRoot("EasyLessons");
    }

    @FXML
    private void switchToColors() throws IOException {
        App.setRoot("ColorsLesson");
    }

    @FXML
    private void switchToFamily() throws IOException {
        App.setRoot("FamilyLesson");
    }

    @FXML
    private void switchToGreetings() throws IOException {
        App.setRoot("GreetingsLesson");
    }

    @FXML
    private void switchToLocked() throws IOException {
        App.setRoot("LockedLesson");
    }

    @FXML
    private void switchToProfile() throws IOException {
        App.setRoot("Profile");
    }

    @FXML
    private void switchToSection() throws IOException {
        App.setRoot("Section");
    }

    // This should point to the current lesson not always colors!!! - matt
    @FXML
    private void switchToCurrentLesson() throws IOException {
        App.setRoot("ColorsLesson");
    }

}
