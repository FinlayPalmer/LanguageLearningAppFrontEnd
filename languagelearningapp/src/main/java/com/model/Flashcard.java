package com.model;

import java.util.ArrayList;

/**
 * @author Matthew Botteon and Astha Singh
 * Creates a Flashcard question type with a Spanish word on one side and its translation on the reverse.
 */
public class Flashcard extends Question {
    private Word word;
    private String spanishText;
    private String englishText;
    private boolean isAnsweredCorrectly;
    private int timesReviewed;
    private String questionType;

    /**
     * Creates a new question of Flashcard type with a Spanish word and its translation.
     * 
     * @param spanishText The Spanish word the user is being quizzed on.
     * @param englishText The English translation of the word.
     */
    public Flashcard(Word word) {
        super(word.getWordText());
        this.word = word;
        this.spanishText = word.getWordText();
        this.englishText = word.getTranslation();
        this.isAnsweredCorrectly = false;
        this.timesReviewed = 0;
        this.questionType = "Flashcard";
    }

    /**
     * Gets the title of the question.
     * 
     * @return The question's title (front side of the flashcard).
     */
    public String getTitle() {
        return spanishText;
    }

    /**
     * Displays the text of the Spanish word (front side of the flashcard).
     * 
     * @return The Spanish word being quizzed.
     */
    public String getSpanish() {
        return spanishText;
    }

    /**
     * Gets the English text (back side of the flashcard).
     * 
     * @return The English translation (back of the flashcard).
     */
    @Override
    public String getCorrectAnswer() {
        return englishText;
    }

    /**
     * Checks if the flashcard was answered correctly.
     * 
     * @return True if the user's answer matches the correct answer.
     */
    @Override
    public boolean isAnswerCorrect(String userAnswer) {
        return userAnswer.equalsIgnoreCase(englishText);
    }

    /**
     * Gets the number of times this specific flashcard has been reviewed by the user.
     * 
     * @return The number of times this flashcard has been reviewed.
     */
    public int getTimesReviewed() {
        return timesReviewed;
    }

    /**
     * Gets the question text for display.
     * 
     * @return The Spanish word (front of the flashcard).
     */
    @Override
    public String getQuestionText() {
        return spanishText;
    }

    /**
     * Gets the question type (Flashcard).
     * 
     * @return The question type.
     */
    public String getQuestionType() {
        return questionType;
    }

    /**
     * Sets the question to a new word and translation.
     * 
     * @param spanishText The new Spanish word.
     */
    public void setQuestionText(String spanishText) {
        this.spanishText = spanishText;
    }

    /**
     * Marks the flashcard as answered correctly.
     */
    public void markAnsweredCorrect() {
        isAnsweredCorrectly = true;
    }

    /**
     * Resets the number of times the flashcard has been reviewed.
     */
    public void resetReviewStatus() {
        timesReviewed = 0;
    }

    /**
     * Updates the number of times the flashcard has been reviewed.
     */
    public void incrementTimesReviewed() {
        timesReviewed++;
    }

    /**
     * Returns the information about the question in String format
     */
    public String toString() {
        String string = "--------------------\n"+ questionType + "\nCategory: " + word.getCategory() + "\n";
        return string + spanishText;
    }

    /**
     * Returns the Spanish words in the Question as an ArrayList, necessary for Flashcard and Matching
     * 
     * @return An ArrayList of Spanish words
     */
    public ArrayList<Word> getWordsInQuestion() {
        ArrayList<Word> spanishWords = new ArrayList<>();
        spanishWords.add(word);
        return spanishWords;
    }

    /**
     * Returns the Phrase in the question, necessary for FillInTheBlank and UserTextEntry
     * 
     * @return A phrase from the question
     */
    public Phrase getPhraseInQuestion() {
        return null;
    }
}
