package com.testing;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.model.Account;
import com.model.AccountList;

/**
 * @author Astha Singh
 */
class AccountListTest {
    private AccountList accountList;

    @BeforeEach
    void setUp() {
        accountList = AccountList.getInstance();
        accountList.getListOfAllAccounts().clear();  
    }

    @Test
    void testAddAccountWithUniqueUsernameAndEmail() {
        Account account = accountList.addAccount("Jane", "Doe", "jane.doe@example.com", "02/02/1992", "janedoe", "securepass");
        assertNotNull(account);
        assertEquals("janedoe", account.getUsername());
    }

    @Test
    void testAddAccountWithDuplicateUsername() {
        accountList.addAccount("John", "Doe", "john.doe@example.com", "01/01/1990", "johndoe", "password123");
        Account duplicateAccount = accountList.addAccount("Jane", "Doe", "jane.doe@example.com", "02/02/1992", "johndoe", "securepass");
        assertNull(duplicateAccount);
    }

    @Test
    void testAddAccountWithDuplicateEmail() {
        accountList.addAccount("John", "Doe", "john.doe@example.com", "01/01/1990", "johndoe", "password123");
        Account duplicateAccount = accountList.addAccount("Jane", "Doe", "john.doe@example.com", "02/02/1992", "janedoe", "securepass");
        assertNull(duplicateAccount);
    }

    @Test
    void testGetAccountWithCorrectCredentials() {
        accountList.addAccount("John", "Doe", "john.doe@example.com", "01/01/1990", "johndoe", "password123");
        Account account = accountList.getAccount("johndoe", "password123");
        assertNotNull(account);
        assertEquals("johndoe", account.getUsername());
    }

    @Test
    void testGetAccountWithIncorrectCredentials() {
        accountList.addAccount("John", "Doe", "john.doe@example.com", "01/01/1990", "johndoe", "password123");
        Account account = accountList.getAccount("johndoe", "wrongpassword");
        assertNull(account);
    }

    @Test
    void testCheckForAccountExists() {
        Account account = accountList.addAccount("Jane", "Doe", "jane.doe@example.com", "02/02/1992", "janedoe", "securepass");
        assertTrue(accountList.checkForAccount(account));
    }

    @Test
    void testCheckForAccountDoesNotExist() {
        Account nonExistentAccount = new Account("Non", "Existent", "non.existent@example.com", "01/01/1970", "nonexistent", "password");
        assertFalse(accountList.checkForAccount(nonExistentAccount));
    }

    @Test
    void testGetListOfAllAccounts() {
        Account account1 = accountList.addAccount("John", "Doe", "john.doe@example.com", "01/01/1990", "johndoe", "password123");
        Account account2 = accountList.addAccount("Jane", "Doe", "jane.doe@example.com", "02/02/1992", "janedoe", "securepass");

        assertEquals(2, accountList.getListOfAllAccounts().size());
        assertTrue(accountList.getListOfAllAccounts().contains(account1));
        assertTrue(accountList.getListOfAllAccounts().contains(account2));
    }
}
