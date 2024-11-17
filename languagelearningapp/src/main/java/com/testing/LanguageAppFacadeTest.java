package com.testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Finlay Palmer
 */
public class LanguageAppFacadeTest {
    static LanguageAppFacade languageAppFacade;
    static AccountList accountList;

    @BeforeClass
    public static void oneTimeSetup() {
    }

    @AfterClass
    public static void oneTimeTearDown() {

    }

    @Before
    public void setup() {
        languageAppFacade = LanguageAppFacade.getInstance();
        accountList = AccountList.getInstance();
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testLoginUsernamePassword() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        languageAppFacade.login("cannibal01", "silenceofthelambs");
        assertTrue(languageAppFacade.viewAccountDetails().get(4).equals("cannibal01")
                && languageAppFacade.viewAccountDetails().get(5).equals("silenceofthelambs"));
    }

    @Test
    public void testLoginUsernamenoPassword() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        languageAppFacade.login("", "");
        assertTrue(languageAppFacade.viewAccountDetails().size() == 0);
    }

    @Test
    public void testLoginnoUsernamePassword() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        languageAppFacade.login("", "");
        assertTrue(languageAppFacade.viewAccountDetails().size() == 0);
    }

    @Test
    public void testLogoutnoLogin() {
        languageAppFacade.logout();
        assertTrue(languageAppFacade.viewAccountDetails().size() == 0);
    }

    @Test
    public void testsignUpStringUsernameStringPassword() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        assertTrue(accountList.getAccount("cannibal01", "silenceofthelambs") != null);
    }

    @Test
    public void testsignUpnoUsernamenoPassword() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "", "");
        assertTrue(accountList.getAccount("", "") == null);
    }

    @Test
    public void testsignUpUsernamenoPassword() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01", "");
        assertTrue(accountList.getAccount("cannibal01", "") == null);
    }

    @Test
    public void testsignUpnoUsernamePassword() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01", "");
        assertTrue(accountList.getAccount("cannibal01", "") == null);
    }

    @Test
    public void testsignUpnullName() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01", "");
        assertTrue(accountList.getAccount("cannibal01", "") == null);
    }

    @Test
    public void testViewAccountDetailsNoLogin() {
        assertTrue(languageAppFacade.viewAccountDetails().size() == 0);
    }

    @Test
    public void testTakeSkillLevelTestNoLogin() {
        languageAppFacade.takeSkillLevelTest();
        assertTrue(/* Haven't written code for skillLevelTest yet */false);
    }

    @Test
    public void testviewDashboardNoLogin() {
        assertTrue(languageAppFacade.viewDashboard() == "Please Log in");
    }

    @Test
    public void testviewLeaderboardNoLogin() {
        assertTrue(languageAppFacade.viewLeaderboard() == null);
    }

    @Test
    public void testgetLanguageSectionNoLogin() {
        assertTrue(languageAppFacade.getLanguageSection() == null);
    }

    @Test
    public void testgetLessonNoLogin() {
        assertTrue(languageAppFacade.getLesson() == null);
    }

    @Test
    public void testgetLessonChoicesNoLogin() {
        assertTrue(languageAppFacade.getLessonChoices() == "Please Log in");
    }

    @Test
    public void teststartNewLessonNoLogin() {
        assertTrue(languageAppFacade.startNewLesson("") == null);
    }

    @Test
    public void teststartNewLessonNoLesson() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        assertTrue(languageAppFacade.startNewLesson("") == null);
    }

    @Test
    public void teststartNewLessonRegularLesson() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        assertTrue(languageAppFacade.startNewLesson("Colors") != null);
    }

    @Test
    public void teststartNewLessonWhileSameLessonStartedReturnsFirstQuestion() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        languageAppFacade.startNewLesson("Colors");
        languageAppFacade.nextQuestion();
        languageAppFacade.nextQuestion();
        languageAppFacade.nextQuestion();
        languageAppFacade.nextQuestion();
        assertTrue(languageAppFacade.startNewLesson("Colors").getCorrectAnswer() == "The ocean is blue");
    }

    @Test
    public void teststartNewLessonWhileDiffernetLessonStartedReturnsFirstQuestion() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        languageAppFacade.startNewLesson("School");
        languageAppFacade.nextQuestion();
        languageAppFacade.nextQuestion();
        languageAppFacade.nextQuestion();
        languageAppFacade.nextQuestion();
        assertTrue(languageAppFacade.startNewLesson("Colors").getCorrectAnswer() == "The ocean is blue");
    }

    @Test
    public void testendLessonNoLesson() {
        languageAppFacade.endLesson();
    }

    @Test
    public void testendLessonRegularLesson() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        languageAppFacade.startNewLesson("School");
        languageAppFacade.nextQuestion();
        languageAppFacade.endLesson();
        assertTrue(languageAppFacade.nextQuestion() == null);
    }

    @Test
    public void testresumeLessonNullLesson() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        languageAppFacade.startNewLesson("School");
        languageAppFacade.nextQuestion();
        languageAppFacade.pauseLesson();
        assertTrue(languageAppFacade.resumeLesson(null) == null);
    }

    @Test
    public void testresumeLessonNoLesson() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        languageAppFacade.startNewLesson("School");
        languageAppFacade.nextQuestion();
        languageAppFacade.pauseLesson();
        assertTrue(languageAppFacade.resumeLesson("") == null);
    }

    @Test
    public void testresumeLessonRegularLesson() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        languageAppFacade.startNewLesson("School");
        languageAppFacade.nextQuestion();
        languageAppFacade.pauseLesson();
        assertTrue(languageAppFacade.resumeLesson("School").getCorrectAnswer()
                .equals("I have studied hard and I hope to get a good grade"));
    }

    @Test
    public void testpauseLessonNoLesson() {
        languageAppFacade.pauseLesson();
    }

    @Test
    public void testpauseLessonRegularLesson() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        languageAppFacade.startNewLesson("School");
        languageAppFacade.nextQuestion();
        languageAppFacade.pauseLesson();
    }

    @Test
    public void testgetQuestionNoLogin() {
        assertTrue(languageAppFacade.getQuestion(1) == null);
    }

    @Test
    public void testgetQuestionNoLesson() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        assertTrue(languageAppFacade.getQuestion(1) == null);
    }

    @Test
    public void testgetQuestionFirstQuestion() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        languageAppFacade.startNewLesson("School");
        assertTrue(languageAppFacade.getQuestion(1).getPhraseInQuestion().getUUID()
                .equals("fcdecf9d-4fbc-42e2-baf0-6bc77521fee3"));
    }

    @Test
    public void testgetQuestionLastQuestion() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        languageAppFacade.startNewLesson("School");
        assertTrue(languageAppFacade.getQuestion(9).getPhraseInQuestion().getUUID()
                .equals("d2360e56-16b6-4814-b4d0-05b361c2f26a"));
    }

    @Test
    public void testgetQuestionOutOfBounds() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        languageAppFacade.startNewLesson("School");
        assertTrue(languageAppFacade.getQuestion(100) == null);
    }

    @Test
    public void testgetQuestionNoParameterNoLogin() {
        assertTrue(languageAppFacade.getQuestion() == null);
    }

    @Test
    public void testgetQuestionNoParameterRegularLesson() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        languageAppFacade.startNewLesson("School");
        assertTrue(languageAppFacade.getQuestion().getPhraseInQuestion().getUUID()
                .equals("fcdecf9d-4fbc-42e2-baf0-6bc77521fee3"));
    }

    @Test
    public void testNextQuestionNoLogin() {
        assertTrue(languageAppFacade.nextQuestion() == null);
    }

    @Test
    public void testNextQuestionNoLesson() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        assertTrue(languageAppFacade.nextQuestion() == null);
    }

    @Test
    public void testNextQuestionLastQuestion() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        languageAppFacade.startNewLesson("School");
        languageAppFacade.nextQuestion();
        languageAppFacade.nextQuestion();
        languageAppFacade.nextQuestion();
        languageAppFacade.nextQuestion();
        languageAppFacade.nextQuestion();
        languageAppFacade.nextQuestion();
        languageAppFacade.nextQuestion();
        languageAppFacade.nextQuestion();
        assertTrue(languageAppFacade.nextQuestion() != null);
    }

    @Test
    public void testNextQuestionRegularLesson() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        languageAppFacade.startNewLesson("School");
        assertTrue(languageAppFacade.nextQuestion().getPhraseInQuestion().getUUID()
                .equals("ddbc01e7-4232-495d-a367-6d246ba3b85e"));
    }

    @Test
    public void testPreviousQuestionNoLogin() {
        assertTrue(languageAppFacade.previousQuestion() == null);
    }

    @Test
    public void testPreviousQuestionNoLesson() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        assertTrue(languageAppFacade.previousQuestion() == null);
    }

    @Test
    public void testPreviousQuestionFirstQuestion() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        languageAppFacade.startNewLesson("School");
        assertTrue(languageAppFacade.previousQuestion() != null);
    }

    @Test
    public void testPreviousQuestionRegularLesson() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        languageAppFacade.startNewLesson("School");
        languageAppFacade.nextQuestion();
        assertTrue(languageAppFacade.previousQuestion().getPhraseInQuestion().getUUID()
                .equals("fcdecf9d-4fbc-42e2-baf0-6bc77521fee3"));
    }

    @Test
    public void testAnswerQuestionNoLogin() {
        assertTrue(languageAppFacade.answerQuestion("") == false);
    }

    @Test
    public void testAnswerQuestionNoLesson() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        assertTrue(languageAppFacade.answerQuestion("") == false);
    }

    @Test
    public void testAnswerQuestionNoAnswer() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        languageAppFacade.startNewLesson("School");
        assertTrue(languageAppFacade.answerQuestion("") == false);
    }

    @Test
    public void testAnswerQuestionWrongAnswer() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        languageAppFacade.startNewLesson("School");
        assertTrue(languageAppFacade.answerQuestion("tasty") == false);
    }

    @Test
    public void testAnswerQuestionCorrectAnswer() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        languageAppFacade.startNewLesson("School");
        assertTrue(languageAppFacade.answerQuestion("Next Monday we have a math test") == true);
    }

    @Test
    public void testViewAvatarNoLogin() {
        assertTrue(languageAppFacade.viewAvatar() == null);
    }

    @Test
    public void testChangeSkillLevelNoLogin() {
        languageAppFacade.changeSkillLevel(SkillLevel.DIFFICULT);
    }

    @Test
    public void testChangeSkillLevelRegularLogin() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        languageAppFacade.changeSkillLevel(SkillLevel.DIFFICULT);
    }

    @Test
    public void testGetScoreNoLogin() {
        assertTrue(languageAppFacade.getScore().equals("Please Log in"));
    }

    @Test
    public void testPrintStudySheetNoLogin() {
        languageAppFacade.printStudySheet();
    }

    @Test
    public void testPrintStudySheetRegularLogin() {
        languageAppFacade.signUp("Hannibal", "Lecter", "hannibal@cannibalsunited.com", "03/03/1933", "cannibal01",
                "silenceofthelambs");
        languageAppFacade.printStudySheet();
    }
}
