package com.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Astha Singh
*/
class UserTextEntryTest {
    private UserTextEntry userTextEntry;
    private Phrase testPhrase;

    @BeforeEach
    void setUp() {
        ArrayList<String> spanishText = new ArrayList<>();
        spanishText.add("¿Cómo");
        spanishText.add("estás?");
        
        testPhrase = new Phrase(spanishText, "Greetings", "How are you?");
        userTextEntry = new UserTextEntry(testPhrase);
    }

    @Test
    void testGetTitle() {
        assertEquals("Greetings", userTextEntry.getTitle(), "Title should match the category of the phrase.");
    }

    @Test
    void testGetQuestionText() {
        String expectedText = "¿Cómo estás?";
        assertEquals(expectedText, userTextEntry.getQuestionText(), "The question text should match the phrase text.");
    }

    @Test
    void testGetCorrectAnswer() {
        assertEquals("How are you?", userTextEntry.getCorrectAnswer(), "Correct answer should match the translation of the phrase.");
    }

    @Test
    void testSetAndGetUserAnswer() {
        userTextEntry.setUserAnswer("How are you?");
        assertEquals("How are you?", userTextEntry.getUserAnswer(), "User answer should match the answer that was set.");
    }

    @Test
    void testIsAnswerCorrect() {
        assertTrue(userTextEntry.isAnswerCorrect("How are you?"), "Answer should be correct when it matches the translation.");
        assertFalse(userTextEntry.isAnswerCorrect("I'm fine"), "Answer should be incorrect when it doesn't match the translation.");
    }

    @Test
    void testSetQuestionText() {
        ArrayList<String> newPhraseText = new ArrayList<>();
        newPhraseText.add("Buenos");
        newPhraseText.add("días");
        
        Phrase newPhrase = new Phrase(newPhraseText, "Greetings", "Good morning");
        userTextEntry.setQuestionText(newPhrase);
        
        assertEquals("Buenos días", userTextEntry.getQuestionText(), "Question text should be updated to the new phrase text.");
        assertEquals("Good morning", userTextEntry.getCorrectAnswer(), "Correct answer should be updated to match the new phrase translation.");
    }

    @Test
    void testGetQuestionType() {
        assertEquals("User Text Entry", userTextEntry.getQuestionType(), "Question type should be 'User Text Entry'.");
    }

    @Test
    void testToString() {
        String expectedString = "--------------------\nUser Text Entry\nCategory: Greetings\nTranslate the following phrase into English:\n¿Cómo estás?";
        assertEquals(expectedString, userTextEntry.toString(), "toString output should match the expected format.");
    }

    @Test
    void testGetWordsInQuestion() {
        assertTrue(userTextEntry.getWordsInQuestion().isEmpty(), "Words in question should return an empty list for UserTextEntry.");
    }

    @Test
    void testGetPhraseInQuestion() {
        assertEquals(testPhrase, userTextEntry.getPhraseInQuestion(), "Phrase in question should match the initialized phrase.");
    }
}
