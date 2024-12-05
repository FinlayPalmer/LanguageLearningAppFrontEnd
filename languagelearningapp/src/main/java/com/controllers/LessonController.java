package com.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import com.languageapp.App;
import com.model.LanguageAppFacade;

/**
 * @author Matthew Botteon
 */
public class LessonController {

    @FXML
    private Label lessonName;

    @FXML
    private void initialize() {
        lessonName.setText(LanguageAppFacade.getInstance().getLesson().getTitle() + " Lesson");
    }

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

    @FXML
    private void switchToQuestion() throws IOException {
        if (LanguageAppFacade.getInstance().getLesson().getCurrentQuestion().getQuestionType().equals("Flashcard"))
            App.setRoot("Flashcard");
        if (LanguageAppFacade.getInstance().getLesson().getCurrentQuestion().getQuestionType().equals("Matching"))
            App.setRoot("Matching");
    }
}
