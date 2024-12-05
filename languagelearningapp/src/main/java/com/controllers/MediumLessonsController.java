package com.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import com.languageapp.App;
import com.model.LessonList;

/**
 * @author Matthew Botteon
 */
public class MediumLessonsController {

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
        one.setText(list.getListOfAllLessons().get(5).getTitle());
        two.setText(list.getListOfAllLessons().get(6).getTitle());
        three.setText(list.getListOfAllLessons().get(7).getTitle());
        four.setText(list.getListOfAllLessons().get(8).getTitle());
        five.setText(list.getListOfAllLessons().get(9).getTitle());
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
    private void switchToLesson() throws IOException {
        App.setRoot("Lesson");
    }

    @FXML
    private void switchToProfile() throws IOException {
        App.setRoot("Profile");
    }

    @FXML
    private void switchToSection() throws IOException {
        App.setRoot("Section");
    }
}
