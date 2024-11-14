package com.model;

import java.util.ArrayList;

/**
 * Creates a new AccountList
 * 
 * @author Finlay Palmer
 */
public class AccountList {
    private ArrayList<Account> accounts;
    private static AccountList accountList;

    /**
     * Creates a new AccountList
     */
    private AccountList() {
        accounts = DataLoader.getInstance().getAccounts();
    }

    /**
     * Returns the AccountList instance
     * 
     * @return accountList
     */
    public static AccountList getInstance() {
        if (accountList == null) {
            accountList = new AccountList();
        }
        return accountList;
    }

    /**
     * Adds a new Account to accounts
     * 
     * @param firstName   The first name of the account holder.
     * @param lastName    The last name of the account holder.
     * @param email       The email address of the account holder.
     * @param dateOfBirth The date of birth of the account holder.
     * @param username    The username for the account.
     * @param password    The password for the account.
     * @return The new account.
     */
    public Account addAccount(String firstName, String lastName, String email, String dateOfBirth, String userName,
            String password) {
        Account account = new Account(firstName, lastName, email, dateOfBirth, userName, password);
        for (Account a : accounts) {
            if (a.getUsername().equals(account.getUsername()) || a.getEmail().equals(account.getEmail())) {
                return null;
            }
        }
        accounts.add(account);
        return account;
    }
  
     public void addAccount(Account account) {
        accounts.add(account);
    }
    public void clearAccounts() {
        accounts.clear();
    }
    /**
     * Gets an Account from accounts
     * 
     * @param username The username for the account.
     * @param password The password for the account.
     * @return The Account.
     */
    public Account getAccount(String username, String password) {
        for (Account account : accounts) {
            if (account.isMatch(username, password)) {
                return account;
            }
        }
        return null;
    }

    /**
     * Returns the ArrayList of accounts in the system
     * 
     * @return An ArrayList of all accounts in the system
     */
    public ArrayList<Account> getListOfAllAccounts() {
        return accounts;
    }

    /**
     * Checks to see if an Account is within accounts
     * 
     * @param account The Account to check.
     * @return True if account is within accounts, false else.
     */
    public boolean checkForAccount(Account account) {
        return accounts.contains(account);
    }

    /**
     * Saves AccountList via DataWriter
     */
    public void save() {
        DataWriter dataWriter = new DataWriter();
        dataWriter.saveAccounts(accounts);
    }
}
