package com.model;

import java.util.ArrayList;

/**
 * Creates new LessonList
 * 
 * @author Finlay Palmer, Matthew Botteon
 */
public class LessonList {
    private ArrayList<Lesson> lessons;
    private static LessonList lessonList;

    /**
     * Creates a new LessonList
     */
    private LessonList() {
        lessons = DataLoader.getInstance().getLessons();
        lessons.add(new Lesson("Review Lesson", new ArrayList<>(), null));
    }

    /**
     * Returns lessonList and creates it if it doesn't already exist
     * 
     * @return The only instance of LessonList
     */
    public static LessonList getInstance() {
        if (lessonList == null) {
            lessonList = new LessonList();
        }
        return lessonList;
    }

    /**
     * Adds a new Lesson to the ArrayList of lessons
     * 
     * @param title The title of the lesson
     * @param questions The ArrayList of questions making up the lesson
     * @param story The story involved in the lesson
     */
    public void addLesson(String title, ArrayList<Question> questions, Story story) {
        lessons.add(new Lesson(title, questions, story));
    }

    /**
     * Returns a Lesson in lesson based off of its title
     * 
     * @param title The title of the lesson
     * @return The Lesson based off of its title
     */
    public Lesson getLesson(String title) {
        for (Lesson lesson : lessons) {
            if (lesson.getTitle().equals(title)) {
                return lesson;
            }
        }
        return null;
    }

    /**
     * Changes a specific Lesson
     * 
     * @param title        The title of the Lesson to change
     * @param newQuestions The new questions to add to the Lesson
     */
    public void editLesson(String title, ArrayList<Question> newQuestions) {
        for(int i = 0; i < lessons.size(); i++) {
            // Checks for a match of the Lesson's title
            if(lessons.get(i).getTitle().equals(title)) {
                // If one is found, the newQuestions are iterated over and added to that lesson
                for(int j = 0; j < newQuestions.size(); j++)
                    lessons.get(i).addQuestion(newQuestions.get(j));
            }
        }
    }

   
    /**
     * Gets the ArrayList of all lessons
     * 
     * @return The list of all lessons
     */
    public ArrayList<Lesson> getListOfAllLessons() {
        return lessons;
    }

    /**
     * Saves the LessonList
     */
    public void save() {
        DataWriter dataWriter = new DataWriter();
        dataWriter.saveLessons(lessons);
    }

    /**
     * Adds a new Flashcard question to the Review lesson
     * 
     * @param word The word to make a question about
     */
    public void addQuestionToReview(Word word) {
        Question question = new Flashcard(word);
        getLesson("Review Lesson").addQuestion(question);
    }

    /**
     * Adds a new UserTextEntry question to the Review lesson
     * 
     * @param phrase The phrase to make a question about
     */
    public void addQuestionToReview(Phrase phrase) {
        Question question = new UserTextEntry(phrase);
        getLesson("Review Lesson").addQuestion(question);
    }
}
