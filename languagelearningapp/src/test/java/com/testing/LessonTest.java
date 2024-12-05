package com.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;
import com.model.*;

/**
 * @author Astha Singh
 */

public class LessonTest {

    private Lesson lesson;
    private Flashcard flashcard;
    private Matching matchingQuestion;
    private FillInTheBlank fillInTheBlank;
    private UserTextEntry userTextEntry;

    @BeforeEach
    public void setUp() {
        Word word = new Word("perro", "dog", "animals");
        flashcard = new Flashcard(word);
        
        ArrayList<Word> matchingWords = new ArrayList<>();
        matchingWords.add(new Word("gato", "cat", "animals"));
        matchingWords.add(new Word("casa", "house", "objects"));
        matchingQuestion = new Matching("Match animals", matchingWords);
        
        Phrase phrase = new Phrase(new ArrayList<>(List.of("Me", "gusta", "correr")), "activities", "I like to run");
        fillInTheBlank = new FillInTheBlank("Activities", phrase, 1);
        userTextEntry = new UserTextEntry(phrase);

        ArrayList<Question> questions = new ArrayList<>();
        questions.add(flashcard);
        questions.add(matchingQuestion);
        questions.add(fillInTheBlank);
        questions.add(userTextEntry);

        lesson = new Lesson("Spanish Basics", questions, null);
    }

    @Test
    public void testLessonTitle() {
        assertEquals("Spanish Basics", lesson.getTitle(), "Lesson title should match the one set in setup.");
    }

    @Test
    public void testLessonQuestions() {
        assertEquals(4, lesson.getQuestions().size(), "Lesson should contain 4 questions.");
    }

    @Test
    public void testGetCurrentQuestion() {
        assertEquals(flashcard, lesson.getCurrentQuestion(), "Current question should initially be the first question (flashcard).");
    }

    @Test
    public void testMoveToNextQuestion() {
        lesson.moveToNextQuestion();
        assertEquals(matchingQuestion, lesson.getCurrentQuestion(), "After moving to the next question, it should be the matching question.");
        
        lesson.moveToNextQuestion();
        assertEquals(fillInTheBlank, lesson.getCurrentQuestion(), "After moving to the next question, it should be the fill-in-the-blank question.");
    }

    @Test
    public void testMoveToPrevQuestion() {
        lesson.moveToNextQuestion();
        lesson.moveToNextQuestion();
        lesson.moveToPrevQuestion();
        assertEquals(matchingQuestion, lesson.getCurrentQuestion(), "After moving back, it should be the matching question.");
    }

    @Test
    public void testStartLesson() {
        lesson.startLesson();
        assertEquals(flashcard, lesson.getCurrentQuestion(), "Starting the lesson should set the current question to the first question.");
    }

    @Test
    public void testEndLesson() {
        String endMessage = lesson.endLesson();
        assertTrue(lesson.getLessonComplete(), "Lesson should be marked complete after ending.");
        assertEquals("Ending lesson: Spanish Basics", endMessage, "End message should match expected format.");
    }

    @Test
    public void testUpdateScore() {
        lesson.updateScore();
        assertEquals(1, lesson.getUserScoreCount(), "Score should be updated to 1 after calling updateScore once.");
        
        lesson.updateScore();
        assertEquals(2, lesson.getUserScoreCount(), "Score should be updated to 2 after calling updateScore twice.");
    }

    @Test
    public void testGetUserScore() {
        lesson.updateScore();
        lesson.moveToNextQuestion();
        lesson.updateScore();
        assertEquals("Your score: 2/2", lesson.getUserScore(), "User score should display correctly with the number of correct answers and total attempts.");
    }

    @Test
    public void testGetStoryContent() {
        assertEquals("No content available", lesson.getStoryContent(), "Lesson should return 'No content available' if there is no story.");
    }

    @Test
    public void testLessonToString() {
        assertEquals("Lesson Title: Spanish Basics", lesson.toString(), "Lesson toString() should return the formatted lesson title.");
    }
}
