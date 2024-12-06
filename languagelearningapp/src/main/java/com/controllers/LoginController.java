package com.controllers;

import java.io.IOException;

import com.languageapp.App;
import com.model.LanguageAppFacade;
import com.model.Account;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

/**
 * @author Finlay Palmer
 * Handles the navigation for the Login screen
 */
public class LoginController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label errorMessage;

    @FXML
    private void switchToStart() throws IOException {
        App.setRoot("StartScreen");
    }

    /**
     * Checks the username and password against the list of accounts and prints an error message if something is wrong
     * @throws IOException
     */
    @FXML
    private void switchToSection() throws IOException {
        LanguageAppFacade languageAppFacade = LanguageAppFacade.getInstance();
        String username = usernameField.getText();
        String password = passwordField.getText();
        System.out.println("Username: " + username + ", Password: " + password);
        Account account = languageAppFacade.login(username, password);
        if (account != null) {
            App.setRoot("Section");
        } else {
            errorMessage.setText("Your account was not able to be verified");
        }
    }
}
