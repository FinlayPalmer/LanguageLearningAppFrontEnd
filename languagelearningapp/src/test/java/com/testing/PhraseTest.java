package com.testing;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import com.model.*;

/**
 * @author Matthew Botteon
 * 
 * Tests the methods in the Phrase class
 */
public class PhraseTest {
    private Phrase phrase;
    private Phrase testPhrase;
    private ArrayList<String> text;
    private ArrayList<String> testText;

    @BeforeEach
    void setup() {
        ArrayList<String> text = new ArrayList<String>();
        text.add("Puedo");
        text.add("tomar");
        text.add("fotos");
        phrase = new Phrase(text, "Museum", "Can I take photos");

        ArrayList<String> testText = new ArrayList<String>();
        testText.add("Hay");
        testText.add("tours");
        testText.add("en");
        testText.add("ingles");
        testPhrase = new Phrase(testText, "Museum", "Are there tours in English");
    }

    @Test
    void testEditPhraseWithCorrectParameters() {
        phrase.editPhrase(testText, "Are there tours in English");
        assertEquals(phrase, testPhrase);

    }

    @Test
    void testEditPhraseWithNullList() {
        phrase.editPhrase(null, "Are there tours in English");
        assertEquals(phrase, testPhrase);
    }

    @Test
    void testEditPhraseWithNullTranslation() {
        phrase.editPhrase(testText, null);
        assertEquals(phrase, testPhrase);
    }

    @Test
    void testEditPhraseWithEmptyList() {
        testText = new ArrayList<>();
        phrase.editPhrase(testText, "Are there tours in English");
        assertEquals(phrase, testPhrase);
    }

    @Test
    void testToStringOutput() {
        String expected = "Puedo tomar fotos";
        assertEquals(expected, phrase.toString());
    }
}
