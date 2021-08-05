package challenge.leetcode.anagram;

import org.junit.jupiter.api.Test;

class GroupAnagramTest {

    @Test
    void testGrouping_1() {
        var groups = new GroupAnagram().groupAnagrams(new String[]{"a"});
        System.out.println(groups);
    }

    @Test
    void testGrouping_2() {
        var groups = new GroupAnagram().groupAnagrams(new String[]{""});
        System.out.println(groups);
    }

    @Test
    void testGrouping_3() {
        var groups = new GroupAnagram().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println(groups);
    }
}