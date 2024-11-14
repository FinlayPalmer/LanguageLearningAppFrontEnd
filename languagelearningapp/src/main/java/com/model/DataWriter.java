package com.model;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author Sanjana Guzzarlamudi, Astha Singh, Matthew Botteon
 * 
 * DataWriter class is responsible for saving account and lesson data
 * to JSON files. It uses the json-simple library to handle JSON data.
 */
public class DataWriter extends DataConstants {
    private static final Path WRITE_DIRECTORY = Paths.get("data");
    /**
     * Saves the list of Account objects to the JSON file.
     *
     * @param accounts The ArrayList of Account objects to be saved to the JSON file.
     */
    @SuppressWarnings("unchecked")
    public void saveAccounts(ArrayList<Account> accounts) {
        JSONArray accountList = new JSONArray();

        for (Account account : accounts) {
            JSONObject accountJson = new JSONObject();
            accountJson.put(DataConstants.ACCOUNT_FIRST_NAME, account.getFirstName());
            accountJson.put(DataConstants.ACCOUNT_LAST_NAME, account.getLastName());
            accountJson.put(DataConstants.ACCOUNT_EMAIL, account.getEmail());
            accountJson.put(DataConstants.ACCOUNT_DOB_STRING, account.getDateOfBirth());
            accountJson.put(DataConstants.ACCOUNT_USERNAME, account.getUsername());
            accountJson.put(DataConstants.ACCOUNT_PASSWORD, account.getPassword());

            accountList.add(accountJson);
        
        // Handle review words
        JSONArray reviewWordsJson = new JSONArray();
        for (Word word : account.getDashboard().getWordsToReview()) {
            reviewWordsJson.add(word.getUUID().toString());
        }
        accountJson.put(DataConstants.ACCOUNT_REVIEW_WORDS, reviewWordsJson);

        // Handle review phrases
        JSONArray reviewPhrasesJson = new JSONArray();
        for (Phrase phrase : account.getDashboard().getPhrasesToReview()) {
            reviewPhrasesJson.add(phrase.getUUID().toString());
        }
        accountJson.put(DataConstants.ACCOUNT_REVIEW_PHRASES, reviewPhrasesJson);

        // Save Avatar information
        JSONObject avatarJson = new JSONObject();
        Avatar avatar = account.getAvatar();
        avatarJson.put(DataConstants.AVATAR_BASE, avatar.getBaseAvatar());

        JSONObject featuresJson = new JSONObject();
        featuresJson.put(DataConstants.AVATAR_MOUTH_STYLES, avatar.getMouthStyles());
        featuresJson.put(DataConstants.AVATAR_EYE_STYLES, avatar.getEyeStyles());
        featuresJson.put(DataConstants.AVATAR_HAIR_STYLES, avatar.getHairStyles());
        featuresJson.put(DataConstants.AVATAR_NOSE_STYLES, avatar.getNoseStyles());
        featuresJson.put(DataConstants.AVATAR_HAT_STYLES, avatar.getHatStyles());

        avatarJson.put(DataConstants.AVATAR_FEATURES, featuresJson);
        accountJson.put(DataConstants.ACCOUNT_AVATAR, avatarJson);

        // Add the accountJson to the accountList once after all properties are populated
        accountList.add(accountJson);
    }

   try {
            Files.createDirectories(WRITE_DIRECTORY);
        } catch (IOException e) {
            System.err.println("Error creating data directory: " + e.getMessage());
            return;
        }

    // Write the accountList to the JSON file
    Path filePath = WRITE_DIRECTORY.resolve("Account.json");
        try (FileWriter file = new FileWriter(filePath.toString())) {
            file.write(accountList.toJSONString());
            file.flush();
        } catch (IOException e) {
            System.err.println("Error saving accounts to JSON file: " + e.getMessage());
        }
    }

    

    /**
     * Saves the list of Lesson objects to the JSON file.
     *
     * @param lessons The ArrayList of Lesson objects to be saved to the JSON file.
     */
    @SuppressWarnings("unchecked")
    public void saveLessons(ArrayList<Lesson> lessons) {
        JSONArray lessonList = new JSONArray();

        for (Lesson lesson : lessons) {
            JSONObject lessonJson = new JSONObject();
            lessonJson.put(DataConstants.LESSON_ID, lesson.getUUID().toString());
            lessonJson.put(DataConstants.LESSON_TITLE, lesson.getTitle());

            // Save lesson content
            JSONArray contentArray = new JSONArray();
            for (Question question : lesson.getQuestions()) {
                JSONObject questionJson = new JSONObject();
                questionJson.put(DataConstants.QUESTION_TYPE, question.getQuestionType());
                questionJson.put(DataConstants.QUESTION_TEXT, question.getQuestionText());
                questionJson.put(DataConstants.QUESTION_CORRECT_ANSWER, question.getCorrectAnswer());

                contentArray.add(questionJson);
            }
            lessonJson.put(DataConstants.LESSON_CONTENT, contentArray);

            lessonList.add(lessonJson);
        }
        try (OutputStream os = new FileOutputStream(getClass().getResource(LESSONS_FILE).getPath())) {
            os.write(lessonList.toJSONString().getBytes());
            os.flush();
        } catch (IOException e) {
            System.err.println("Error saving lessons to JSON file: " + e.getMessage());
        }
    
        try (FileWriter file = new FileWriter(LESSONS_FILE)) {
            file.write(lessonList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
