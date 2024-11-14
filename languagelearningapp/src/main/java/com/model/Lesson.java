package com.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Matthew Botteon and Astha Singh
 *         Represents a lesson containing a story and a set of questions.
 */
public class Lesson {
    private String title;
    private ArrayList<Question> questions;
    private int questionNumber;
    private int userScore;
    private Story story;
    private boolean lessonComplete;
    private UUID lessonID;

    /**
     * Constructor for Lesson with a title, questions, and story but no UUID.
     *
     * @param title     The title of the lesson.
     * @param questions The list of questions for the lesson.
     * @param story     The story to be included in the lesson.
     */
    public Lesson(String title, ArrayList<Question> questions, Story story) {
        this.title = title;
        this.questions = questions;
        this.questionNumber = 0;
        this.userScore = 0;
        this.story = story;
        this.lessonComplete = false;
        this.lessonID = UUID.randomUUID();
    }

    /**
     * Constructor for Lesson with a title, questions, story, and UUID.
     *
     * @param title     The title of the lesson.
     * @param questions The list of questions for the lesson.
     * @param story     The story to be included in the lesson.
     * @param lessonID  The unique identifier of the lesson.
     */
    public Lesson(String title, ArrayList<Question> questions, Story story, UUID lessonID) {
        this.title = title;
        this.questions = questions;
        this.questionNumber = 0;
        this.userScore = 0;
        this.story = story;
        this.lessonComplete = false;
        this.lessonID = lessonID;
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
     * Gets the current question the user is on.
     *
     * @return The question at the index of the questionNumber attribute.
     */
    public Question getCurrentQuestion() {
        return questions.get(questionNumber);
    }

    /**
     * Gets the number of the question the user is currently on.
     *
     * @return The index of the current question in the ArrayList plus one.
     */
    public int getQuestionNumber() {
        return questionNumber + 1; // Plus one to adjust for ArrayList indices beginning at zero.
    }

    /**
     * Returns the user's score as a String showing how many questions they have
     * gotten right and attempted.
     *
     * @return The number of questions right / the number of questions attempted.
     */
    public String getUserScore() {
        return "Your score: " + userScore + "/" + (questionNumber + 1);
    }
    public int getUserScoreCount() {
        return userScore; 
    }
    /**
     * Gets the content of the story associated with the lesson.
     *
     * @return The content of the story or a message if no content is available.
     */
    public String getStoryContent() {
        return (story != null) ? story.getContent() : "No content available";
    }

    public boolean getLessonComplete() {
        return lessonComplete;
    }

    /**
     * Gets the unique identifier for the lesson.
     *
     * @return The UUID of the lesson.
     */
    public UUID getUUID() {
        return lessonID;
    }

    /**
     * Adds a question to the lesson.
     *
     * @param question The question to add.
     */
    public void addQuestion(Question question) {
        questions.add(question);
    }

    /**
     * Removes a question from the lesson.
     *
     * @param question The question to remove.
     */
    public void removeQuestion(Question question) {
        questions.remove(question);
    }

    /**
     * Moves to the next question if there are still some left.
     */
    public void moveToNextQuestion() {
        if (questionNumber < questions.size() - 1) {
            questionNumber++;
        } else {
            endLesson();
        }
    }

    /**
     * Moves to the previous question if there is one.
     */
    public void moveToPrevQuestion() {
        if (questionNumber > 0) {
            questionNumber--;
        }
    }

    /**
     * Increments the userScore if they got the question correct.
     */
    public void updateScore() {
        userScore++;
    }

    /**
     * Starts the lesson by returning the first question
     */
    public Question startLesson() {
        if (questions.size() > 0) {
            questionNumber = 0;
            return questions.get(questionNumber);
        }
        return null;
    }

    /**
     * Ends the lesson.
     */
    public String endLesson() {
        lessonComplete = true;
        return "Ending lesson: " + title;
    }

    /**
     * Starts the story associated with the lesson.
     */
    public void startStory() {
        if (story != null) {
            story.start();
        }
    }

    /**
     * Ends the story associated with the lesson.
     */
    public void endStory() {
        if (story != null) {
            story.end();
        }
    }

    /**
     * Returns the lesson information in a readable String
     * 
     * @return The information of the lesson in a readable String
     */
    public String toString() {
        return "Lesson Title: " + title;
    }
}
