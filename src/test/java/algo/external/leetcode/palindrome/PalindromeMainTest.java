package algo.external.leetcode.palindrome;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeMainTest {

    @Test
    void test() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            var ages = new ArrayList<Integer>();
            Collections.addAll(ages, 7, 14, 19, 22, 49, 49);
            for (int age : ages) {
                if (age >= 40) ages.remove(age);
            }
            var sum = ages.stream().mapToInt(Integer::intValue).sum();
            System.out.println(sum);
        });
    }

    @Test
    void test_1() {
        assertFalse(PalindromeMain.isPalindrome("Hello"));
    }

    @Test
    void test_2() {
        assertTrue(PalindromeMain.isPalindrome("I did, did I?"));
    }

    @Test
    void test_3() {
        assertTrue(PalindromeMain.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    void test_4() {
        assertTrue(PalindromeMain.isPalindrome(".,"));
    }

}