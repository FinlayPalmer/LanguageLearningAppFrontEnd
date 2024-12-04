package com.controllers;

import java.io.IOException;

import com.languageapp.App;
import com.model.Account;
import com.model.AccountList;
import com.model.LanguageAppFacade;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

/**
 * @author Finlay Palmer, Astha Singh, Matthew Botteon
 */

public class SignUpController {

    // Initialize the id names for the fields in the sign-up form
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField dobField;
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
        App.setRoot("Section");
    }
    
    @FXML
    private void submitSignUp() throws IOException {
        // Sends the data from the form to the signUp method in Facade; if successful, the user is advanced to the next screen
        if (LanguageAppFacade.getInstance().signUp(firstNameField.getText(), lastNameField.getText(), 
                                                   emailField.getText(), dobField.getText(), usernameField.getText(),
                                                   passwordField.getText()).startsWith("Success"))
            App.setRoot("Section");
        // If unsuccessful, the user is sent to a sign up screen displaying an error message
        else App.setRoot("SignUpFailure");
    }
}
