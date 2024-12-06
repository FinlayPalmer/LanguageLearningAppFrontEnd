package com.controllers;

import java.io.IOException;

import com.languageapp.App;
import com.model.LanguageAppFacade;
import com.model.Question;
import com.model.UserTextEntry;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class UserTextEntryController {

    private UserTextEntry entryQuestion;
    private Question currentQuestion;
    @FXML
    private Label spanishPhrase;
    @FXML
    private TextField answer;
    @FXML
    private ImageView check;
    @FXML
    private ImageView wrong;

    @FXML
    private void initialize() {
        entryQuestion = (UserTextEntry)LanguageAppFacade.getInstance().getQuestion();
        currentQuestion = LanguageAppFacade.getInstance().getQuestion();
        spanishPhrase.setText(entryQuestion.getQuestionText());
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
        if (LanguageAppFacade.getInstance().getLesson().getCurrentQuestion().getQuestionType().equals("Fill In The Blank"))
            App.setRoot("FillInTheBlank");
        if (LanguageAppFacade.getInstance().getLesson().getCurrentQuestion().getQuestionType().equals("User Text Entry"))
            App.setRoot("UserTextEntry");
    }

    @FXML
    private void switchToNextQuestion() throws IOException {
        currentQuestion = LanguageAppFacade.getInstance().nextQuestion();
        if (LanguageAppFacade.getInstance().getLesson().getCurrentQuestion().getQuestionType().equals("Flashcard"))
            App.setRoot("Flashcard");
        if (LanguageAppFacade.getInstance().getLesson().getCurrentQuestion().getQuestionType().equals("Matching"))
            App.setRoot("Matching");
        if (LanguageAppFacade.getInstance().getLesson().getCurrentQuestion().getQuestionType().equals("Fill In The Blank"))
            App.setRoot("FillInTheBlank");
        if (LanguageAppFacade.getInstance().getLesson().getCurrentQuestion().getQuestionType().equals("User Text Entry"))
            App.setRoot("UserTextEntry");
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
