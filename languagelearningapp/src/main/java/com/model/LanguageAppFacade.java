package com.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.narration.*;

/**
 * Creates a new LanguageAppFacade
 * 
 * @author Finlay Palmer
 */
public class LanguageAppFacade {
    private Account account;
    private static LanguageAppFacade languageAppFacade;
    private Lesson currentLesson;

    /**
     * Creates a new LanguageAppFacade
     */
    private LanguageAppFacade() {
        account = new Account(null);
        currentLesson = LessonList.getInstance().getListOfAllLessons().get(0);
    }

    /**
     * Returns the LanguageAppFacade instance
     * 
     * @return languageAppFacade
     */
    public static LanguageAppFacade getInstance() {
        if (languageAppFacade == null) {
            languageAppFacade = new LanguageAppFacade();
        }
        return languageAppFacade;
    }

    /**
     * Allows user to login
     * 
     * @param username User's username
     * @param password User's password
     * @return The account user logs into, null if their account did not exist
     */
    public Account login(String username, String password) {
        AccountList accountList = AccountList.getInstance();
        if (accountList.getAccount(username, password) != null
                && accountList.getAccount(username, password).isMatch(username, password)) {
            account = accountList.getAccount(username, password);
            // Return a welcome message and the account details if their account is valid
            return /*"You have successfully logged in!" + */ account;
        }
        // Set current account to null and print an error message if their account was
        // not valid
        account = null;
        return /* "Your account was not able to be verified."*/ null;
    }

    /**
     * Allows user to logout
     */
    public String logout() {
        account = null;
        AccountList.getInstance().save();
        return "Logout successful!";
    }

    /**
     * Allows user to sign up
     * 
     * @param firstName   User's first name
     * @param lastName    User's last name
     * @param email       User's email
     * @param dateOfBirth User's date of birth
     * @param username    User's username
     * @param password    User's password
     * @return The account user signs up for
     */
    public String signUp(String firstName, String lastName, String email, String dateOfBirth, String username,
            String password) {
        AccountList accountList = AccountList.getInstance();
        account = accountList.addAccount(firstName, lastName, email, dateOfBirth, username, password);
        if (account == null) {
            // Return error message if account was not added correctly
            return "Please ensure your email or username is unique";
        }
        // Save updated account list to JSON
        accountList.save();
        // Return welcome message if account was added correctly
        return "Success! Welcome " + account.getFirstName() + " " + account.getLastName();
    }

    /**
     * Returns the current account's details as an ArrayList of Strings
     * 
     * @return The current account's details
     */
    public ArrayList<String> viewAccountDetails() {
        ArrayList<String> accountDetails = new ArrayList<String>();
        if (account != null) {
            accountDetails.add(account.getFirstName());
            accountDetails.add(account.getLastName());
            accountDetails.add(account.getEmail());
            accountDetails.add(account.getDateOfBirth());
            accountDetails.add(account.getUsername());
            accountDetails.add(account.getPassword());
            accountDetails.add(account.getAccountID().toString());
            accountDetails.add(account.getSkillLevel().label);
        }
        return accountDetails;
    }

    /**
     * Allows user to take a skill level test
     */
    public void takeSkillLevelTest() {
        SkillLevelTest skillLevelTest = new SkillLevelTest();
    }

    /**
     * Returns the current account's Dashboard
     * 
     * @return The current account's Dashboard
     */
    public String viewDashboard() {
        String dashboardInfo = "\n-------------------------\n Your Dashboard:\n";
        Dashboard currentDashboard = account.getDashboard();
        dashboardInfo += "Current Lesson: " + currentLesson.getTitle() + "\n";
        dashboardInfo += "Percentage through the section: " + currentDashboard.getProgress() + "%\n";
        dashboardInfo += "Words to review: \n";
        for (Word word : currentDashboard.getWordsToReview()) {
            dashboardInfo += word.getWordText() + "\n";
        }
        dashboardInfo += "Phrases to review: \n";
        for (Phrase phrase : currentDashboard.getPhrasesToReview()) {
            for (String text : phrase.getPhraseText()) {
                dashboardInfo += text + " ";
            }
            dashboardInfo += "\n";
        }
        return dashboardInfo;
    }

