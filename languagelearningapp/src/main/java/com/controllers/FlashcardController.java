package com.controllers;

import java.io.IOException;

import com.languageapp.App;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class FlashcardController {

    @FXML
    private Label spanishWord;

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
        // add if statements
        App.setRoot("Flashcard");
    }

    @FXML
    private void switchToNextQuestion() throws IOException {
        // add if statements
        App.setRoot("Flashcard");
    }
}
