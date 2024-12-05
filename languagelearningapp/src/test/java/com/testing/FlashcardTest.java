package com.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.model.Flashcard;
import com.model.Word;

/**
 * @author Astha Singh
 */

class FlashcardTest {
    private Flashcard flashcard;
    private Word testWord;

    @BeforeEach
    void setUp() {
        testWord = new Word("gato", "cat", "Animals");
        flashcard = new Flashcard(testWord);
    }

    @Test
    void testGetSpanish() {
        assertEquals("gato", flashcard.getSpanish(), "Spanish text should match the word's Spanish value.");
    }

    @Test
    void testGetCorrectAnswer() {
        assertEquals("cat", flashcard.getCorrectAnswer(), "English translation should match the word's English value.");
    }

    @Test
    void testIsAnswerCorrect() {
        assertTrue(flashcard.isAnswerCorrect("cat"), "Should return true for correct answer.");
        assertFalse(flashcard.isAnswerCorrect("dog"), "Should return false for incorrect answer.");
    }

    @Test
    void testGetTimesReviewed() {
        assertEquals(0, flashcard.getTimesReviewed(), "Initial review count should be zero.");
        flashcard.incrementTimesReviewed();
        assertEquals(1, flashcard.getTimesReviewed(), "Review count should increment by one.");
    }

    @Test
    void testIncrementTimesReviewed() {
        flashcard.incrementTimesReviewed();
        flashcard.incrementTimesReviewed();
        assertEquals(2, flashcard.getTimesReviewed(), "Times reviewed should increment each time.");
    }

    @Test
    void testResetReviewStatus() {
        flashcard.incrementTimesReviewed();
        flashcard.resetReviewStatus();
        assertEquals(0, flashcard.getTimesReviewed(), "Review count should reset to zero.");
    }

    @Test
    void testToString() {
        String expected = "--------------------\nFlashcard\nCategory: Animals\n";
        assertTrue(flashcard.toString().contains(expected), "String representation should match expected format.");
    }

    @Test
    void testGetWordsInQuestion() {
        assertEquals(1, flashcard.getWordsInQuestion().size(), "Should contain only one word.");
        assertEquals(testWord, flashcard.getWordsInQuestion().get(0), "Word should match the original word.");
    }
}