    /**
     * Returns the current account's Leaderboard
     * 
     * @return The current account's Leaderboard
     */
    public Leaderboard viewLeaderboard() {
        Leaderboard leaderboard = Leaderboard.getInstance();
        return leaderboard;
    }

    /**
     * Return the current account's LanguageSection
     * 
     * @return The current account's LanguageSection
     */
    public LanguageSection getLanguageSection() {
        return account.getDashboard().getCurrentSection();
    }

    /**
     * Returns the current lesson that is being worked on
     * 
     * @return The current lesson
     */
    public Lesson getLesson() {
        return currentLesson;
    }

    /**
     * Returns the available lessons as a String format for the user to pick from
     * 
     * @return The list of available lessons for the user to pick from
     */
    public String getLessonChoices() {
        String string = "Choose one of the following lessons to begin: ";
        for (Lesson lesson : LessonList.getInstance().getListOfAllLessons())
            string += "\n" + lesson;
        return string;
    }

    /**
     * Starts a new lesson from LessonList
     * 
     * @param lessonName The name of the lesson to start
     * @return The lesson with the given name
     */
    public Question startNewLesson(String lessonName) {
        if (getLanguageSection() == null) {
            LanguageSection section = new LanguageSection("Spanish");
            account.getDashboard().setCurrentSection(section);
        }
        LessonList lessonList = LessonList.getInstance();
        currentLesson = lessonList.getLesson(lessonName);
        Question currentQuestion = currentLesson.startLesson();
        if (currentQuestion != null) {
            Narrator.playSound(currentQuestion.getQuestionText());
            return currentQuestion;
        }
        return null;
    }

    /**
     * Ends the current lesson by adding it to the list of completed lessons
     * 
     * @return A message alerting the user to the lesson's completion
     */
    public String endLesson() {
        if (currentLesson != null && !currentLesson.getLessonComplete()) {
            currentLesson.endLesson();
            if (getLanguageSection() == null) {
                LanguageSection section = new LanguageSection("Spanish");
                account.getDashboard().setCurrentSection(section);
            }
            getLanguageSection().addCompletedLesson(currentLesson);
            return "End of lesson: " + currentLesson.getTitle();
        }
        return "No active lesson to end.";
    }

    /**
     * Resumes a lesson that has already been started
     * 
     * @param lessonName The name of the lesson to resume
     * @return The lesson with the given name
     */
    public Question resumeLesson(String lessonName) {
        // Gets the list of lessons the user has already started
        ArrayList<Lesson> startedLessons = account.getDashboard().getCurrentSection().getStartedLessons();
        for (Lesson lesson : startedLessons) {
            // Iterates over them looking for a match
            if (lesson.getTitle().equals(lessonName)) {
                currentLesson = lesson;
                return lesson.getCurrentQuestion();
            }
            // If no lesson is found in the user's started lessons, a new lesson is started
        }
        LessonList lessonList = LessonList.getInstance();
        return lessonList.getLesson(lessonName).startLesson();
    }

    /**
     * Pauses current lesson by adding it to started lessons list
     */
    public void pauseLesson() {
        account.getDashboard().getCurrentSection().addStartedLesson(currentLesson);
        LessonList.getInstance().save();
    }

    /**
     * Gets a Question from currentLesson via question number
     * 
     * @param questionNumber The number of the question to get
     * @return The question at that position
     */
    public Question getQuestion(int questionNumber) {
        if (questionNumber > 0 && questionNumber < currentLesson.getQuestions().size() + 1)
            return currentLesson.getQuestions().get(questionNumber - 1);
        else
            return null;
    }

    /**
     * Gets the current Question from currentLesson
     * 
     * @return The the current question in the current lesson
     */
    public Question getQuestion() {
        if (!currentLesson.getLessonComplete()) {
            return currentLesson.getCurrentQuestion(); // Return the actual Question object
        }
        return null;
    }

