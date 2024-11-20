package com.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import com.languageapp.App;
import com.narration.*;

public class StartScreenController {

    @FXML
    private void loginClicked() throws IOException {
        Narrator.playSound("Hola Mundo");
        // App.setRoot("secondary");
    }

    @FXML
    private void signUpClicked() throws IOException {

    }
}
