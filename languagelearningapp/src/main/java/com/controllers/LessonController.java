package com.controllers;

import java.io.IOException;

import javafx.fxml.FXML;

import com.languageapp.App;

/**
 * @author Matthew Botteon
 */
public class LessonController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("StartScreen");
    }

    @FXML
    private void switchToEasy() throws IOException {
        App.setRoot("EasyLessons");
    }

    @FXML
    private void switchToProfile() throws IOException {
        App.setRoot("Profile");
    }

    @FXML
    private void switchToSection() throws IOException {
        App.setRoot("Section");
    }

    @FXML
    private void switchToFlashcard() throws IOException {
        App.setRoot("Flashcard");
    }

    @FXML
    private void switchToLesson() throws IOException {
        App.setRoot("Lesson");
    }

}
