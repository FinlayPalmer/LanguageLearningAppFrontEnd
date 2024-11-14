package com.model;

import java.util.ArrayList;

/**
 * @author Matthew Botteon
 * Creates a User Text Entry question type that requires the user to type in their answer - the English translation of the given Spanish phrase
 */
public class UserTextEntry extends Question {
    private String title;
    private Phrase questionText;
    private String userAnswer;
    private String correctAnswer;
    private String questionType;

    /**
     * Constructs a UserTextEntry question a Phrase for the question text
     * 
     * @param questionText The Phrase to be posed to the user, they will answer with the Phrase in English
     */
    public UserTextEntry(Phrase questionText) {
        super(questionText.getCategory());
        this.title = questionText.getCategory();
        this.questionText = questionText;
        this.correctAnswer = questionText.getTranslation();
        this.questionType = "User Text Entry";
    }

    /**
     * Gets the title of the question.
     * 
     * @return The question's title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the text of the question.
     * 
     * @return The text of the question.
     */
    public String getQuestionText() {
        return questionText.toString();
    }

    /**
     * Gets the user's answer.
     * 
     * @return The user's answer.
     */
    public String getUserAnswer() {
        return userAnswer;
    }

    /**
     * Gets the correct answer to the question.
     * 
     * @return The correct answer to the question as a string.
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * Gets the question type.
     * 
     * @return The question type, which will always be UserTextEntry.
     */
    public String getQuestionType() {
        return questionType;
    }

    /**
     * Sets the question text.
     * 
     * @param questionText The text of the question.
     */
    public void setQuestionText(Phrase questionText) {
        this.questionText = questionText;
    }

    /**
     * Sets the user's answer.
     * 
     * @param userAnswer The user's answer to the question.
     */
    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    /**
     * Sets the correct answer.
     * 
     * @param correctAnswer The correct answer for the question.
     */
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    /**
     * Checks if the user's answer is correct.
     * 
     * @return True if the user's answer matches the correct answer, false otherwise.
     */
    @Override
    public boolean isAnswerCorrect(String userAnswer) {
        return userAnswer.equals(correctAnswer.toString());
    }

    /**
     * Returns the question text as a String with a blank space
     */
    public String toString() {
        String string = "--------------------\n" + questionType + "\nCategory: " + title + "\n";
        string += "Translate the following phrase into English:\n" + questionText.toString();
        return string;
    }

    /**
     * Returns the Spanish words in the Question as an ArrayList, necessary for Flashcard and Matching
     * 
     * @return An ArrayList of Spanish words
     */
    public ArrayList<Word> getWordsInQuestion() {
        ArrayList<Word> spanishWords = new ArrayList<>();
        return spanishWords;
    }

    /**
     * Returns the Phrase in the question, necessary for FillInTheBlank and UserTextEntry
     * 
     * @return A phrase from the question
     */
    public Phrase getPhraseInQuestion() {
        return questionText;
    }
}
