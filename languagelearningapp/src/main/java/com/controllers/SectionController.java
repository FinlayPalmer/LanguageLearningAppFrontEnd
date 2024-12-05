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
    private void switchToProfile() throws IOException {
        App.setRoot("Profile");
    }

    @FXML
    private void switchToLeaderboard() throws IOException {
        App.setRoot("Leaderboard");
    }

    @FXML
    private void switchToSection() throws IOException {
        App.setRoot("Section");
    }

    @FXML
    private void switchToLesson() throws IOException {
        App.setRoot("Lesson");
    }

}
