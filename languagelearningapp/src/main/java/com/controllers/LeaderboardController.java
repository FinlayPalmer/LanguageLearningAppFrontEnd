package com.controllers;

import java.io.IOException;

import com.languageapp.App;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @author Matthew Botteon, Astha Singh
 */

public class LeaderboardController {

    @FXML private TableView<LeaderboardEntry> leaderboardTable;
    @FXML private TableColumn<LeaderboardEntry, Integer> rankColumn;
    @FXML private TableColumn<LeaderboardEntry, String> usernameColumn;
    @FXML private TableColumn<LeaderboardEntry, Integer> lessonsColumn;

    @FXML
    private void initialize() {
        rankColumn.setCellValueFactory(new PropertyValueFactory<>("rank"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        lessonsColumn.setCellValueFactory(new PropertyValueFactory<>("lessons"));

        leaderboardTable.setItems(getLeaderboardData());
    }

    private ObservableList<LeaderboardEntry> getLeaderboardData() {
        return FXCollections.observableArrayList(
            new LeaderboardEntry(1, "dog123", 52),
            new LeaderboardEntry(2, "cat789", 50),
            new LeaderboardEntry(3, "owl456", 48),
            new LeaderboardEntry(4, "usc1801", 46),
            new LeaderboardEntry(5, "sc999", 45),
            new LeaderboardEntry(6, "csce247", 41),
            new LeaderboardEntry(7, "mbott114", 40),
            new LeaderboardEntry(8, "fpalm556", 38),
            new LeaderboardEntry(9, "astha894", 37),
            new LeaderboardEntry(10, "sguzz963", 36)
        );
    }

    @FXML
    private void switchToProfile() throws IOException {
        App.setRoot("Profile");
    }

    @FXML
    private void switchToSection() throws IOException {
        App.setRoot("Section");
    }

    @FXML
    private void switchToLesson() throws IOException {
        App.setRoot("Lesson");
    }

    public static class LeaderboardEntry {
        private final Integer rank;
        private final String username;
        private final Integer lessons;

        public LeaderboardEntry(Integer rank, String username, Integer lessons) {
            this.rank = rank;
            this.username = username;
            this.lessons = lessons;
        }

        public Integer getRank() {
            return rank;
        }

        public String getUsername() {
            return username;
        }

        public Integer getLessons() {
            return lessons;
        }
    }
}
