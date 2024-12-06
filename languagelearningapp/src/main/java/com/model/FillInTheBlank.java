package com.model;

import java.util.ArrayList;

/**
 * @author Matthew Botteon and Astha Singh
 *         Creates a Fill in the Blank question type with a blank index in an
 *         array of words, requiring the user to fill it in.
 */
public class FillInTheBlank extends Question {
    private String title;
    private Phrase questionText;
    private String userAnswer;
    private int blankPosition;
    private String questionType;

    /**
     * Creates a new Fill in the Blank question with a title, text, and answer.
     * 
     * @param title         The name of the question.
     * @param questionText  The text of the question, to give the missing blank
     *                      context.
     * @param blankPosition The position of the missing word within the given text.
     */
    public FillInTheBlank(String title, Phrase questionText, int blankPosition) {
        super(title);
        this.title = title;
        this.questionText = questionText;
        this.blankPosition = blankPosition;
        this.questionType = "Fill In The Blank";
    }

    /**
     * Returns the title of the Fill in the Blank question
     * 
     * @return The title of the question
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the question text in String format
     * 
     * @return The text of the question
     */
    @Override
    public String getQuestionText() {
        if (blankPosition == -1 || blankPosition >= questionText.getPhraseText().size()) {
            return "Invalid question. Blank position could not be determined.";
        }
        return questionText.toString();
    }

    /**
     * Gets the correct answer of the blank space in String format
     * 
     * @return The answer to fill in the blank space
     */
    @Override
    public String getCorrectAnswer() {
        if (blankPosition == -1 || blankPosition >= questionText.getPhraseText().size()) {
            return "N/A";
        }
        return questionText.getPhraseText().get(blankPosition);
    }

    /**
     * Returns the type of question, in this case "FillInTheBlank"
     * 
     * @return "FillInTheBlank"
     */
    @Override
    public String getQuestionType() {
        return questionType;
    }

    @Override
    public boolean isAnswerCorrect(String userAnswer) {
        return userAnswer.equalsIgnoreCase(getCorrectAnswer());
    }

    /**
     * Sets the user's answer to a String
     * 
     * @param userAnswer The answer the user provided
     */
    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    /**
     * Sets the blank position in the phrase.
     * 
     * @param blankPosition The new blank position.
     */
    public void setBlankPosition(int blankPosition) {
        this.blankPosition = blankPosition;
    }

    /**
     * Returns the blank position
     * 
     * @return blankPosition
     */
    public int getBlankPosition() {
        return blankPosition;
    }

    /**
     * Returns the question text as a String with a blank space
     */
    public String toString() {
        String string = "\nEnglish Meaning: " + title + "\n";
        for (int i = 0; i < questionText.getPhraseText().size(); i++) {
            if (i != blankPosition)
                string = string + questionText.getPhraseText().get(i) + " ";
            else
                string = string.concat(" _______ ");
        }
        return string;
    }

    /**
     * Returns the Spanish words in the Question as an ArrayList, necessary for
     * Flashcard and Matching
     * 
     * @return An ArrayList of Spanish words
     */
    public ArrayList<Word> getWordsInQuestion() {
        ArrayList<Word> spanishWords = new ArrayList<>();
        return spanishWords;
    }

    /**
     * Returns the Phrase in the question, necessary for FillInTheBlank and
     * UserTextEntry
     * 
     * @return A phrase from the question
     */
    public Phrase getPhraseInQuestion() {
        return questionText;
    }
}
