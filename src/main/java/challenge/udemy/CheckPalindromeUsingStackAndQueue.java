package challenge.udemy;

import ds.stack.SimpleListStack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Using stack and queue, determine whether a string is a palindrome
 * Ignore case, ignore punctuation and spaces
 */
public class CheckPalindromeUsingStackAndQueue {

    public static void main(String[] args) {
        String string = "Racecar";
        //String string = "I did, did I?";
        //String string = "Hello";

        System.out.println(isPalindrome(string));
    }

    private static boolean isPalindrome(String string) {
        SimpleListStack<String> stack = new SimpleListStack<>();

        Queue<String> queue = new LinkedList<>();

        String pattern = "[a-zA-Z]";

        for (int i = 0; i < string.length(); i++) {
            String c = String.valueOf(string.charAt(i));

            if(c.matches(pattern)) {
                stack.push(c.toLowerCase());
                queue.offer(c.toLowerCase());
            }
        }

        for (int i = 0; i < queue.size(); i++) {
            if(!queue.poll().equals(stack.pop())) {
                return false;
            }
        }

        return true;
    }
}
