package com.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Astha Singh
 */

class LanguageSectionTest {
    private LanguageSection languageSection;
    private Lesson lesson1;
    private Lesson lesson2;
    private Word word1;
    private Word word2;

    @BeforeEach
    void setUp() {
        languageSection = new LanguageSection("Spanish");
        lesson1 = new Lesson("Lesson 1", new ArrayList<>(), null);
        lesson2 = new Lesson("Lesson 2", new ArrayList<>(), null);
        word1 = new Word("hola", "hello", "Greetings");
        word2 = new Word("adios", "goodbye", "Farewell");
    }

    @Test
    void testGetLanguage() {
        assertEquals("Spanish", languageSection.getLanguage(), "Language should match the initialized value.");
    }

    @Test
    void testAddAndRemoveLesson() {
        languageSection.addLesson(lesson1);
        assertTrue(languageSection.getLessons().contains(lesson1), "Lesson 1 should be added to lessons.");

        languageSection.removeLesson(lesson1);
        assertFalse(languageSection.getLessons().contains(lesson1), "Lesson 1 should be removed from lessons.");
    }

    @Test
    void testAddLessons() {
        ArrayList<Lesson> newLessons = new ArrayList<>();
        newLessons.add(lesson1);
        newLessons.add(lesson2);
        languageSection.addLessons(newLessons);

        assertTrue(languageSection.getLessons().contains(lesson1), "Lesson 1 should be added.");
        assertTrue(languageSection.getLessons().contains(lesson2), "Lesson 2 should be added.");
    }

    @Test
    void testSetAndGetWelcomeMessage() {
        String welcomeMessage = "Welcome to Spanish 101!";
        languageSection.setWelcomeMessage(welcomeMessage);
        assertEquals(welcomeMessage, languageSection.getWelcomeMessage(), "Welcome message should match the set value.");
    }

    @Test
    void testGetDailyWord() {
        Set<String> possibleWords = new HashSet<>();
        possibleWords.add("hola");
        possibleWords.add("adios");

        String dailyWord = languageSection.getDailyWord();
        assertTrue(possibleWords.contains(dailyWord), "Daily word should be one of the possible daily words.");
    }

    @Test
    void testAddCompletedLesson() {
        languageSection.addCompletedLesson(lesson1);
        assertTrue(languageSection.getCompletedLessons().contains(lesson1), "Lesson 1 should be added to completed lessons.");
    }

    @Test
    void testAddStartedLesson() {
        languageSection.addStartedLesson(lesson1);
        assertTrue(languageSection.getStartedLessons().contains(lesson1), "Lesson 1 should be added to started lessons.");
    }

    @Test
    void testCompletedLessonNotAddedToStarted() {
        languageSection.addCompletedLesson(lesson1);
        languageSection.addStartedLesson(lesson1);
        assertFalse(languageSection.getStartedLessons().contains(lesson1), "Completed lesson should not be added to started lessons.");
    }

    @Test
    void testSetLessons() {
        ArrayList<Lesson> initialLessons = new ArrayList<>();
        initialLessons.add(lesson1);
        languageSection.setLessons(initialLessons);

        assertEquals(1, languageSection.getLessons().size(), "Lessons should be set to the initial lessons.");
        assertTrue(languageSection.getLessons().contains(lesson1), "Lesson 1 should be in the list of lessons.");
    }
}
