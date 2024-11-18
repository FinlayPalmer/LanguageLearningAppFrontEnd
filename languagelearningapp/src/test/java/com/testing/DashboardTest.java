package com.testing;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.model.Dashboard;
import com.model.Account;
import com.model.Word;
import com.model.Phrase;
import com.model.LanguageSection;


import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Astha Singh
 */

class DashboardTest {
    private Dashboard dashboard;
    private Word testWord;
    private Phrase testPhrase;

    @BeforeEach
    void setUp() {
        Account account = new Account("John", "Doe", "john.doe@example.com", "01/01/1990", "johndoe", "password123");
        dashboard = new Dashboard(account);
        testWord = new Word("casa", "house", "basic", UUID.randomUUID());
        testPhrase = new Phrase(new ArrayList<>(List.of("Buenos", "días")), "basic", "Good morning", UUID.randomUUID());
    }

    @Test
    void testGetProgressWithNoCompletedLessons() {
        assertEquals(0, dashboard.getProgress());
    }

    @Test
    void testAddAndRemoveWordToReviewList() {
        dashboard.addWordToReviewList(testWord);
        assertTrue(dashboard.getWordsToReview().contains(testWord));

        dashboard.removeWordFromReviewList(testWord);
        assertFalse(dashboard.getWordsToReview().contains(testWord));
    }

    @Test
    void testAddAndRemovePhraseToReviewList() {
        dashboard.addPhraseToReviewList(testPhrase);
        assertTrue(dashboard.getPhrasesToReview().contains(testPhrase));

        dashboard.removePhraseFromReviewList(testPhrase);
        assertFalse(dashboard.getPhrasesToReview().contains(testPhrase));
    }

    @Test
    void testSetAndGetCurrentSection() {
        LanguageSection newSection = new LanguageSection("Advanced Spanish");
        dashboard.setCurrentSection(newSection);
        assertEquals(newSection, dashboard.getCurrentSection());
    }

    @Test
    void testGetAllSections() {
        ArrayList<LanguageSection> sections = dashboard.getAllSections();
        assertNotNull(sections);
        assertTrue(sections.isEmpty()); 
    }

    @Test
    void testDisplayProgress() {
        assertDoesNotThrow(() -> dashboard.displayProgress());
    }

    @Test
    void testGetLeaderboard() {
        assertNotNull(dashboard.getLeaderboard());
    }
}
