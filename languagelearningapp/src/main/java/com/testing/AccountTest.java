package com.testing;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.model.Account;
import com.model.SkillLevel;

import java.util.UUID;
/**
 * @author Astha Singh
 */

class AccountTest {
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account("John", "Doe", "john.doe@example.com", "01/01/1990", "johndoe", "password123");
    }

    @Test
    void testIsMatchWithCorrectCredentials() {
        assertTrue(account.isMatch("johndoe", "password123"));
    }

    @Test
    void testIsMatchWithIncorrectUsername() {
        assertFalse(account.isMatch("wronguser", "password123"));
    }

    @Test
    void testIsMatchWithIncorrectPassword() {
        assertFalse(account.isMatch("johndoe", "wrongpassword"));
    }

    @Test
    void testValidateDateOfBirthWithCorrectDate() {
        assertTrue(account.validateDateOfBirth("01/01/1990"));
    }

    @Test
    void testValidateDateOfBirthWithIncorrectDate() {
        assertFalse(account.validateDateOfBirth("02/02/1992"));
    }

    @Test
    void testSetAndGetSkillLevel() {
        account.setSkillLevel(SkillLevel.DIFFICULT);
        assertEquals(SkillLevel.DIFFICULT, account.getSkillLevel());
    }

    @Test
    void testUUIDIsUnique() {
        Account anotherAccount = new Account("Jane", "Doe", "jane.doe@example.com", "01/01/1991", "janedoe", "password456");
        assertNotEquals(account.getAccountID(), anotherAccount.getAccountID());
    }

    @Test
    void testToStringFormat() {
        String expected = "\nYour Account:\nFirst Name: John\nLast Name: Doe\nEmail: john.doe@example.com\nDate of Birth: 01/01/1990\nUsername: johndoe\n---------------------------------";
        assertEquals(expected, account.toString());
    }

    @Test
    void testEqualsWithIdenticalAccount() {
        Account identicalAccount = new Account("John", "Doe", "john.doe@example.com", "01/01/1990", "johndoe", "password123");
        assertTrue(account.equals(identicalAccount));
    }

    @Test
    void testEqualsWithDifferentAccount() {
        Account differentAccount = new Account("Jane", "Doe", "jane.doe@example.com", "01/01/1991", "janedoe", "password456");
        assertFalse(account.equals(differentAccount));
    }
}
