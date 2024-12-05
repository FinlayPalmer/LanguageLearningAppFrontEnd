package com.controllers;

import java.io.IOException;

import com.languageapp.App;
import com.model.LanguageAppFacade;
import com.model.Matching;
import com.model.Question;

import javafx.collections.FXCollections;
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
    private ChoiceBox<?> answer2;
    @FXML
    private ChoiceBox<?> answer3;
    @FXML
    private ChoiceBox<?> answer4;
    @FXML
    private ChoiceBox<?> answer5;


    @FXML
    private void initialize() {
        matchingQuestion = (Matching)LanguageAppFacade.getInstance().getQuestion();
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

        String choices[] = new String[5];
        for (int i = 0; i < matchingQuestion.getOptions().size(); i++)
            choices[i] = text.concat(matchingQuestion.getOptions().get(i));

        // Set choices on the right side
        answer1 = new ChoiceBox<>(FXCollections.observableArrayList(choices));
        answer2 = new ChoiceBox<>(FXCollections.observableArrayList(choices));
        answer3 = new ChoiceBox<>(FXCollections.observableArrayList(choices));
        answer4 = new ChoiceBox<>(FXCollections.observableArrayList(choices));
        answer5 = new ChoiceBox<>(FXCollections.observableArrayList(choices));

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
        App.setRoot("Flashcard");
    }

    @FXML
    private void switchToNextQuestion() throws IOException {
        currentQuestion = LanguageAppFacade.getInstance().nextQuestion();
        if (currentQuestion.getQuestionType().equals("Flashcard"))
            App.setRoot("Flashcard");
        if (currentQuestion.getQuestionType().equals("Matching"))
            App.setRoot("Matching");
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
