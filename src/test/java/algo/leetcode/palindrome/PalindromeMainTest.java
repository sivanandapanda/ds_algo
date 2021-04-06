package algo.leetcode.palindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeMainTest {

    @Test
    void test_1() {
        assertFalse(PalindromeMain.isPalindrome("Hello"));
    }

    @Test
    void test_2() {
        assertTrue(PalindromeMain.isPalindrome("I did, did I?"));
    }

    @Test
    void test_3() {
        assertTrue(PalindromeMain.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    void test_4() {
        assertTrue(PalindromeMain.isPalindrome(".,"));
    }

}