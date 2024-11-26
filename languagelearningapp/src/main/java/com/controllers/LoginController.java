package com.controllers;

import java.io.IOException;

import com.languageapp.App;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

@FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;
    
    @FXML
    private void switchToStart() throws IOException {
        App.setRoot("StartScreen");
    }

    @FXML
    private void switchToSection() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        System.out.println("Username: " + username + ", Password: " + password);
        App.setRoot("Section");
    }
}
