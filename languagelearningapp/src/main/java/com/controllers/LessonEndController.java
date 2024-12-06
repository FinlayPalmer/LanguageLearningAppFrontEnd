package com.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import com.languageapp.App;
import com.model.LanguageAppFacade;

/**
 * @author Matthew Botteon
 * Handles the navigation for the screen that appears once the user completes a lesson
 */
public class LessonEndController {

    @FXML
    private Label endLesson;

    /**
     * Wraps the text of the message printed to the user
     */
    @FXML
    private void initialize() {
        LanguageAppFacade.getInstance().endLesson();
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

    /**
     * Goes to the last question of the lesson, depending on the type it will go to the appropriate template screen
     * @throws IOException
     */
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
