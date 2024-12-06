package com.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import com.languageapp.App;
import com.model.LanguageAppFacade;

/**
 * @author Matthew Botteon
 * Handles the navigation for the generic Lesson screen
 */
public class LessonController {

    // The name of the lesson, comes from JSON file
    @FXML
    private Label lessonName;

    /**
     * Gets the title of the lesson and sets it to the label
     */
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

    /**
     * Goes to the first question of the lesson, depending on the type it will go to the appropriate template screen
     * @throws IOException
     */
    @FXML
    private void switchToQuestion() throws IOException {
        if(LanguageAppFacade.getInstance().getLesson().getCurrentQuestion() ==  null)
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
