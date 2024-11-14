package com.model;
import java.util.UUID;

// Words from https://spanish.kwiziq.com/learn/theme

/**
 * @author Matthew Botteon
 * Creates a Word object with both Spanish text and its English translation
 */
public class Word {
    private String text;
    private String translation;
    private String category;
    private UUID wordID;

    /**
     * Creates a new instance of a Word without a UUID
     * 
     * @param text The Spanish word
     * @param translation The English translation
     * @param category The topic of the word
     */
    public Word(String text, String translation, String category) {
        this.text = text;
        this.translation = translation;
        this.category = category;
        this.wordID = UUID.randomUUID();
    }

    /**
     * Creates a new instance of a Word with a UUID
     * 
     * @param text The Spanish word
     * @param translation The English translation
     */
    public Word(String text, String translation, String category, UUID wordID) {
        this.text = text;
        this.translation = translation;
        this.category = category;
        this.wordID = wordID;
    }

    /**
     * Gets the word in Spanish
     * 
     * @return The word in Spanish
     */
    public String getWordText() {
        return text;
    }
    
    /**
     * Gets the word in English
     * 
     * @return The English translation
     */
    public String getTranslation() {
        return translation;
    }

    /**
     * Gets the category, or topic, of the word
     * 
     * @return The category of the word
     */
    public String getCategory() {
        return category;
    }

    /**
     * Gets the UUID of the Word
     * 
     * @return The Word's UUID
     */
    public UUID getUUID() {
        return wordID;
    }

    /**
     * Sets the Word to a new word with a new translation
     * 
     * @param text The Spanish word
     * @param translation The English translation
     */
    public void editWord(String text, String translation) {
        this.text = text;
        this.translation = translation;
    }

    public String toString() {
        return text + ", " + translation + ", " + category;
    }
}
