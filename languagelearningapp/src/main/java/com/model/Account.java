package com.model;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Astha Singh, Matthew Botteon
 * Represents a user account with personal details and functionality for validation.
 */
public class Account {
    private String firstName;
    private String lastName;
    private String email;
    private String dateOfBirth;
    private String username;
    private String password;
    private int lessonsCompleted;
    private SkillLevel skillLevel;
    private Avatar avatar;
    private Dashboard dashboard;
    private UUID accountID;
    private String[] reviewWords;
    private String[] reviewPhrases;
    private String currentLesson;

    /**
     * Constructs an Account with the specified details.
     *
     * @param firstName   The first name of the account holder.
     * @param lastName    The last name of the account holder.
     * @param email       The email address of the account holder.
     * @param dateOfBirth The date of birth of the account holder.
     * @param username    The username for the account.
     * @param password    The password for the account.
     */
    public Account(String firstName, String lastName, String email, String dateOfBirth, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.username = username;
        this.password = password;
        this.lessonsCompleted = 0; // Initialize lessons completed to 0
        this.skillLevel = SkillLevel.EASY; // Default skill level until SkillLevelTest is taken
        this.avatar = new Avatar(); // Creates a new default avatar
        this.accountID = UUID.randomUUID();
        this.dashboard = new Dashboard(this);
    }

    /**
     * Constructs an Account with the specified details, including recommended skill level and avatar.
     *
     * @param firstName             The first name of the account holder.
     * @param lastName              The last name of the account holder.
     * @param email                 The email address of the account holder.
     * @param dateOfBirth           The date of birth of the account holder.
     * @param username              The username for the account.
     * @param password              The password for the account.
     * @param reviewWords The recommended skill level for the account.
     * @param reviewPhrases                The avatar associated with the account.
     * @param currentLesson             The unique identifier for the account.
     */
    public Account(String firstName, String lastName, String email, String dateOfBirth, String username, String password, String[] reviewWords, String[] reviewPhrases, String currentLesson) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.username = username;
        this.password = password;
        this.lessonsCompleted = 0; // Initialize lessons completed to 0
        this.reviewWords = reviewWords;
        this.reviewPhrases = reviewPhrases;
        this.currentLesson = currentLesson;

    }

    /**
     * Constructs an Account using a UUID, loading details from a JSON file.
     *
     * @param accountID The unique identifier for the account.
     */
    public Account(UUID accountID) {
        this.accountID = accountID;
        loadAccountFromJson(accountID);
    }
    

    /**
     * Loads account details from a JSON file based on the given UUID.
     * Populates the account fields using the JSON file.
     *
     * @param accountID The unique identifier for the account.
     */
    private void loadAccountFromJson(UUID accountID) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("src/main/resources/data/account_" + accountID + ".json")) {
            Account accountFromJson = gson.fromJson(reader, Account.class);
            this.firstName = accountFromJson.firstName;
            this.lastName = accountFromJson.lastName;
            this.email = accountFromJson.email;
            this.dateOfBirth = accountFromJson.dateOfBirth;
            this.username = accountFromJson.username;
            this.password = accountFromJson.password;
            this.skillLevel = accountFromJson.skillLevel;
            this.avatar = accountFromJson.avatar;
            this.dashboard = accountFromJson.dashboard;

        } catch (IOException | JsonSyntaxException e) {
            System.out.println("Error loading account from JSON: " + e.getMessage());
        }
    }

    /**
     * Checks if the provided username and password match this account's credentials.
     *
     * @param username The username to check.
     * @param password The password to check.
     * @return true if both the username and password match, false otherwise.
     */
    public boolean isMatch(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    /**
     * Validates the provided date of birth against this account's date of birth.
     *
     * @param dateOfBirth The date of birth to validate.
     * @return true if the provided date of birth matches the account's, false otherwise.
     */
    public boolean validateDateOfBirth(String dateOfBirth) {
        return this.dateOfBirth.equals(dateOfBirth);
    }

    /**
     * Sets the skill level for the account.
     *
     * @param skillLevel The recommended skill level to set.
     */
    public void setSkillLevel(SkillLevel skillLevel) {
        this.skillLevel = skillLevel;
    }

    /**
     * Gets the first name of the account
     * 
     * @return The first name of the account
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name of the account
     * 
     * @return The last name of the account
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the email of the account
     * 
     * @return The email of the account
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the date of birth of the account
     * 
     * @return The date of birth of the account
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Gets the username of the account
     * 
     * @return The username of the account
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the password of the account
     * 
     * @return The password of the account
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the number of lessons the user has completed on this account.
     *
     * @return The number of lessons the user has completed.
     */
    public int getLessonsCompleted() {
        return lessonsCompleted;
    }

    /**
     * Gets the skill level of the account
     * 
     * @return The skill level of the account
     */
    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    /**
     * Gets the avatar of the account
     * 
     * @return The avatar of the account
     */
    public Avatar getAvatar() {
        return avatar;
    }

    /**
     * Gets the unique identifier of the account
     * 
     * @return The unique identifier of the account
     */
    public UUID getAccountID() {
        return accountID;
    }

    /**
     * Gets the dashboard of the account
     * 
     * @return The dashboard of the account
     */
 
     public Dashboard getDashboard() {
        if (dashboard == null) {
            this.dashboard = new Dashboard(this);
        }
        return dashboard;
    }
    /**
     * Returns a string representation of the account details.
     *
     * @return A string containing the account's first name, last name, email, and username.
     */
    @Override
    public String toString() {
        return "\nYour Account:\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nEmail: " 
            + email + "\nDate of Birth: " + dateOfBirth + "\nUsername: " + username
            + "\n---------------------------------";
    }

    /**
     * Overrides .equals and checks the current account details against those of another.
     * 
     * @param a The account to check the details against.
     * @return True if all details match, false otherwise.
     */
    public boolean equals(Account a) {
        return this.firstName.equals(a.firstName) && this.lastName.equals(a.lastName) &&
            this.email.equals(a.email) && this.dateOfBirth.equals(a.dateOfBirth) &&
            this.username.equals(a.username) && this.password.equals(a.password);
    }

    public Object getCurrentLesson() {
        return accountID;
    }

    DataLoader dataLoader = DataLoader.getInstance();

    public ArrayList<Word> getReviewWords() {
        ArrayList<Word> reviewWords = new ArrayList<>();
        for (String wordId : this.reviewWords) {
            Word word = DataLoader.getInstance().getWordById(UUID.fromString(wordId));
            if (word != null) {
                reviewWords.add(word);
            }
        }
        return reviewWords;
    }

    public ArrayList<Phrase> getReviewPhrases() {
        ArrayList<Phrase> reviewPhrases = new ArrayList<>();
        for (String phraseId : this.reviewPhrases) {
            Phrase phrase = DataLoader.getInstance().getPhraseById(UUID.fromString(phraseId));
            if (phrase != null) {
                reviewPhrases.add(phrase);
            }
        }
        return reviewPhrases;
    }
    public void setLessonsCompleted(int lessons) {
        this.lessonsCompleted = lessons;
    }
    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }
    

}
    
