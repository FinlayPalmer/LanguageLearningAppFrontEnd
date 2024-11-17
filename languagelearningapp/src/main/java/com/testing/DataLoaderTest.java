package com.testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.model.*;

import java.util.ArrayList;
import java.util.UUID;
/**
 * @author Astha Singh
 */
class DataLoaderTest {
    private DataLoader dataLoader;

    @BeforeEach()
    void setUp() {
        dataLoader = DataLoader.getInstance();
    }

    @Test
    void testGetAccounts() {
        ArrayList<Account> accounts = dataLoader.getAccounts();
        assertNotNull(accounts, "Accounts should not be null");
        assertFalse(accounts.isEmpty(), "Accounts list should not be empty");
        
        Account account = accounts.get(0);
        assertNotNull(account.getFirstName(), "Account's first name should not be null");
        assertNotNull(account.getLastName(), "Account's last name should not be null");
        assertNotNull(account.getEmail(), "Account's email should not be null");
        assertNotNull(account.getUsername(), "Account's username should not be null");
    }

    @Test
    void testGetWords() {
        ArrayList<Word> words = dataLoader.getWords();
        assertNotNull(words, "Words should not be null");
        assertFalse(words.isEmpty(), "Words list should not be empty");
        
        Word word = words.get(0);
        assertNotNull(word.getWordText(), "Word text should not be null");
        assertNotNull(word.getTranslation(), "Word translation should not be null");
        assertNotNull(word.getCategory(), "Word category should not be null");
    }

    @Test
    void testGetPhrases() {
        ArrayList<Phrase> phrases = dataLoader.getPhrases();
        assertNotNull(phrases, "Phrases should not be null");
        assertFalse(phrases.isEmpty(), "Phrases list should not be empty");
        
        Phrase phrase = phrases.get(0);
        assertNotNull(phrase.getPhraseText(), "Phrase text should not be null");
        assertNotNull(phrase.getTranslation(), "Phrase translation should not be null");
        assertNotNull(phrase.getCategory(), "Phrase category should not be null");
    }

    @Test
    void testGetLessons() {
        ArrayList<Lesson> lessons = dataLoader.getLessons();
        assertNotNull(lessons, "Lessons should not be null");
        assertFalse(lessons.isEmpty(), "Lessons list should not be empty");

        Lesson lesson = lessons.get(0);
        assertNotNull(lesson.getTitle(), "Lesson title should not be null");
        assertNotNull(lesson.getQuestions(), "Lesson questions should not be null");
    }

    @Test
    void testCreateFlashcard() {
        ArrayList<Word> words = dataLoader.getWords();
        assertFalse(words.isEmpty(), "Words list should not be empty for testing Flashcard creation");

        Flashcard flashcard = dataLoader.createFlashcard(words.get(0).getCategory(), 0);
        assertNotNull(flashcard, "Flashcard should not be null");
        assertEquals("Flashcard", flashcard.getQuestionType(), "Flashcard type should be 'Flashcard'");
    }

    @Test
    void testCreateMatching() {
        ArrayList<Word> words = dataLoader.getWords();
        assertFalse(words.isEmpty(), "Words list should not be empty for testing Matching creation");

        Matching matching = dataLoader.createMatching(words.get(0).getCategory(), 3, 0);
        assertNotNull(matching, "Matching should not be null");
        assertEquals("Matching", matching.getQuestionType(), "Matching type should be 'Matching'");
    }

    @Test
    void testCreateFillInTheBlank() {
        ArrayList<Phrase> phrases = dataLoader.getPhrases();
        assertFalse(phrases.isEmpty(), "Phrases list should not be empty for testing FillInTheBlank creation");

        FillInTheBlank fillInTheBlank = dataLoader.createFillInTheBlank(phrases.get(0).getCategory(), 0);
        assertNotNull(fillInTheBlank, "FillInTheBlank should not be null");
        assertEquals("Fill In The Blank", fillInTheBlank.getQuestionType(), "Question type should be 'Fill In The Blank'");
    }

    @Test
    void testCreateUserTextEntry() {
        ArrayList<Phrase> phrases = dataLoader.getPhrases();
        assertFalse(phrases.isEmpty(), "Phrases list should not be empty for testing UserTextEntry creation");

        UserTextEntry userTextEntry = dataLoader.createUserTextEntry(phrases.get(0).getCategory(), 0);
        assertNotNull(userTextEntry, "UserTextEntry should not be null");
        assertEquals("User Text Entry", userTextEntry.getQuestionType(), "Question type should be 'User Text Entry'");
    }

    @Test
    void testAddQuestionsToLessons() {
        ArrayList<Question> questions = dataLoader.addQuestionsToLessons("Colors");
        assertNotNull(questions, "Questions should not be null");
        assertFalse(questions.isEmpty(), "Questions list should not be empty");
        
        Question question = questions.get(0);
        assertNotNull(question.getTitle(), "Question title should not be null");
        assertNotNull(question.getQuestionType(), "Question type should not be null");
    }
}
