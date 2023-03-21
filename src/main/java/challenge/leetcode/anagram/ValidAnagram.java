package challenge.leetcode.anagram;

import java.util.Arrays;
import java.util.HashMap;

//leetcode 242
//https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {

    boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        var countSMap = new HashMap<Character, Integer>();
        var countTMap = new HashMap<Character, Integer>();

        for(Character aChar: s.toCharArray()) {
            var count = countSMap.getOrDefault(aChar, 0);
            countSMap.put(aChar, count + 1);
        }

        for(Character aChar: t.toCharArray()) {
            var count = countTMap.getOrDefault(aChar, 0);
            countTMap.put(aChar, count + 1);
        }

        for (Character aChar: countSMap.keySet()) {
            int countOfCharInS = countSMap.get(aChar);
            int countOfCharInT = countTMap.getOrDefault(aChar, 0);

            if (countOfCharInS != countOfCharInT) {
                return false;
            }
        }

        return true;
    }

    boolean sameSolutionWithNoExtraMemory(String s, String t) {
        if (s.length() != t.length()) return false;

        var sortedCharsForS = s.toCharArray();
        var sortedCharsForT = t.toCharArray();

        Arrays.sort(sortedCharsForS);
        Arrays.sort(sortedCharsForT);

        for (int i = 0; i < sortedCharsForS.length; i++) {
            if (sortedCharsForS[i] != sortedCharsForT[i]) {
                return false;
            }
        }

        return true;

    }
}
