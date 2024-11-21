package com.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import com.languageapp.App;

public class LoginController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("StartScreen");
    }

    @FXML
    private void switchToSection() throws IOException {
        App.setRoot("Section");
    }
}