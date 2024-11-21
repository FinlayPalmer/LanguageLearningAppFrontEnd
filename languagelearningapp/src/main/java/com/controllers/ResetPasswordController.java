package com.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import com.languageapp.App;

/**
 * @author Matthew Botteon
 */
public class ResetPasswordController {
    
    @FXML
    private void switchToProfile() throws IOException {
        App.setRoot("Profile");
    }
}
