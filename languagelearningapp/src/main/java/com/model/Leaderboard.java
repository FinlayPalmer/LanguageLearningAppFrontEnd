package com.model;
import java.util.ArrayList;

/**
 * @author Sanjana Guzzarlamudi, Matthew Botteon
 * Creates a Leaderboard object
 */

 public class Leaderboard {
    private static Leaderboard instance;
    private ArrayList<Account> accounts;
    private ArrayList<Account> topAccounts;

    private Leaderboard() {
        this.topAccounts = new ArrayList<>();
    }

    public static Leaderboard getInstance() {
        if (instance == null) {
            instance = new Leaderboard();
        }
        return instance;
    }

    /**
     * Sorts the list of Accounts in descending order based on how many lessons they have completed
     */
    public void updateLeaderboard() {
        loadAccounts(); // Ensure accounts are loaded before sorting
        accounts.sort((a, b) -> Integer.compare(b.getLessonsCompleted(), a.getLessonsCompleted()));
    }

/**
     * Load accounts if they are not already loaded
     */
    private void loadAccounts() {
        if (accounts == null) {
            accounts = AccountList.getInstance().getListOfAllAccounts();
        }
    }

    /**
     * Gets the top ten users on the leaderboard
     * 
     * @return Indices 0 to 9 of the list of accounts
     */
    public ArrayList<Account> getTopAccounts() {
        updateLeaderboard();
        topAccounts.clear();
        int count = Math.min(accounts.size(), 10); 
        for (int i = 0; i < count; i++) {
            topAccounts.add(accounts.get(i));
        }
        return topAccounts;
    }

    /**
     * Gets the position of the current user by iterating thru account and looking for a match
     * @param account The account to search for on the leaderboard
     * @return The position in the list plus one to adjust for indices beginning at zero
     */
    public int getAccountPosition(Account account) {
        updateLeaderboard();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).equals(account)) {
                return i + 1; 
            }
        }
        return -1; 
    }
}