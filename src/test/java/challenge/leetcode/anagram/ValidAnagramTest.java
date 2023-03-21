package challenge.leetcode.anagram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ValidAnagramTest {

    @Test
    void test_anagram() {
        assertTrue(new ValidAnagram().isAnagram("anagram", "nagaram"));
        assertFalse(new ValidAnagram().isAnagram("car", "rat"));
    }

}