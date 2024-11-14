package com.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author Astha Singh, Sanjana Guzzarlamudi, Matthew Botteon
 * 
 * The DataLoader class is responsible for loading and saving account and lesson data
 * from and to JSON files. It uses the json-simple library to handle JSON data.
 */
public class DataLoader extends DataConstants{
    private static DataLoader dataLoader;
    private HashMap<String, ArrayList<String>> categories;
    /**
     * Constructs a DataLoader instance.
     */
    private DataLoader() {
        categories = new HashMap<>();
        categories.put("word", new ArrayList<>());
        categories.put("phrase", new ArrayList<>());
    }

    /**
     * Gets the single instance of the DataLoader
     * 
     * @return The DataLoader object
     */
    public static DataLoader getInstance() {
        if (dataLoader == null) {
            dataLoader = new DataLoader();
        }
        return dataLoader;
    }

    /**
     * Retrieves a list of Account objects from the JSON file.
     *
     * @return An ArrayList of Account objects loaded from the JSON file.
     */
    public ArrayList<Account> getAccounts() {
        ArrayList<Account> accounts = new ArrayList<>();
        JSONParser parser = new JSONParser();
    
        try (InputStream inputStream = DataLoader.class.getResourceAsStream(ACCOUNTS_FILE);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader reader = new BufferedReader(inputStreamReader)) {
    
            JSONArray accountList = (JSONArray) parser.parse(reader);
    
            for (Object obj : accountList) {
                JSONObject accountJson = (JSONObject) obj;
                String firstName = (String) accountJson.get(DataConstants.ACCOUNT_FIRST_NAME);
                String lastName = (String) accountJson.get(DataConstants.ACCOUNT_LAST_NAME);
                String email = (String) accountJson.get(DataConstants.ACCOUNT_EMAIL);
                String dateOfBirth = (String) accountJson.get(DataConstants.ACCOUNT_DOB_STRING);
                String username = (String) accountJson.get(DataConstants.ACCOUNT_USERNAME);
                String password = (String) accountJson.get(DataConstants.ACCOUNT_PASSWORD);
    
                ArrayList<Word> reviewWords = new ArrayList<>();
                JSONArray reviewWordsJson = (JSONArray) accountJson.get(DataConstants.ACCOUNT_REVIEW_WORDS);
                if (reviewWordsJson != null) {
                    for (Object wordIdStr : reviewWordsJson) {
                        UUID wordId = UUID.fromString((String) wordIdStr);
                        Word word = getWordById(wordId);
                        if (word != null) {
                            reviewWords.add(word);
                        }
                    }
                }
    
                ArrayList<Phrase> reviewPhrases = new ArrayList<>();
                JSONArray reviewPhrasesJson = (JSONArray) accountJson.get(DataConstants.ACCOUNT_REVIEW_PHRASES);
                if (reviewPhrasesJson != null) {
                    for (Object phraseIdStr : reviewPhrasesJson) {
                        UUID phraseId = UUID.fromString((String) phraseIdStr);
                        Phrase phrase = getPhraseById(phraseId);
                        if (phrase != null) {
                            reviewPhrases.add(phrase);
                        }
                    }
                }
    
                Account account = new Account(firstName, lastName, email, dateOfBirth, username, password);
                account.getDashboard().setWordsToReview(reviewWords);
                account.getDashboard().setPhrasesToReview(reviewPhrases);
    
                accounts.add(account);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return accounts;
    }
    
    
                
    public Word getWordById(UUID wordId) {
        for (Word word : getWords()) {
            if (word.getUUID().equals(wordId)) {
                return word;
            }
        }
        return null; 
    }
    
    public Phrase getPhraseById(UUID phraseId) {
        for (Phrase phrase : getPhrases()) {
            if (phrase.getUUID().equals(phraseId)) {
                return phrase;
            }
        }
        return null; 
    }
    

    public ArrayList<Word> getWords() {
        ArrayList<Word> words = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try {
        InputStream inputStream = DataLoader.class.getResourceAsStream(WORD_FILE);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        JSONArray wordList = (JSONArray) parser.parse(reader);

            for (Object obj : wordList) {
                JSONObject categoryJson = (JSONObject) obj;
                String category = (String) categoryJson.get(DataConstants.WORD_CATEGORY);
                // Adds the category to the HashMap of valid categories under the 'word' key
                categories.get("word").add(category);
                JSONArray wordArray = (JSONArray) categoryJson.get(DataConstants.WORD_WORDS);

                for (Object wordObj : wordArray) {
                    JSONObject wordJson = (JSONObject) wordObj;
                    String text = (String) wordJson.get(DataConstants.WORD_TEXT);
                    String translation = (String) wordJson.get(DataConstants.WORD_TRANSLATION);
                    UUID wordID = UUID.fromString((String) wordJson.get(DataConstants.WORD_ID));

                    Word word = new Word(text, translation, category, wordID);
                    words.add(word);
                }
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } return words;
    }

    public ArrayList<Phrase> getPhrases() {
        ArrayList<Phrase> phrases = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try {
            InputStream inputStream = DataLoader.class.getResourceAsStream(PHRASE_FILE);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            JSONArray phraseList = (JSONArray) parser.parse(reader);

            for (Object obj : phraseList) {
                JSONObject categoryJson = (JSONObject) obj;
                String category = (String) categoryJson.get(DataConstants.PHRASE_CATEGORY);
                // Adds the category to the HashMap of valid categories under the 'phrase' key
                categories.get("phrase").add(category);
                JSONArray phraseArray = (JSONArray) categoryJson.get(DataConstants.PHRASE_WORDS);

                for (Object phraseObj : phraseArray) {
                    JSONObject phraseJson = (JSONObject) phraseObj;
                    ArrayList<String> text = new ArrayList<>();
                    String phraseText = (String) phraseJson.get(DataConstants.PHRASE_TEXT);
                    for(String word : phraseText.split(" "))
                        text.add(word.trim());
                    String translation = (String) phraseJson.get(DataConstants.PHRASE_TRANSLATION);
                    UUID phraseID = UUID.fromString((String) phraseJson.get(DataConstants.PHRASE_ID));
                    Phrase phrase = new Phrase(text, category,translation, phraseID);
                    phrases.add(phrase);
                }
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } return phrases;
    }

    /**
     * Creates a new Matching question by drawing from getWords
     * 
     * @param category The category of words to include in the Matching question
     * @param length The number of words to be included in the question
     * @param position The position of the word to be used in this question
     * @return The newly created Matching question
     */
    public Matching createMatching(String category, int length, int position) {
        ArrayList<Word> matching = new ArrayList<Word>();
        ArrayList<Word> question = new ArrayList<Word>();
        for (Word word : getWords()) {
            if (word.getCategory().equals(category))
                matching.add(word);
        } for (int i = 0; i < length; i++) {
            question.add(matching.get(position));
            matching.remove(question.get(i));
        } return new Matching(category, question);
    }

    /**
     * Creates a new Flashcard question by drawing from getWords
     * 
     * @param category The category of words to include in the Flashcard question
     * @param position The position of the word to be used in this question
     * @return The newly created Flashcard question
     */
    public Flashcard createFlashcard(String category, int position) {
        ArrayList<Word> flashcard = new ArrayList<Word>();
        for (Word word : getWords()) {
            if (word.getCategory().equals(category))
                flashcard.add(word);
        } Word question = flashcard.get(position);
            return new Flashcard(question);
    }

    /**
     * Creates a new FillInTheBlank question by drawing from getPhrases
     * 
     * @param category The category of phrases to include in the FillInTheBlank question
     * @param position The position of the phrase to be used in this question

     * @return The newly created FillInTheBlank question
     */
    public FillInTheBlank createFillInTheBlank(String category, int position) {
        ArrayList<Phrase> fillInTheBlank = new ArrayList<Phrase>();
        for (Phrase phrase : getPhrases()) {
            if (phrase.getCategory().equals(category))
                fillInTheBlank.add(phrase);
        } Phrase question = fillInTheBlank.get(position);
            // Creates a new FillInTheBlank question with a Phrase and a blank near the middle of the phrase
            if (question.getPhraseText().size() < 3)
                return new FillInTheBlank(question.getTranslation(), question, question.getPhraseText().size() / 2);
            else return new FillInTheBlank(question.getTranslation(), question, question.getPhraseText().size() / 2 + 1);
    }

    /**
     * Creates a new FillInTheBlank question by drawing from getPhrases
     * 
     * @param category The category of phrases to include in the FillInTheBlank question
     * @param position The position of the phrase to be used in this question
     * @return The newly created FillInTheBlank question
     */
    public UserTextEntry createUserTextEntry(String category, int position) {
        ArrayList<Phrase> userTextEntry = new ArrayList<Phrase>();
        for (Phrase phrase : getPhrases()) {
            if (phrase.getCategory().equals(category))
                userTextEntry.add(phrase);
        } Phrase question = userTextEntry.get(position);
            // Creates a new FillInTheBlank question with a Phrase
            return new UserTextEntry(question);
    }

    public ArrayList<Lesson> getLessons() {
        getWords();
        getPhrases();
        ArrayList<Lesson> lessons = new ArrayList<>();
        JSONParser parser = new JSONParser();
    
        try {
            InputStream inputStream = DataLoader.class.getResourceAsStream(LESSONS_FILE);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
           
            // Parse the JSON file to retrieve the "lessons" array
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray lessonList = (JSONArray) jsonObject.get("lessons");
    
            // Iterate through each lesson in the array
            for (Object obj : lessonList) {
                JSONObject lessonJson = (JSONObject) obj;
                UUID lessonID = UUID.fromString((String) lessonJson.get(DataConstants.LESSON_ID));
                String title = (String) lessonJson.get(DataConstants.LESSON_TITLE);
                // Create a new Lesson object and add it to the list
                lessons.add(new Lesson(title, addQuestionsToLessons(title), null, lessonID));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } return lessons;
    }
    
    /**
     * Loops thru the ArrayList of categories and creates mutiple question types for each category
     * 
     * @return An ArrayList of questions that use either words or phrases, depending on the category
     */
    public ArrayList<Question> addQuestionsToLessons(String category) {
        // Loops thru the list of categories pulled from Word and Phrase
            ArrayList<Question> questions = new ArrayList<>();
            // Loops thru to add 5 questions to a lesson,
            // but only if the category exists for Word or Phrase, depending on the question type
            int count = 0;
            for(int j = 0; j < 5; j++) {
                if(categories.get("word").contains(category)){
                    questions.add(createFlashcard(category, j));
                    count++;
                    if (count >= 5)
                        break;
                }
                if(categories.get("word").contains(category)) {
                    questions.add(createMatching(category, 5, j));
                    count++;
                    if (count >= 5)
                        break;
                }
                if(categories.get("phrase").contains(category)) {
                    questions.add(createFillInTheBlank(category, j));
                    count++;
                    if (count >= 5)
                        break;
                } 
                if(categories.get("phrase").contains(category)) {
                    questions.add(createUserTextEntry(category, j));
                    count++;
                    if (count >= 5)
                        break;
                }
            } return questions;
    }

    /**
     * Utility function to convert a JSONArray to an ArrayList<String>.
     *
     * @param jsonArray The JSONArray to convert.
     * @return An ArrayList<String> containing the elements of the JSONArray.
     */
    private ArrayList<String> convertJSONArrayToList(JSONArray jsonArray) {
        ArrayList<String> list = new ArrayList<>();
        if (jsonArray == null) { 
            System.out.println("Warning: JSONArray is null in convertJSONArrayToList");
            return list; 
        }
        for (Object obj : jsonArray) {
            list.add((String) obj);
        }
        return list;
    }
}
