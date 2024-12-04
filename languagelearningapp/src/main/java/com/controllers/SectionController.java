package com.controllers;

import java.io.IOException;

import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import com.languageapp.App;

/**
 * @author Matthew Botteon
 */
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

    @FXML
    private void switchToDifficult() throws IOException {
        App.setRoot("DifficultLessons");
    }

    @FXML
    private void switchToProfile() throws IOException {
        App.setRoot("Profile");
    }

    @FXML
    private void switchToLeaderboard() throws IOException {
        App.setRoot("Leaderboard");
    }

    // This should point to the current lesson not always colors!!! - matt
    @FXML
    private void switchToCurrentLesson() throws IOException {
        App.setRoot("ColorsLesson");
    }

}
