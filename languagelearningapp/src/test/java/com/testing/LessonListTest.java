package com.testing;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import com.model.*;

/**
 * @author Matthew Botteon
 * 
 * Tests the methods in the LessonList class
 */
public class LessonListTest {
    private LessonList lessonList;
    private ArrayList<Question> questions;
    private HashMap<Integer, String> content;
    private Story story;

    @BeforeEach
    void setup() {
        lessonList = LessonList.getInstance();
        // Create list of questions
        Question a = new Flashcard(new Word("Amarillo", "Yellow", "Colors"));
        Question b = new Flashcard(new Word("Naranja", "Orange", "Colors"));
        Question c = new Flashcard(new Word("Azul", "Blue", "Colors"));
        questions.add(a);
        questions.add(b);
        questions.add(c);
        // Create Hashmap of content
        String one = "This is the content on page one of the story";
        String two = "This is the content on page two of the story";
        String three = "This is the content on page three of the story";
        content.put(1, one);
        content.put(2, two);
        content.put(3, three);
        Story story = new Story("Story", content);
        lessonList.addLesson("Colors", questions, story);
    }

    @Test
    void testAddLessonWithCorrectCredentials() {
        Lesson testLesson = new Lesson("Colors", questions, story);
        lessonList.addLesson("Colors", questions, story);
        assertEquals(testLesson, lessonList.getListOfAllLessons().get(lessonList.getListOfAllLessons().size() - 1));
    }

    @Test
    void testAddLessonWithNullTitle() {
        Lesson testLesson = new Lesson(null, questions, story);
        lessonList.addLesson(null, questions, story);
        assertEquals(testLesson, lessonList.getListOfAllLessons().get(lessonList.getListOfAllLessons().size() - 1));
    }

    @Test
    void testAddLessonWithNullList() {
        Lesson testLesson = new Lesson("Colors", null, story);
        lessonList.addLesson("Colors", null, story);
        assertEquals(testLesson, lessonList.getListOfAllLessons().get(lessonList.getListOfAllLessons().size() - 1));
    }

    @Test
    void testAddLessonWithEmptyList() {
        questions = new ArrayList<Question>();
        Lesson testLesson = new Lesson("Colors", questions, story);
        lessonList.addLesson("Colors", questions, story);
        assertEquals(testLesson, lessonList.getListOfAllLessons().get(lessonList.getListOfAllLessons().size() - 1));
    }

    @Test
    void testAddLessonWithNullStory() {
        Lesson testLesson = new Lesson("Colors", questions, null);
        lessonList.addLesson("Colors", questions, null);
        assertEquals(testLesson, lessonList.getListOfAllLessons().get(lessonList.getListOfAllLessons().size() - 1));
    }

    @Test
    void testGetLessonWithCorrectTitle() {
        Lesson methodResult = lessonList.getLesson("Colors");
        assertEquals(methodResult, new Lesson("Colors", questions, story));
    }

    @Test
    void testGetLessonWithNullTitle() {
        lessonList.addLesson(null, questions, story);
        Lesson methodResult = lessonList.getLesson(null);
        assertEquals(methodResult, new Lesson(null, questions, story));
    }

    @Test
    void testEditLessonWithCorrectTitle() {
        ArrayList<Question> newQuestions = new ArrayList<>();
        Question a = new Flashcard(new Word("madre", "mother", "Family"));
        Question b = new Flashcard(new Word("padre", "father", "Family"));
        Question c = new Flashcard(new Word("hermano", "brother", "Family"));
        newQuestions.add(a);
        newQuestions.add(b);
        newQuestions.add(c);
        lessonList.editLesson("Colors", newQuestions);
        Lesson methodResult = lessonList.getLesson("Colors");
        assertEquals(methodResult, new Lesson("Colors", newQuestions, story));
    }

    @Test
    void testEditLessonWithNullTitle() {
        lessonList.addLesson(null, questions, story);
        ArrayList<Question> newQuestions = new ArrayList<>();
        Question a = new Flashcard(new Word("madre", "mother", "Family"));
        Question b = new Flashcard(new Word("padre", "father", "Family"));
        Question c = new Flashcard(new Word("hermano", "brother", "Family"));
        newQuestions.add(a);
        newQuestions.add(b);
        newQuestions.add(c);
        lessonList.editLesson(null, newQuestions);
        Lesson methodResult = lessonList.getLesson(null);
        assertEquals(methodResult, new Lesson(null, newQuestions, story));
    }

    @Test
    void testEditLessonWithNullList() {
        lessonList.editLesson("Colors", null);
        Lesson methodResult = lessonList.getLesson("Colors");
        assertEquals(methodResult, new Lesson("Colors", null, story));
    }

    @Test
    void testEditLessonWithEmptyList() {
        ArrayList<Question> newQuestions = new ArrayList<>();
        lessonList.editLesson("Colors", newQuestions);
        Lesson methodResult = lessonList.getLesson("Colors");
        assertEquals(methodResult, new Lesson("Colors", newQuestions, story));
    }

    @Test
    void testAddQuestionToReviewValidWord() {
        Word word = new Word("Amarillo", "yellow", "Colors");
        lessonList.addQuestionToReview(word);
        assertTrue(lessonList.getLesson("Review Lesson").getQuestions().get(0) != null);
    }

    @Test
    void testAddQuestionToReviewNullWord() {
        Word word = new Word(null, null, null);
        lessonList.addQuestionToReview(word);
        assertTrue(lessonList.getLesson("Review Lesson").getQuestions().get(0) == null);
    }

    @Test
    void testAddQuestionToReviewValidPhrase() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Donde");
        strings.add("esta");
        strings.add("el");
        strings.add("mapa");
        Phrase phrase = new Phrase(strings, "Museum", "Where is the map");
        lessonList.addQuestionToReview(phrase);
        assertTrue(lessonList.getLesson("Review Lesson").getQuestions().get(0) != null);
    }

    @Test
    void testAddQuestionToReviewNullPhrase() {
        Phrase phrase = new Phrase(null, null, null);
        lessonList.addQuestionToReview(phrase);
        assertTrue(lessonList.getLesson("Review Lesson").getQuestions().get(0) == null);
    }
}
