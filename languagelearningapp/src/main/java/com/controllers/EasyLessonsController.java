package com.controllers;

import java.io.IOException;

import com.languageapp.App;

import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

/**
 * @author Matthew Botteon, Astha Singh
 */
public class EasyLessonsController {
    
    @FXML
    private void switchToSection() throws IOException {
        App.setRoot("Section");
    }
    @FXML
    private Circle lesson1Circle;

    @FXML
    private Circle lesson2Circle;

    @FXML
    private Circle lesson3Circle;

    @FXML
    private void goToCompletedLessons() throws IOException {
        App.setRoot("CompletedLessons");
    }

    @FXML
    private void goToProfile() throws IOException {
        App.setRoot("Profile");
    }

    @FXML
    private void goToHome() throws IOException {
        
    }

}
