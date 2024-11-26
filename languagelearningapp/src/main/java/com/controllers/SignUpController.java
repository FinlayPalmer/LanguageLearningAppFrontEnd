package com.controllers;

import java.io.IOException;

import com.languageapp.App;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

/**
 * @author Finlay Palmer, Astha Singh
 */

public class SignUpController {

    @FXML
    private PasswordField passwordField;

    @FXML
    private void switchToStart() throws IOException {
        App.setRoot("StartScreen");
    }

    @FXML
    private void switchToSection() throws IOException {
        App.setRoot("Section");
    }
    @FXML
    private void submitSignUp() {
        String password = passwordField.getText(); 
        System.out.println("Password: " + password);
    }
}

