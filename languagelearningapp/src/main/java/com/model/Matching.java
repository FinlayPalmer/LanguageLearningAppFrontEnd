package com.model;
import java.util.ArrayList;

/**
 * @author Matthew Botteon and Astha Singh
 * Creates a matching question where the user must line up each Spanish word and its translation
 */

 public class Matching extends Question {
    private String title;
    private ArrayList<Word> spanishWords;
    private ArrayList<String> correctMatches;
    private ArrayList<String> wordBank;
    private ArrayList<String> userMatches;
    private String questionType;

    /**
     * Creates a new Matching question with an ArrayList of words to match.
     * 
     * @param title The title of the question.
     * @param spanishWords The Spanish words the user will need to match the meanings to.
     */
    public Matching(String title, ArrayList<Word> spanishWords) {
        super(title);
        this.title = title;
        this.spanishWords = spanishWords;
        this.correctMatches = new ArrayList<>();
        this.wordBank = new ArrayList<>();
        this.userMatches = new ArrayList<>();
        this.questionType = "Matching";

        // Initializes correctMatches and wordBank by looping through spanishWords.
        for (Word word : spanishWords) {
            correctMatches.add(word.getTranslation());
            wordBank.add(word.getTranslation());
        }
        // Calls the shuffle method to randomize the wordBank choices.
        shuffle();
    }

    /**
     * Gets the title of the question.
     * 
     * @return The question's title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns a list of the Spanish words to match with.
     * 
     * @return A list of the Spanish words to match with.
     */
    public ArrayList<Word> getSpanishWords() {
        return spanishWords;
    }

    /**
     * Returns a list of the correct matches in order.
     * 
     * @return A list of the correct matches in order.
     */
    public ArrayList<String> getCorrectMatches() {
        return correctMatches;
    }

    /**
     * Gets a list of options for the user to choose from.
     * 
     * @return The randomized word bank.
     */
    public ArrayList<String> getOptions() {
        return wordBank;
    }

    /**
     * Returns a list of the user matches in order.
     * 
     * @return A list of the user matches in order.
     */
    public ArrayList<String> getUserMatches() {
        return userMatches;
    }

    /**
     * Formats the Spanish words and the translation options as a String for the parent method.
     * 
     * @return The options for the user to match in String format.
     */
    public String getQuestionText() {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < spanishWords.size(); i++) {
            text.append(spanishWords.get(i).getWordText()).append("\t").append(wordBank.get(i)).append("\n");
        }
        return text.toString();
    }

    /**
     * Formats the Spanish words and the correct matches as a String for the parent method.
     * 
     * @return The correct answers in String format.
     */
    public String getCorrectAnswer() {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < spanishWords.size(); i++) {
            text.append(spanishWords.get(i).getWordText()).append("\t").append(correctMatches.get(i)).append("\n");
        }
        return text.toString();
    }

    /**
     * Gets the question type.
     * 
     * @return The question type, which will always be Matching.
     */
    public String getQuestionType() {
        return questionType;
    }

    /**
     * Sets the question choices to new Spanish words, sets the answers to their translations, and randomizes the choices.
     * 
     * @param spanishWords The new list of Spanish words.
     */
    public void setQuestionText(ArrayList<Word> spanishWords) {
        this.spanishWords = spanishWords;
        correctMatches.clear();
        wordBank.clear();
        userMatches.clear();

        for (Word word : spanishWords) {
            correctMatches.add(word.getTranslation());
            wordBank.add(word.getTranslation());
            userMatches.add(null);
        }
        // Calls the shuffle method to randomize the wordBank choices.
        shuffle();
    }

    /**
     * Places the English translation in userMatches at the index of the Spanish word the user wants to match it to.
     * 
     * @param spanishWord The Spanish word the user is matching the translation to.
     * @param answer The English translation the user is matching.
     */
    public void setUserMatch(Word spanishWord, String answer) {
        userMatches.set(spanishWords.indexOf(spanishWord), answer);
    }

    /**
     * Iterates through the correctMatches list and compares each element to the userMatches list.
     * 
     * @return False if the elements at any index are not equal, true if all are correct.
     */
    @Override
    public boolean isAnswerCorrect(String userAnswer) {
        // Split the String of matches by space and add to the userMatches ArrayList
        for(String word : userAnswer.split(" "))
            userMatches.add(word.trim());
        // Returns false if there are not the same amount of matches
        if (userMatches.size() != correctMatches.size())
            return false;
        // Iterate over correctMatches, checking userMatches for the same String at each index
        for (int i = 0; i < correctMatches.size(); i++) {
            if (!correctMatches.get(i).equals(userMatches.get(i)))
                return false;
        } return true;
    }

    /**
     * Lists the spanishWord and the wordBank in two columns
     */
    public String toString() { 
        String string = "--------------------\n" + questionType + "\nCategory: " + title + "\n";
        for(int i = 0; i < spanishWords.size(); i++) {
            string += "\n" + spanishWords.get(i).getWordText() + "\t\t" + wordBank.get(i);
        } return string;
    }

    /**
     * Returns the Spanish words in the Question as an ArrayList, necessary for Flashcard and Matching
     * 
     * @return An ArrayList of Spanish words
     */
    public ArrayList<Word> getWordsInQuestion() {
        return spanishWords;
    }

    /**
     * Returns the Phrase in the question, necessary for FillInTheBlank and UserTextEntry
     * 
     * @return A phrase from the question
     */
    public Phrase getPhraseInQuestion() {
        return null;
    }

    /**
     * Loops through the wordBank list and performs swaps of random elements to give the user a randomized set of options.
     */
    private void shuffle() {
        for (int i = 0; i < wordBank.size(); i++) {
            int j = (int) (Math.random() * wordBank.size());
            int k = (int) (Math.random() * wordBank.size());
            String temp = wordBank.get(j);
            wordBank.set(j, wordBank.get(k));
            wordBank.set(k, temp);
        }
    }
}
