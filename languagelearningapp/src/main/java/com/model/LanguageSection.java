package com.model;

import java.util.ArrayList;

/**
 * @author Sanjana Guzzarlamudi, Matthew Botteon, Finlay Palmer
 * 
 *         LanguageSection represents a section of lessons for a particular
 *         language
 */
public class LanguageSection {
    private String language;
    private ArrayList<Lesson> lessons;
    private String welcomeMessage;
    private ArrayList<Word> possibleDailyWords;
    private ArrayList<Lesson> completedLessons;
    private ArrayList<Lesson> startedLessons;

    /**
     * constructs a LanguageSection with a specific language
     * 
     * @param language The language this section of lessons will teach
     */
    public LanguageSection(String language) {
        this.language = language;
        this.lessons = new ArrayList<>();
        this.possibleDailyWords = new ArrayList<>();
        this.completedLessons = new ArrayList<Lesson>();
        this.startedLessons = new ArrayList<Lesson>();
    }

    /**
     * Gets the language this section is teaching
     * 
     * @return The language of this section
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Adds a lesson to the section
     * 
     * @param lesson The lesson to add to the section
     */
    public void addLesson(Lesson lesson) {
        if (!lessons.contains(lesson)) {
            lessons.add(lesson);
        }
    }
    public void addLessons(ArrayList<Lesson> newLessons) {
        for (Lesson lesson : newLessons) {
            addLesson(lesson);
        }
    }
    /**
     * Removes a lesson from the section
     * 
     * @param lesson The lesson to remove from the section
     */
    public void removeLesson(Lesson lesson) {
        lessons.remove(lesson);
    }

    /**
     * Sets a welcome message specific to this section
     * 
     * @param welcomeMessage The desired welcome message
     */
    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    /**
     * Gets the welcome message for this section
     * 
     * @return The welcome message
     */
    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    /**
     * Gets a daily word
     * 
     * @return A daily word
     */
    public String getDailyWord() {
        if (!possibleDailyWords.isEmpty()) {
            int randomIndex = (int) (Math.random() * possibleDailyWords.size());
            return possibleDailyWords.get(randomIndex).getWordText(); 
        }
        return "";
    }

    /**
     * Removes the daily word from the ArrayList of possible words
     */
    public void removeDailyWord() {

    }

    /**
     * Returns lessons
     * 
     * @return lessons
     */
    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    /**
     * Gets the list of lessons completed by the account
     * 
     * @return The list of completed lessons
     */
    public ArrayList<Lesson> getCompletedLessons() {
        return completedLessons;
    }

    /**
     * Gets the list of lessons started by the account
     * 
     * @return The list of started lessons
     */
    public ArrayList<Lesson> getStartedLessons() {
        return startedLessons;
    }

    /**
     * Adds a completed lesson to the dashboard
     * 
     * @param lesson The lesson that has been completed
     */
    public void addCompletedLesson(Lesson lesson) {
        if (!completedLessons.contains(lesson)) {
            completedLessons.add(lesson);
        }
    }
    public void setLessons(ArrayList<Lesson> initialLessons) {
        this.lessons = new ArrayList<>(initialLessons);
    }

    /**
     * Adds a started lesson to the dashboard
     * 
     * @param lesson The lesson that has been started
     */
    public void addStartedLesson(Lesson lesson) {
        if (!startedLessons.contains(lesson) && !completedLessons.contains(lesson)) {
            startedLessons.add(lesson);
        }
    }
}
