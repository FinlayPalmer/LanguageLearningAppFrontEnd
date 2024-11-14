package com.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Sanjana Guzzarlamudi, Matthew Botteon, Finlay Palmer
 * 
 *         Dashboard manages learning sections, lessons and their completion,
 *         and the leaderboard
 */
public class Dashboard {
    private ArrayList<LanguageSection> sections;
    private LanguageSection currentSection;
    private Leaderboard leaderboard;
    private ArrayList<Word> wordsToReview;
    private ArrayList<Phrase> phrasesToReview;
    private double progress;

    public static final String LESSONS_FILE = "json/Lessons.json";

    /**
     * Creates a dashboard for an account
     * 
     * @param account The account associated with this dashboard
     */
    public Dashboard(Account account) {
        this.sections = new ArrayList<LanguageSection>();
        this.wordsToReview = new ArrayList<>();
        this.phrasesToReview = new ArrayList<>();
        this.leaderboard = Leaderboard.getInstance();
        this.progress = 0;

        if (this.currentSection == null) {
            this.currentSection = new LanguageSection("Spanish");
        }
    }

    /**
     * Gets all language sections on this account
     * 
     * @return All language sections
     */
    public ArrayList<LanguageSection> getAllSections() {
        return sections;
    }

    /**
     * Gets the current section
     * 
     * @return The current section
     */
    public LanguageSection getCurrentSection() {
        return currentSection;
    }

    /**
     * Gets the leaderboard of the system
     * 
     * @return The leaderboard of top accounts
     */
    public Leaderboard getLeaderboard() {
        return leaderboard;
    }

    /**
     * Gets the list of words the user is struggling with
     * 
     * @return The list of words the user is struggling with
     */
    public ArrayList<Word> getWordsToReview() {
        return wordsToReview;
    }

    /**
     * Gets the list of phrases the user is struggling with
     * 
     * @return The list of phrases the user is struggling with
     */
    public ArrayList<Phrase> getPhrasesToReview() {
        return phrasesToReview;
    }

    /**
     * Sets the current section to a new one
     * 
     * @param section The section to be set as current
     */
    public void setCurrentSection(LanguageSection section) {
        this.currentSection = section;
    }

    /**
     * Add a word to the list of words the user is struggling with
     * 
     * @param word The word the user is struggling with
     */
    public void addWordToReviewList(Word word) {
        if (!wordsToReview.contains(word))
            wordsToReview.add(word);
    }

    /**
     * Add a word to the list of words the user is struggling with
     * 
     * @param phrase The phrase the user is struggling with
     */
    public void addPhraseToReviewList(Phrase phrase) {
        if (!phrasesToReview.contains(phrase)) {
            phrasesToReview.add(phrase);
        }
    }

    /**
     * Remove a word from the list of words the user is struggling with
     * 
     * @param word The word the user is no longer struggling with
     */
    public void removeWordFromReviewList(Word word) {
        if (wordsToReview.contains(word))
            wordsToReview.remove(word);
    }

    /**
     * Remove a phrase to the list of words the user is struggling with
     * 
     * @param phrase The phrase the user is struggling with
     */
    public void removePhraseFromReviewList(Phrase phrase) {
        if (phrasesToReview.contains(phrase)) {
            phrasesToReview.remove(phrase);
        }
    }
    public void setWordsToReview(ArrayList<Word> reviewWords) {
        this.wordsToReview = reviewWords;
    }
    
    public void setPhrasesToReview(ArrayList<Phrase> reviewPhrases) {
        this.phrasesToReview = reviewPhrases;
    }
    public Word getWordById(UUID wordId) {
        for (Word word : DataLoader.getInstance().getWords()) {  
            if (word.getUUID().equals(wordId)) {
                return word;
            }
        }
        return null; 
    }

    public Phrase getPhraseById(UUID phraseId) {
        for (Phrase phrase : DataLoader.getInstance().getPhrases()) {  
            if (phrase.getUUID().equals(phraseId)) {
                return phrase;
            }
        }
        return null; 
    }

    /**
     * Calculates and returns the progress through the lessons in the current
     * section
     * 
     * @return
     */

    public double getProgress() {
        LessonList lessonList = LessonList.getInstance();
        if (currentSection != null) {
            progress = ((double) currentSection.getCompletedLessons().size()
                    / (double) lessonList.getListOfAllLessons().size()) * 100;
        }
        return progress;
    }

    public void displayProgress() {
        System.out.println("Current Progress: " + getProgress() + "%");
        if (currentSection != null) {
            System.out.println("Lessons Completed: " + currentSection.getCompletedLessons().size());
            System.out.println("Total Lessons: " + currentSection.getLessons().size());
        } else {
            System.out.println("No current section set.");
        }
    }
}
