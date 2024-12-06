package com.controllers;

import java.io.IOException;

import com.languageapp.App;
import com.model.LanguageAppFacade;
import com.model.Matching;
import com.model.Question;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class MatchingController {

    private Question currentQuestion;
    private Matching matchingQuestion;
    @FXML
    private Label spanishWords;
    @FXML
    private Label options;
    @FXML
    private TextField answer;
    @FXML
    private ImageView check;
    @FXML
    private ImageView wrong;

    // Terms to match to
    @FXML
    private Label choice1;
    @FXML
    private Label choice2;
    @FXML
    private Label choice3;
    @FXML
    private Label choice4;
    @FXML
    private Label choice5;

    // Answer dropdowns
     @FXML
    private ChoiceBox<String> answer1;
    @FXML
    private ChoiceBox<String> answer2;
    @FXML
    private ChoiceBox<String> answer3;
    @FXML
    private ChoiceBox<String> answer4;
    @FXML
    private ChoiceBox<String> answer5;


    @FXML
    private void initialize() {
        matchingQuestion = (Matching)LanguageAppFacade.getInstance().getQuestion();
        currentQuestion = LanguageAppFacade.getInstance().getQuestion();
        String text = " ";
        for (int i = 0; i < matchingQuestion.getSpanishWords().size(); i++)
            text = text.concat(matchingQuestion.getSpanishWords().get(i).getWordText() + " ");
        spanishWords.setText(text);

        // Set spanish words on the left side
        choice1.setText(matchingQuestion.getSpanishWords().get(0).getWordText());
        choice2.setText(matchingQuestion.getSpanishWords().get(1).getWordText());
        choice3.setText(matchingQuestion.getSpanishWords().get(2).getWordText());
        choice4.setText(matchingQuestion.getSpanishWords().get(3).getWordText());
        choice5.setText(matchingQuestion.getSpanishWords().get(4).getWordText());

        // Set choices on the right side
        for (int i = 0; i < matchingQuestion.getOptions().size(); i++) {
            answer1.getItems().add(matchingQuestion.getOptions().get(i));
            answer2.getItems().add(matchingQuestion.getOptions().get(i));
            answer3.getItems().add(matchingQuestion.getOptions().get(i));
            answer4.getItems().add(matchingQuestion.getOptions().get(i));
            answer5.getItems().add(matchingQuestion.getOptions().get(i));
        }
        
        text = " ";
        for (int i = 0; i < matchingQuestion.getOptions().size(); i++)
            text = text.concat(matchingQuestion.getOptions().get(i) + " ");
        options.setText(text);

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

    @FXML
    private void checkAnswer() throws IOException {
        String answer = "";
        answer = answer + answer1.getSelectionModel().getSelectedItem() + " ";
        answer = answer + answer2.getSelectionModel().getSelectedItem() + " ";
        answer = answer + answer3.getSelectionModel().getSelectedItem() + " ";
        answer = answer + answer4.getSelectionModel().getSelectedItem() + " ";
        answer = answer + answer5.getSelectionModel().getSelectedItem() + " ";

        if(LanguageAppFacade.getInstance().getQuestion().isAnswerCorrect(answer)) {
            check.setVisible(true);
            wrong.setVisible(false);
        } else {
            wrong.setVisible(true);
            check.setVisible(false);
        } 
    }
}
