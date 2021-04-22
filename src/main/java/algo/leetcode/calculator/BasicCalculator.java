package algo.leetcode.calculator;

import java.util.ArrayDeque;
import java.util.Queue;

//leetcode 224 https://leetcode.com/problems/basic-calculator/
//leetcode 227 https://leetcode.com/problems/basic-calculator-ii/
//leetcode 772 https://leetcode.com/problems/basic-calculator-iii/
public class BasicCalculator {

    public int calculate(String s) {
        Queue<Character> q = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                q.offer(c);
            }
        }

        q.offer(' ');
        return helper(q);
    }

    private int helper(Queue<Character> q) {
        int num = 0;
        int prev = 0, sum = 0;
        char prevOp = '+';

        while (!q.isEmpty()) {
            char c = q.poll();

            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '(') {
                num = helper(q);
            } else {
                switch (prevOp) {
                    case '+':
                        sum += prev;
                        prev = num;
                        break;
                    case '-':
                        sum += prev;
                        prev = -num;
                        break;
                    case '*':
                        prev *= num;
                        break;
                    case '/':
                        prev /= num;
                        break;
                }

                if (c == ')') break;

                num = 0;
                prevOp = c;
            }
        }

        return sum + prev;
    }
}
