package com.controllers;

import java.io.IOException;

import com.languageapp.App;
import com.model.LanguageAppFacade;
import com.model.FillInTheBlank;
import com.model.Question;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class FillInTheBlankController {

    private Question currentQuestion;
    private FillInTheBlank blankQuestion;
    @FXML
    private Label spanishWords;
    @FXML
    private TextField answer;
    @FXML
    private ImageView check;
    @FXML
    private ImageView wrong;


    @FXML
    private void initialize() {
        blankQuestion = (FillInTheBlank)LanguageAppFacade.getInstance().getQuestion();
        spanishWords.setText(blankQuestion.getQuestionText());

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
        if (LanguageAppFacade.getInstance().getLesson().getCurrentQuestion().getQuestionType().equals("Flashcard"))
            App.setRoot("Flashcard");
        if (LanguageAppFacade.getInstance().getLesson().getCurrentQuestion().getQuestionType().equals("Matching"))
            App.setRoot("Matching");
        if (LanguageAppFacade.getInstance().getLesson().getCurrentQuestion().getQuestionType().equals("FillInTheBlank"))
            App.setRoot("FillInTheBlank");
        //if (LanguageAppFacade.getInstance().getLesson().getCurrentQuestion().getQuestionType().equals("UserTextEntry"))
        //    App.setRoot("UserTextEntry");
    }

    @FXML
    private void switchToNextQuestion() throws IOException {
        currentQuestion = LanguageAppFacade.getInstance().nextQuestion();
        if (LanguageAppFacade.getInstance().getLesson().getCurrentQuestion().getQuestionType().equals("Flashcard"))
            App.setRoot("Flashcard");
        if (LanguageAppFacade.getInstance().getLesson().getCurrentQuestion().getQuestionType().equals("Matching"))
            App.setRoot("Matching");
        if (LanguageAppFacade.getInstance().getLesson().getCurrentQuestion().getQuestionType().equals("FillInTheBlank"))
            App.setRoot("FillInTheBlank");
        //if (LanguageAppFacade.getInstance().getLesson().getCurrentQuestion().getQuestionType().equals("UserTextEntry"))
        //    App.setRoot("UserTextEntry");
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
