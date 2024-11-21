package com.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import com.languageapp.App;

/**
 * @author Matthew Botteon
 */
public class ProfileController {
    
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
}
