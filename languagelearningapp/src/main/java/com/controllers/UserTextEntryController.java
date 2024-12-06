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

/**
 * @author Matthew Botteon
 * Handles the navigation for the User Text Entry question type template screen
 */
public class UserTextEntryController {

    private UserTextEntry entryQuestion;
    private Question currentQuestion;
    // The phrase in Spanish the user needs to translate
    @FXML
    private Label spanishPhrase;
    // The user's typed in answer
    @FXML
    private TextField answer;
    @FXML
    private ImageView check;
    @FXML
    private ImageView wrong;

    /**
     * Creates the question text and places it inside a label
     */
    @FXML
    private void initialize() {
        entryQuestion = (UserTextEntry)LanguageAppFacade.getInstance().getQuestion();
        currentQuestion = LanguageAppFacade.getInstance().getQuestion();
        spanishPhrase.setText(entryQuestion.getQuestionText());
        spanishPhrase.setWrapText(true);
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

    /**
     * Moves to the previous question - the screen it changes to depends on the type of question
     * @throws IOException
     */
    @FXML
    private void switchToPrevQuestion() throws IOException {
        currentQuestion = LanguageAppFacade.getInstance().previousQuestion();
        if (currentQuestion == null)
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

    /**
     * Moves to the next question - the screen it changes to depends on the type of question
     * @throws IOException
     */
    @FXML
    private void switchToNextQuestion() throws IOException {
        currentQuestion = LanguageAppFacade.getInstance().nextQuestion();
        if (currentQuestion == null)
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

    /**
     * Sends the user's typed answer in to check, if they are right a check mark appears, else an X appears
     * @throws IOException
     */
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
