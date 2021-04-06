package algo.leetcode.palindrome;

public class PalindromeMain {

    public static boolean isPalindrome(String string) {
        int startIndex = 0;
        int endIndex = string.length()-1;

        String pattern = "[a-zA-Z0-9]";

        while(startIndex < endIndex) {

            var startChar = String.valueOf(string.charAt(startIndex)).toLowerCase();

            while(!startChar.matches(pattern)) {
                startIndex++;

                if(startIndex >= string.length()) {
                    break;
                }

                startChar = String.valueOf(string.charAt(startIndex)).toLowerCase();
            }

            var endChar = String.valueOf(string.charAt(endIndex)).toLowerCase();

            while(!endChar.matches(pattern)) {
                endIndex--;

                if(endIndex < 0) {
                    break;
                }

                endChar = String.valueOf(string.charAt(endIndex)).toLowerCase();
            }

            if(endChar.matches(pattern) && startChar.matches(pattern) && !startChar.equals(endChar)) {
                return false;
            }

            startIndex++;
            endIndex--;
        }

        return true;
    }

}
