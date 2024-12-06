package com.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import com.languageapp.App;
import com.model.LanguageAppFacade;

/**
 * @author Matthew Botteon
 */
public class LessonEndController {

    @FXML
    private Label endLesson;

    @FXML
    private void initialize() {
        endLesson.setWrapText(true);
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("StartScreen");
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
    private void switchToLesson() throws IOException {
        App.setRoot("Lesson");
    }

    @FXML
    private void switchToQuestion() throws IOException {
        if (LanguageAppFacade.getInstance().getLesson().getCurrentQuestion() == null)
            App.setRoot("LessonEnd");
        if (LanguageAppFacade.getInstance().getLesson().getCurrentQuestion().getQuestionType().equals("Flashcard"))
            App.setRoot("Flashcard");
        if (LanguageAppFacade.getInstance().getLesson().getCurrentQuestion().getQuestionType().equals("Matching"))
            App.setRoot("Matching");
        if (LanguageAppFacade.getInstance().getLesson().getCurrentQuestion().getQuestionType().equals("Fill In The Blank"))
            App.setRoot("FillInTheBlank");
        if (LanguageAppFacade.getInstance().getLesson().getCurrentQuestion().getQuestionType().equals("User Text Entry"))
            App.setRoot("UserTextEntry");
    }
}
