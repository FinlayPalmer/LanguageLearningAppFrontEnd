package com.controllers;

import java.io.IOException;

import com.languageapp.App;
import com.model.LanguageAppFacade;
import com.model.Question;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FlashcardController {

    private Question currentQuestion;
    @FXML
    private Label spanishWord;

    @FXML
    private void initialize() {
        currentQuestion = LanguageAppFacade.getInstance().getQuestion();
        spanishWord.setText(currentQuestion.getTitle());
    }

    @FXML
    private void switchToEasy() throws IOException {
        App.setRoot("EasyLessons");
    }

    @FXML
    private void switchToFlashcard() throws IOException {
        App.setRoot("Flashcard");
    }

    @FXML
    private void switchToPrevQuestion() throws IOException {
        currentQuestion = LanguageAppFacade.getInstance().previousQuestion();
        App.setRoot("Flashcard");
    }

    @FXML
    private void switchToNextQuestion() throws IOException {
        currentQuestion = LanguageAppFacade.getInstance().nextQuestion();
        if (currentQuestion.getQuestionType().equals("Flashcard"))
        App.setRoot("Flashcard");
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("StartScreen");
    }


    @FXML
    private void switchToColors() throws IOException {
        App.setRoot("ColorsLesson");
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
