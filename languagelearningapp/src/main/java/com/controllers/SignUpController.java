package com.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import com.languageapp.App;

public class SignUpController {

    @FXML
    private void signUpClicked() throws IOException {
        App.setRoot("StartScreen");
    }
}
