package com.controllers;

import java.io.IOException;
import com.languageapp.App;
import javafx.fxml.FXML;

public class MediumLessonsController {
    
    @FXML
    private void switchToSection() throws IOException {
        App.setRoot("Section");
    }
}
