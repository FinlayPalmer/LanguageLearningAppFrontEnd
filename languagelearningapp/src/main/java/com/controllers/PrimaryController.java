package com.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import com.languageapp.App;
import com.narration.*;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        Narrator.playSound("Hola");
        //App.setRoot("secondary");
    }
}
