package code.elif;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromeNumberTest {

    @Test
    void isPalindrome() {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        boolean palindrome = palindromeNumber.isPalindrome(1);
        assertEquals(true, palindrome);
    }

    @Test
    void isPalindrome2() {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        boolean palindrome = palindromeNumber.isPalindrome(10);
        assertEquals(false, palindrome);
    }

    @Test
    void isPalindrome3() {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        boolean palindrome = palindromeNumber.isPalindrome(101101);
        assertEquals(true, palindrome);
    }

    @Test
    void isPalindrome4() {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        boolean palindrome = palindromeNumber.isPalindrome(1012101);
        assertEquals(true, palindrome);
    }

    @Test
    void isPalindrome5() {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        boolean palindrome = palindromeNumber.isPalindrome(10121031);
        assertEquals(false, palindrome);
    }
}