package algo.external.udemy;

import ds.stack.SimpleListStack;

/**
 * Using stack, determine whether a string is a palindrome
 * Ignore case, ignore punctuation and spaces
 */
public class CheckPalindromeUsingStack {

    public static void main(String[] args) {
        //String string = "Racecar";
        //String string = "I did, did I?";
        String string = "Hello";

        System.out.println(isPalindrome(string));
    }

    private static boolean isPalindrome(String string) {
        SimpleListStack<String> stack = new SimpleListStack<>();

        String pattern = "[a-zA-Z]";

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            String c = String.valueOf(string.charAt(i));

            if(c.matches(pattern)) {
                stringBuilder.append(c.toLowerCase());
            }
        }

        for (int i = 0; i < string.length(); i++) {
            String c = String.valueOf(string.charAt(i));

            if(c.matches(pattern)) {
                stack.push(c.toLowerCase());
            }
        }

        StringBuilder reverseStringBuilder = new StringBuilder();

        while(!stack.isEmpty()) {
            reverseStringBuilder.append(stack.pop());
        }

        return stringBuilder.toString().equals(reverseStringBuilder.toString());
    }
}
