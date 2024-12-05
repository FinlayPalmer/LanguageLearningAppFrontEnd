package com.testing;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.model.*;

/**
 * @author Matthew Botteon
 * 
 * Tests the methods in the Word class
 */
public class WordTest {
    private Word word;

    @BeforeEach
    void setUp() {
        word = new Word("Hello", "Hola", "Greetings");
    }

    @Test
    void testEditWordWithCorrectParameters() {
        Word testWord = new Word("Goodbye", "Adios", "Greetings");
        word.editWord("Goodbye", "Adios");
        assertEquals(word, testWord);
    }

    @Test
    void testEditWordWithNullText() {
        Word testWord = new Word("Goodbye", "Adios", "Greetings");
        word.editWord(null, "Adios");
        assertEquals(word, testWord);
    }

    @Test
    void testEditWordWithNullTranslation() {
        Word testWord = new Word("Goodbye", "Adios", "Greetings");
        word.editWord("Goodbye", null);
        assertEquals(word, testWord);
    }

    @Test
    void testEditWordWithNullBoth() {
        Word testWord = new Word("Goodbye", "Adios", "Greetings");
        word.editWord(null, null);
        assertEquals(word, testWord);
    }

    @Test
    void testUUIDIsUnique() {
        Word testWord = new Word("Goodbye", "Adios", "Greetings");
        assertNotEquals(word.getUUID(), testWord.getUUID());
    }

    @Test
    void testToStringFormat() {
        String expected = "Hello, Hola, Greetings";
        assertEquals(word.toString(), expected);
    }
}