    /**
     * Gets the next Question in currentLesson
     * 
     * @return The next Question in currentLesson
     */
    public Question nextQuestion() {
        currentLesson.moveToNextQuestion();
        Question nextQuestion = getQuestion();
        if (nextQuestion != null) {
            Narrator.playSound(nextQuestion.getQuestionText());
            return nextQuestion;
        }
        return null;
    }

    /**
     * Gets the previous Question in currentLesson
     * 
     * @return The previous Question in currentLesson
     */
    public Question previousQuestion() {
        currentLesson.moveToPrevQuestion();
        return getQuestion();
    }

    /**
     * Allows the user to answer a question
     * 
     * @param answer The user's answer
     * @return True if the user's answer is correct, false otherwise
     */
    public boolean answerQuestion(String answer) {
        boolean answerStatus = answer != null && currentLesson.getCurrentQuestion().isAnswerCorrect(answer);
        if (answerStatus) {
            // If they get it right in Review Lesson, it should be removed from their list
            if (currentLesson.getTitle().equals("Review Lesson")) {
                if (currentLesson.getCurrentQuestion().getQuestionType().equals("Flashcard") ||
                    currentLesson.getCurrentQuestion().getQuestionType().equals("Matching")) {
                    for (Word word : currentLesson.getCurrentQuestion().getWordsInQuestion())
                        account.getDashboard().removeWordFromReviewList(word);
                } else {
                // Means it is a Phrase based question, remove the phrase from the list
                account.getDashboard().removePhraseFromReviewList(currentLesson.getCurrentQuestion().getPhraseInQuestion());
                }
            }
            currentLesson.updateScore();
            return true;
        } else {
            // If the question is of type Flashcard or Matching and the answer was
            // incorrect,
            // the associated word(s) are added to the account's list of words to review on
            // the dashboard
            if (currentLesson.getCurrentQuestion().getQuestionType().equals("Flashcard") ||
                    currentLesson.getCurrentQuestion().getQuestionType().equals("Matching")) {
                for (Word word : currentLesson.getCurrentQuestion().getWordsInQuestion()) {
                    account.getDashboard().addWordToReviewList(word);
                    // Creates a new question in Review Lesson for the incorrect word
                    LessonList.getInstance().addQuestionToReview(word);
                }
                return false;
            } else {
                // If the question is of type FillInTheBlank or UserTextEntry and the answer was
                // incorrect, the associated phrase is added to the account's list of phrases to
                // review on the dashboard
                account.getDashboard().addPhraseToReviewList(currentLesson.getCurrentQuestion().getPhraseInQuestion());
                // Creates a new question in Review Lesson for the incorrect phrase
                LessonList.getInstance().addQuestionToReview(currentLesson.getCurrentQuestion().getPhraseInQuestion());
                return false;
            }
        }
    }

    /**
     * Returns the Avatar from the current account
     * 
     * @return The Avatar from the current account
     */
    public Avatar viewAvatar() {
        return account.getAvatar();
    }

    /**
     * Changes the skill level for the current account
     * 
     * @param level The level to change the current level to
     */
    public void changeSkillLevel(SkillLevel level) {
        account.setSkillLevel(level);
    }

    /**
     * Gets the user's current score in the current lesson
     * 
     * @return The user's number of answers correct / the number of questions
     *         completed
     */
    public String getScore() {
        return currentLesson.getUserScore();
    }

    /**
     * generates a text file with words and phrases to study
     */
    /**
     * Generates a text file with words and phrases to study.
     */
    public void printStudySheet() {
        String fileName = "studySheet.txt"; // File name for the study sheet

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Write words to the file
            for (Word word : account.getDashboard().getWordsToReview()) {
                writer.write(word.getWordText());
                writer.newLine();
            }

            // Write phrases to the file
            for (Phrase phrase : account.getDashboard().getPhrasesToReview()) {
                for (String text : phrase.getPhraseText()) {
                    writer.write(text + " ");
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
