package com.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.model.FillInTheBlank;
import com.model.Phrase;

import java.util.ArrayList;
/**
 * @author Astha Singh
 */

class FillInTheBlankTest {
    private FillInTheBlank fillInTheBlank;
    private Phrase phrase;

    @BeforeEach
    void setUp() {
        ArrayList<String> phraseText = new ArrayList<>();
        phraseText.add("Esta");
        phraseText.add("es");
        phraseText.add("una");
        phraseText.add("prueba");
        
        phrase = new Phrase(phraseText, "Example Category", "This is a test");
        fillInTheBlank = new FillInTheBlank("Example Question", phrase, 2);
    }

    @Test
    void testGetTitle() {
        assertEquals("Example Question", fillInTheBlank.getTitle(), "Title should be 'Example Question'");
    }

    @Test
    void testGetQuestionText() {
        String expectedText = "Esta es _______ prueba";
        assertEquals(expectedText, fillInTheBlank.getQuestionText(), "The question text should contain a blank at the correct position.");
    }

    @Test
    void testGetCorrectAnswer() {
        assertEquals("una", fillInTheBlank.getCorrectAnswer(), "The correct answer should be 'una'.");
    }

    @Test
    void testGetQuestionType() {
        assertEquals("Fill In The Blank", fillInTheBlank.getQuestionType(), "Question type should be 'Fill In The Blank'");
    }

    @Test
    void testIsAnswerCorrect() {
        assertTrue(fillInTheBlank.isAnswerCorrect("una"), "Answer 'una' should be correct.");
        assertFalse(fillInTheBlank.isAnswerCorrect("incorrect"), "Answer 'incorrect' should be incorrect.");
    }

    @Test
    void testSetUserAnswer() {
        fillInTheBlank.setUserAnswer("una");
        assertEquals("una", fillInTheBlank.getCorrectAnswer(), "User answer should match the correct answer.");
    }

    @Test
    void testSetBlankPosition() {
        fillInTheBlank.setBlankPosition(3);
        assertEquals(3, fillInTheBlank.getBlankPosition(), "Blank position should be updated to 3");
        assertEquals("prueba", fillInTheBlank.getCorrectAnswer(), "The correct answer should be 'prueba' after updating the blank position.");
    }

    @Test
    void testToString() {
        String expectedString = "--------------------\nFill In The Blank\nEnglish Meaning: Example Question\nEsta es _______ prueba ";
        assertEquals(expectedString, fillInTheBlank.toString(), "The toString output should display the question text with a blank.");
    }

    @Test
    void testInvalidBlankPosition() {
        fillInTheBlank.setBlankPosition(-1);
        assertEquals("Invalid question. Blank position could not be determined.", fillInTheBlank.getQuestionText(), "Invalid blank position should return an error message.");

        fillInTheBlank.setBlankPosition(10); 
        assertEquals("Invalid question. Blank position could not be determined.", fillInTheBlank.getQuestionText(), "Invalid blank position should return an error message.");
    }

    @Test
    void testGetWordsInQuestion() {
        assertEquals(0, fillInTheBlank.getWordsInQuestion().size(), "Expected an empty list of words for FillInTheBlank.");
    }
}
