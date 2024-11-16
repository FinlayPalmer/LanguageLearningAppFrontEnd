package com.narration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import org.json.simple.parser.ParseException;

/**
 * @author Astha Singh, Sanjana Guzzarlamudi, Matthew Botteon, Finlay Palmer
 * 
 *         The Main class is the entry point of the Language Learning
 *         Application.
 *         It initializes the DataLoader, retrieves user accounts and lessons
 *         from the JSON file,
 *         and prints out the details of each account and lesson.
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button speakButton = new Button("Speak 'Hello World'");
        speakButton.setOnAction(event -> Narrator.playSound("Hola Mundo")); 

        StackPane root = new StackPane(speakButton);
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Language Learning App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}