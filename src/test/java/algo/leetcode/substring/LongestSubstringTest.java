package algo.leetcode.substring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringTest {

    @Test
    void test() {
        assertEquals(3, new LongestSubstring().lengthOfLongestSubstring("abcabcbb"));
    }

}