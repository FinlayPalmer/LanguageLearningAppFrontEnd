package com.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Astha Singh
 */

class LeaderboardTest {

    private Leaderboard leaderboard;
    private Account account1, account2, account3, account4, account5, account6, account7, account8, account9, account10, account11;
    private AccountList accountList;

    @BeforeEach
    void setUp() {
        leaderboard = Leaderboard.getInstance();

        account1 = new Account("User1", "Test", "user1@example.com", "1990-01-01", "user1", "password");
        account2 = new Account("User2", "Test", "user2@example.com", "1991-01-01", "user2", "password");
        account3 = new Account("User3", "Test", "user3@example.com", "1992-01-01", "user3", "password");
        
        account1.setLessonsCompleted(5);
        account2.setLessonsCompleted(15);
        account3.setLessonsCompleted(10);

        accountList = AccountList.getInstance();
        accountList.clearAccounts(); 
        accountList.addAccount(account1);
        accountList.addAccount(account2);
        accountList.addAccount(account3);
    }

    @Test
    void testUpdateLeaderboardSorting() {
        leaderboard.updateLeaderboard();
        ArrayList<Account> sortedAccounts = leaderboard.getTopAccounts();

        assertEquals(3, sortedAccounts.size(), "Expected 3 accounts in the top accounts list");
        assertEquals(account2, sortedAccounts.get(0), "Expected account with most lessons completed to be first");
        assertEquals(account3, sortedAccounts.get(1), "Expected second highest account");
        assertEquals(account1, sortedAccounts.get(2), "Expected third highest account");
    }

    @Test
    void testGetTopAccountsLimit() {
        ArrayList<Account> topAccounts = leaderboard.getTopAccounts();
        assertTrue(topAccounts.size() <= 10, "Leaderboard should contain a maximum of 10 accounts");
    }

    @Test
    void testGetAccountPosition() {
        int position1 = leaderboard.getAccountPosition(account1);
        int position2 = leaderboard.getAccountPosition(account2);
        int position3 = leaderboard.getAccountPosition(account3);

        assertEquals(3, position1, "Expected account1 to be at position 3");
        assertEquals(1, position2, "Expected account2 to be at position 1");
        assertEquals(2, position3, "Expected account3 to be at position 2");
    }

    @Test
    void testGetAccountPositionNotOnLeaderboard() {
        Account nonExistentAccount = new Account("NonExistent", "User", "no@example.com", "2000-01-01", "nonexistent", "password");
        int position = leaderboard.getAccountPosition(nonExistentAccount);
        assertEquals(-1, position, "Expected position to be -1 for an account not on the leaderboard");
    }
}
