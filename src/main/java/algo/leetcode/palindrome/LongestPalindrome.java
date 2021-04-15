package algo.leetcode.palindrome;

import java.util.HashMap;
import java.util.Map;

//Leetcode 5
public class LongestPalindrome {

    public static String find(String s) {
        String longestPalindrome = "";

        Map<String, Boolean> cache = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            if(longestPalindrome.length() >= (s.length()-i)) {
                break;
            }

            for (int j = s.length(); j > 0; j--) {

                if(longestPalindrome.length() >= (j-i)) {
                    break;
                }

                var candidate = s.substring(i, j);

                var isPalindrome = false;
                if(cache.containsKey(candidate)) {
                    isPalindrome = cache.get(candidate);
                } else {
                    isPalindrome = isPalindrome(candidate);
                    cache.put(candidate, isPalindrome);
                }

                if(isPalindrome && candidate.length() > longestPalindrome.length()) {
                    longestPalindrome = candidate;
                }

            }
        }

        return longestPalindrome;
    }

    private static boolean isPalindrome(String string) {
        int startIndex = 0;
        int endIndex = string.length()-1;

        while(startIndex < endIndex) {

            var startChar = string.charAt(startIndex);

            var endChar = string.charAt(endIndex);

            if(startChar != endChar) {
                return false;
            }

            startIndex++;
            endIndex--;
        }

        return true;
    }
}
