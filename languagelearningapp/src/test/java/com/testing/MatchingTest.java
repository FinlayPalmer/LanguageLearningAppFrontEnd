package com.testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import com.model.*;

/**
 * @author Astha Singh
 */
class MatchingTest {
    private Matching matchingQuestion;
    private ArrayList<Word> spanishWords;

    @BeforeEach
    void setUp() {
        spanishWords = new ArrayList<>();
        spanishWords.add(new Word("Hola", "Hello", "Greeting", null));
        spanishWords.add(new Word("Adios", "Goodbye", "Farewell", null));
        spanishWords.add(new Word("Gracias", "Thank you", "Gratitude", null));

        matchingQuestion = new Matching("Basic Spanish Greetings", spanishWords);
    }

    @Test
    void testGetTitle() {
        assertEquals("Basic Spanish Greetings", matchingQuestion.getTitle(), "Title should match the initial title set.");
    }

    @Test
    void testGetSpanishWords() {
        assertEquals(spanishWords, matchingQuestion.getSpanishWords(), "Spanish words should match the initial list of words.");
    }

    @Test
    void testGetCorrectMatches() {
        ArrayList<String> expectedMatches = new ArrayList<>();
        expectedMatches.add("Hello");
        expectedMatches.add("Goodbye");
        expectedMatches.add("Thank you");

        assertEquals(expectedMatches, matchingQuestion.getCorrectMatches(), "Correct matches should be in order of Spanish words' translations.");
    }

    @Test
    void testGetOptions() {
        assertTrue(matchingQuestion.getOptions().containsAll(matchingQuestion.getCorrectMatches()), "Options should contain all correct matches.");
    }

    @Test
    void testSetUserMatch() {
        matchingQuestion.setUserMatch(spanishWords.get(0), "Hello");
        matchingQuestion.setUserMatch(spanishWords.get(1), "Goodbye");
        matchingQuestion.setUserMatch(spanishWords.get(2), "Thank you");

        assertEquals("Hello", matchingQuestion.getUserMatches().get(0), "User match for 'Hola' should be 'Hello'.");
        assertEquals("Goodbye", matchingQuestion.getUserMatches().get(1), "User match for 'Adios' should be 'Goodbye'.");
        assertEquals("Thank you", matchingQuestion.getUserMatches().get(2), "User match for 'Gracias' should be 'Thank you'.");
    }

    @Test
    void testIsAnswerCorrect() {
        matchingQuestion.setUserMatch(spanishWords.get(0), "Hello");
        matchingQuestion.setUserMatch(spanishWords.get(1), "Goodbye");
        matchingQuestion.setUserMatch(spanishWords.get(2), "Thank you");

        assertTrue(matchingQuestion.isAnswerCorrect("Hello Goodbye Thank you"), "The answer should be correct when all matches are right.");
    }

    @Test
    void testIsAnswerIncorrect() {
        matchingQuestion.setUserMatch(spanishWords.get(0), "Goodbye");
        matchingQuestion.setUserMatch(spanishWords.get(1), "Hello");
        matchingQuestion.setUserMatch(spanishWords.get(2), "Please");

        assertFalse(matchingQuestion.isAnswerCorrect("Goodbye Hello Please"), "The answer should be incorrect when matches do not align correctly.");
    }

    @Test
    void testGetQuestionText() {
        String questionText = matchingQuestion.getQuestionText();
        assertNotNull(questionText, "Question text should not be null.");
        assertTrue(questionText.contains("Hola") && questionText.contains("Adios") && questionText.contains("Gracias"),
                   "Question text should contain all Spanish words.");
    }

    @Test
    void testGetCorrectAnswer() {
        String correctAnswer = matchingQuestion.getCorrectAnswer();
        assertNotNull(correctAnswer, "Correct answer text should not be null.");
        assertTrue(correctAnswer.contains("Hello") && correctAnswer.contains("Goodbye") && correctAnswer.contains("Thank you"),
                   "Correct answer text should contain all correct matches.");
    }
}
