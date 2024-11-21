package com.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import com.languageapp.App;

public class EasyLessonsController {
    
    @FXML
    private void switchToSection() throws IOException {
        App.setRoot("Section");
    }
}
