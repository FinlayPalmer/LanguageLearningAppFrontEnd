package com.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import com.languageapp.App;
import com.model.LessonList;

/**
 * @author Matthew Botteon
 */
public class EasyLessonsController {

    private LessonList list;

    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button four;
    @FXML
    private Button five;

    @FXML
    private void initialize() {
        list = LessonList.getInstance();
        one.setText(list.getListOfAllLessons().get(0).getTitle());
        two.setText(list.getListOfAllLessons().get(1).getTitle());
        three.setText(list.getListOfAllLessons().get(2).getTitle());
        four.setText(list.getListOfAllLessons().get(3).getTitle());
        five.setText(list.getListOfAllLessons().get(4).getTitle());
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
    private void switchToColors() throws IOException {
        App.setRoot("ColorsLesson");
    }

    @FXML
    private void switchToFamily() throws IOException {
        App.setRoot("FamilyLesson");
    }

    @FXML
    private void switchToGreetings() throws IOException {
        App.setRoot("GreetingsLesson");
    }

    @FXML
    private void switchToLocked() throws IOException {
        App.setRoot("LockedLesson");
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

    // This should point to the current lesson not always colors!!! - matt
    @FXML
    private void switchToCurrentLesson() throws IOException {
        App.setRoot("ColorsLesson");
    }

}
