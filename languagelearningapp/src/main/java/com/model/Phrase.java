package com.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Matthew Botteon
 * Creates a Phrase of Spanish words to be used in questions.
 */
public class Phrase {
    private ArrayList<String> text;
    private String category;
    private String translation;
    private UUID phraseID;

    /**
     * Creates a new instance of a Phrase object without a UUID.
     * 
     * @param text The Spanish words that make up the phrase.
     * @param category The category, or topic, of the phrase.
     * @param translation The English translation of the phrase.
     */
    public Phrase(ArrayList<String> text, String category, String translation) {
        this.text = text;
        this.category = category;
        this.translation = translation;
        this.phraseID = UUID.randomUUID();
    }

    /**
     * Creates a new instance of a Phrase with a UUID
     * 
     * @param text The Spanish words that make up the phrase.
     * @param category The category, or topic, of the phrase.
     * @param translation The English translation of the phrase.
     * @param phraseID The unique identifier of the phrase.
     */
    public Phrase(ArrayList<String> text, String category, String translation, UUID phraseID) {
        this.text = text;
        this.category = category;
        this.translation = translation;
        this.phraseID = phraseID;
    }

    /**
     * Gets the Spanish text of the phrase.
     * 
     * @return The Spanish text of the phrase.
     */
    public ArrayList<String> getPhraseText() {
        return text;
    }

    /**
     * Gets the category of the Phrase.
     * 
     * @return The Phrase's category.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Gets the English translation of the phrase.
     * 
     * @return The English translation of the phrase.
     */
    public String getTranslation() {
        return translation;
    }
    
    /**
     * Gets the UUID of the Phrase.
     * 
     * @return The Phrase's UUID.
     */
    public UUID getUUID() {
        return phraseID;
    }

    /**
     * Edits the text of the phrase.
     * 
     * @param text The new Spanish text.
     * @param translation The new English translation.
     */
    public void editPhrase(ArrayList<String> text, String translation) {
        this.text = text;
        this.translation = translation;
    }

    /**
     * Formats the ArrayList of Words as a String.
     * 
     * @return The words of the phrase in String format.
     */
    public String toString() {
        String questionText = "";
        for(String string : text)
            questionText = questionText + " " + string;
        return questionText;
    }
}
