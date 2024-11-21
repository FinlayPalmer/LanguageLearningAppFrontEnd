package com.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import com.languageapp.App;

/**
 * @author Matthew Botteon
 */
public class LeaderboardController {
    
    @FXML
    private void switchToSection() throws IOException {
        App.setRoot("Section");
    }
}
