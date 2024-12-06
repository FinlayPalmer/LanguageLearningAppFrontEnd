package com.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import com.languageapp.App;

/**
 * @author Finlay Palmer
 * Handles the navigation for getting into the app
 */
public class StartScreenController {

    @FXML
    private void loginClicked() throws IOException {
        //Narrator.playSound("Hola Mundo");
        App.setRoot("Login");
    }

    @FXML
    private void signUpClicked() throws IOException {
        App.setRoot("SignUp");
    }
}
