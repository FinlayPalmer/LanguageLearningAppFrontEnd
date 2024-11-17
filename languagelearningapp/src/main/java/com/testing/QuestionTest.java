package com.testing;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * @author Matthew Botteon
 * 
 * Tests the abstract methods in Question and ensures they work with all four question types
 */
public class QuestionTest {
    private Flashcard flashcard;
    private FillInTheBlank fillInTheBlank;
    private Matching matching;
    private UserTextEntry userTextEntry;

    @BeforeEach
    void setup() {
        flashcard = new Flashcard(new Word("Amarillo", "yellow", "Colors"));
        
        ArrayList<String> strings = new ArrayList<>();
        strings.add("El");
        strings.add("escuela");
        strings.add("de");
        strings.add("primaria");
        Phrase phrase = new Phrase(strings, "School", "Elementary school");
        fillInTheBlank = new FillInTheBlank("School", phrase, 3);

        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("Amarillo", "yellow", "Colors"));
        words.add(new Word("Azul", "blue", "Colors"));
        words.add(new Word("Verde", "green", "Colors"));
        words.add(new Word("White", "blanco", "Colors"));
        matching = new Matching("Colors", words);

        userTextEntry = new UserTextEntry(phrase);
    }

    @Test
    void testGetQuestionTextForFlashcard() {
        assertEquals(flashcard.getQuestionText(), "Amarillo");
    }

    @Test
    void testGetQuestionTextForMatching() {
        assertEquals(matching.getQuestionText(), "Amarillo\tyellow\nAzul\tblue\nVerde\tgreen\nWhite\tblanco\n");
    }

    @Test
    void testGetQuestionTextForFillInTheBlank() {
        assertEquals(fillInTheBlank.getQuestionText(), "El escuela de primaria");
    }

    @Test
    void testGetQuestionTextForUserTextEntry() {
        assertEquals(userTextEntry.getQuestionText(), "El escuela de primaria");
    }

    @Test
    void testGetQuestionTypeForFlashcard() {
        assertEquals(flashcard.getQuestionType(), "Flashcard");
    }

    @Test
    void testGetQuestionTypeForMatching() {
        assertEquals(matching.getQuestionType(), "Matching");
    }

    @Test
    void testGetQuestionTypeForFillInTheBlank() {
        assertEquals(fillInTheBlank.getQuestionType(), "Fill In The Blank");
    }

    @Test
    void testGetQuestionTypeForUserTextEntry() {
        assertEquals(userTextEntry.getQuestionType(), "User Text Entry");
    }
}
