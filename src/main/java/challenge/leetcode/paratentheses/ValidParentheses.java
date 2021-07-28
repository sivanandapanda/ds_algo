package challenge.leetcode.paratentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//leetcode 20 https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {

    private final Map<Character, Character> mappings;

    public ValidParentheses() {
        this.mappings = new HashMap<>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {
        if(s == null) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            var charAtIndexI = s.charAt(i);

            if(stack.isEmpty() && (charAtIndexI == ')' || charAtIndexI == '}' || charAtIndexI == ']')) {
                return false;
            }

            if (this.mappings.containsKey(charAtIndexI)) {

                char topElement = stack.pop();

                if (topElement != this.mappings.get(charAtIndexI)) {
                    return false;
                }
            } else if(mappings.containsValue(charAtIndexI)) {
                stack.push(charAtIndexI);
            }
        }

        return stack.isEmpty();
    }

    //faster solution
    public boolean isValid_2(String s) {
        if(s == null) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            var charAtIndexI = s.charAt(i);

            if(stack.isEmpty() && (charAtIndexI == ')' || charAtIndexI == '}' || charAtIndexI == ']')) {
                return false;
            }

            if(charAtIndexI == '(' || charAtIndexI == '{' || charAtIndexI == '[') {
                stack.push(charAtIndexI);
            }

            if(charAtIndexI == ')' || charAtIndexI == '}' || charAtIndexI == ']') {
                var poppedChar = stack.pop();

                if(charAtIndexI == ')' && poppedChar != '(') {
                    return false;
                }

                if(charAtIndexI == '}' && poppedChar != '{') {
                    return false;
                }

                if(charAtIndexI == ']' && poppedChar != '[') {
                    return false;
                }
            }
        }


        return stack.isEmpty();
    }
}
