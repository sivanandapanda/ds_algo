package algo.external.leetcode.longest_common_prefix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindLongestCommonPrefixTest {

    @Test
    void test0() {
        var findLongestCommonPrefix = new FindLongestCommonPrefix();
        assertEquals("", findLongestCommonPrefix.longestCommonPrefix(new String[]{}));
    }

    @Test
    void test1() {
        var findLongestCommonPrefix = new FindLongestCommonPrefix();
        assertEquals("fl", findLongestCommonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    @Test
    void test2() {
        var findLongestCommonPrefix = new FindLongestCommonPrefix();
        assertEquals("", findLongestCommonPrefix.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    @Test
    void test3() {
        var findLongestCommonPrefix = new FindLongestCommonPrefix();
        assertEquals("c", findLongestCommonPrefix.longestCommonPrefix(new String[]{"car","cir"}));
    }

    @Test
    void test4() {
        var findLongestCommonPrefix = new FindLongestCommonPrefix();
        assertEquals("", findLongestCommonPrefix.longestCommonPrefix(new String[]{"reflower","flow","flight"}));
    }

    @Test
    void test5() {
        var findLongestCommonPrefix = new FindLongestCommonPrefix();
        assertEquals("", findLongestCommonPrefix.longestCommonPrefix(new String[]{"c","acc","ccc"}));
    }

}