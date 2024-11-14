package com.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Sanjana Guzzarlamudi, Matthew Botteon
 * 
 * Creates an initial lesson for the user to complete to determine their prior skill level
 */

public class SkillLevelTest extends Lesson {
    private String title;
    private ArrayList<Question> questions;
    private int questionNumber;
    private int userScore;
    private SkillLevel skillLevel;
    private UUID lessonID;

    /**
     * Constructs a SkillLevelTest by calling super constructor of Lesson
     */
    public SkillLevelTest() {
        super("Skill Level Test", null, null);
        this.questionNumber = 0;
        this.userScore = 0;
        this.skillLevel = SkillLevel.EASY;
    }

    /**
     * Constructs a SkillLevelTest by calling super constructor of Lesson with a UUID
     * 
     * @param lessonID The unique identifier of the SkillLevelTest
     */
    public SkillLevelTest(UUID lessonID) {
        super("Skill Level Test", null, null, lessonID);
        this.questionNumber = 0;
        this.userScore = 0;
        this.skillLevel = SkillLevel.EASY;
    }

    /**
     * Gets the title of the lesson.
     *
     * @return The title of the lesson.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the list of questions in the lesson.
     *
     * @return The list of questions.
     */
    public ArrayList<Question> getQuestions() {
        return questions;
    }

    /**
     * Gets the current question the user is on
     * 
     * @return The question at the index of the questionNumber attribute
     */
    public Question getCurrentQuestion() {
        return questions.get(questionNumber);
    }

    /**
     * Gets the number of the question the user is currently on
     * 
     * @return The index of the current question in the ArrayList plus one
     */
    public int getQuestionNumber() {
        // Plus one to adjust for ArrayList indices beginning at zero
        return questionNumber + 1;
    }

    /**
     * Returns the user's score as a String showing how many questions they have gotten right and attempted
     * 
     * @return The number of questions right / the number of questions attempted
     */
    public String getUserScore() {
        return "Your score: " + userScore + "/" + (questionNumber + 1);
    }

    /**
     * Gets the recommended Skill Level based on the user's results
     * 
     * @return The recommended Skill Level
     */
    public SkillLevel getSkillLevel() {
        setRecSkillLevel();
        return this.skillLevel;
    }

    /**
     * Gets the unique identifier for the lesson.
     *
     * @return The UUID of the lesson.
     */
    public UUID getUUID() {
        return lessonID; // Return the UUID as the lesson ID
    }

    /**
     * Moves to the next question if there are still some left
     */
    public void moveToNextQuestion() {
        // Checks the question number will not move out of the ArrayList if incremented
        if(questionNumber < questions.size() - 1)
            questionNumber++;
        else endLesson();
    }

    /**
     * Calculates the correct Skill Level to recommend the user after they complete the Skill Level Test
     */
    public void setRecSkillLevel() {
        // If the user gets 11 to 16 questions correct, they are recommended Medium
        if(userScore > 10 && userScore < 17)
            this.skillLevel = SkillLevel.MEDIUM;
        // If the user gets 17 or more questions correct, they are recommended Difficult
        else if(userScore > 16)
            this.skillLevel = SkillLevel.DIFFICULT;
        // If the user gets 10 or less questions correct, they are recommended the default value of Easy
    }


     /**
     * Submits the answer for the current question and updates the score if the answer is correct.
     *
     * @param answer The answer provided by the user.
     * @return True if the answer is correct; false otherwise.
     */
    public boolean submitAnswer(String answer) {
        return true;
    }

    /**
     * Validates the provided answer against the correct answer.
     *
     * @param answer The answer provided by the user.
     * @param correctAnswer The correct answer to validate against.
     * @return True if the provided answer is correct; false otherwise.
     */
    public boolean validateAnswer(String answer, String correctAnswer) {
        return answer.equals(correctAnswer);
    }

    /**
     * Starts the skill level test. This method can contain logic to present the first question.
     */
    public void startTest() {

    }
    /**
     * Ends the test and can contain logic to show results or feedback.
     */
    public void endTest() {
        
    }
}
