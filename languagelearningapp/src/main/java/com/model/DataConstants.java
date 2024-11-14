package com.model;

/** 
 * @author Astha, Sanjana
 * DataConstants class defines constants used for file paths and JSON keys.
 */
public class DataConstants {

    // File paths
    public static final String ACCOUNTS_FILE = "/data/Account.json";
    public static final String LESSONS_FILE = "/data/Lessons.json";
    public static final String WORD_FILE = "/data/Word.json";
    public static final String PHRASE_FILE = "/data/Phrase.json";


    // JSON keys for Account
    public static final String ACCOUNT_FIRST_NAME = "firstName";
    public static final String ACCOUNT_LAST_NAME = "lastName";
    public static final String ACCOUNT_EMAIL = "email";
    public static final String ACCOUNT_DOB_STRING = "dateOfBirth";
    public static final String ACCOUNT_USERNAME = "username";
    public static final String ACCOUNT_PASSWORD = "password";
    public static final String ACCOUNT_RECOMMENDED_SKILL_LEVEL = "recommendedSkillLevel";
    public static final String ACCOUNT_AVATAR = "avatar";
    public static final String ACCOUNT_REVIEW_WORDS = "reviewWords";
    public static final String ACCOUNT_REVIEW_PHRASES = "reviewPhrases";
    public static final String ACCOUNT_CURRENT_LESSON = "currentLesson";


    // JSON keys for Avatar
    public static final String AVATAR_BASE = "baseAvatar";
    public static final String AVATAR_FEATURES = "features";
    public static final String AVATAR_MOUTH_STYLES = "mouthStyles";
    public static final String AVATAR_EYE_STYLES = "eyeStyles";
    public static final String AVATAR_HAIR_STYLES = "hairStyles";
    public static final String AVATAR_NOSE_STYLES = "noseStyles";
    public static final String AVATAR_HAT_STYLES = "hatStyles";

    // JSON keys for Lessons
    public static final String LESSON_ID = "lessonID";
    public static final String LESSON_TITLE = "title";
    public static final String LESSON_DESCRIPTION = "description";
    public static final String LESSON_CONTENT = "content";

    // JSON keys for Words
    public static final String WORD_CATEGORY = "category";
    public static final String WORD_WORDS = "words";
    public static final String WORD_TEXT = "text";
    public static final String WORD_TRANSLATION = "translation";
    public static final String WORD_ID = "wordID";

    // JSON keys for Phrases
    public static final String PHRASE_CATEGORY = "category";
    public static final String PHRASE_WORDS = "words";
    public static final String PHRASE_TEXT = "text";
    public static final String PHRASE_TRANSLATION = "translation";
    public static final String PHRASE_ID = "phraseID";

    // JSON keys for Question types
    public static final String QUESTION_TYPE = "type";
    public static final String QUESTION_TEXT = "questionText";
    public static final String QUESTION_CORRECT_ANSWER = "correctAnswer";
    public static final String QUESTION_DIFFICULTY = "difficulty";
}
