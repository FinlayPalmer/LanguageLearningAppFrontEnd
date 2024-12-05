package com.controllers;

import java.io.IOException;

import com.languageapp.App;
import com.model.LanguageAppFacade;
import com.model.Question;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class FlashcardController {

    private Question currentQuestion;
    @FXML
    private Label spanishWord;
    @FXML
    private TextField answer;
    @FXML
    private ImageView check;
    @FXML
    private ImageView wrong;

    @FXML
    private void initialize() {
        currentQuestion = LanguageAppFacade.getInstance().getQuestion();
        spanishWord.setText(currentQuestion.getTitle());
        check.setVisible(false);
        wrong.setVisible(false);
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

    @FXML
    private void switchToLesson() throws IOException {
        App.setRoot("Lesson");
    }

    @FXML
    private void checkAnswer() throws IOException {
        if(LanguageAppFacade.getInstance().getQuestion().isAnswerCorrect(answer.getText())) {
            check.setVisible(true);
            wrong.setVisible(false);
        } else {
            wrong.setVisible(true);
            check.setVisible(false);
        } 
    }
}
