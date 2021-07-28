package challenge.leetcode.palindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestPalindromeTest {

    @Test
    void test_1() {
        assertEquals("bab", LongestPalindrome.find("babad"));
    }

    @Test
    void test_2() {
        assertEquals("a", LongestPalindrome.find("a"));
    }

    @Test
    void test_3() {
        assertEquals("a", LongestPalindrome.find("ac"));
    }

    @Test
    void test_4() {
        assertEquals("bb", LongestPalindrome.find("cbbd"));
    }

    @Test
    void test_5() {
        assertEquals("aaaa", LongestPalindrome.find("aaaa"));
    }

    @Test
    void test_6() {
        assertEquals("bcb", LongestPalindrome.find("eabcb"));
    }
}