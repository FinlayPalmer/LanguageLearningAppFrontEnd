package com.model;

import java.util.UUID;
import java.util.ArrayList;

/**
 * @author Matthew Botteon
 * Creates a Question class to link together the four types of questions under one object
 */
public abstract class Question {
    private String title;
    private UUID questionID;

    /**
     * Creates a new Question without a UUID
     * 
     * @param title The title of the question
     */
    public Question(String title) {
        this.title = title;
        this.questionID = UUID.randomUUID();
    }

    /**
     * Creates a new Question with a UUID
     * 
     * @param title The title of the question
     * @param questionID The UUID of the question
     */
    public Question(String title, UUID questionID) {
        this.title = title;
        this.questionID = questionID;
    }

    /**
     * Retrieves the title of the question
     * 
     * @return The title of the question
     */
    public String getTitle() {
        return title;
    }

    /**
     * Retrieves the unique identifier for the question
     * 
     * @return The UUID of the question.
     */
    public UUID getUUID() {
        return questionID;
    }

    /**
     * Retrieves the text of the Question in String format
     */
    abstract String getQuestionText();

    /**
     * Retrieves the correct answer for the question.
     */
    abstract String getCorrectAnswer();

    /**
     * Checks if the user's answer is equal to the correct answer
     */
    public abstract boolean isAnswerCorrect(String answer);

    /**
     * Retrieves the type of the question
     */
    public abstract String getQuestionType();

    /**
     * Retrives an ArrayList of the Words involved in the Question
     */
    public abstract ArrayList<Word> getWordsInQuestion();

    /**
     * Retrives the Phrase involved in the Question
     */
    public abstract Phrase getPhraseInQuestion();
}
