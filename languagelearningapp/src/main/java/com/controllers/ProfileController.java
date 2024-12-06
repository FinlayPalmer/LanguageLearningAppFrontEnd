package com.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import com.languageapp.App;
import com.model.Account;
import com.model.LanguageAppFacade;

/**
 * @author Matthew Botteon
 * Handles the navigation on the profile screen
 */
public class ProfileController {

    // Setting up labels for profile data
    @FXML
    private Label name;
    @FXML
    private Label email;
    @FXML
    private Label username;
    @FXML
    private Label dob;
    private Account account;

    /**
     * Gets the user's profile data and passes it into the labels
     */
    @FXML
    private void initialize() {
        account = LanguageAppFacade.getInstance().getAccount();
        name.setText("Name: " + account.getFirstName() + " " + account.getLastName());
        email.setText("Email: " + account.getEmail());
        username.setText("Username: " + account.getUsername());
        dob.setText("Date of Birth: " + account.getDateOfBirth());
    }
    
    @FXML
    private void switchToSection() throws IOException {
        App.setRoot("Section");
    }

    @FXML
    private void switchToStart() throws IOException {
        App.setRoot("StartScreen");
    }

    @FXML
    private void switchToResetPassword() throws IOException {
        App.setRoot("ResetPassword");
    }

    @FXML
    private void switchToProfile() throws IOException {
        App.setRoot("Profile");
    }

    @FXML
    private void switchToLesson() throws IOException {
        App.setRoot("Lesson");
    }
}
