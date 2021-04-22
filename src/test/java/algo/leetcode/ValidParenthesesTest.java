package algo.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {

    @ParameterizedTest
    @CsvSource(value = {"(),true", "(],false", "()[]{}, true", "{[]}, true", "([)], false",",true"})
    void test(String input, boolean expected) {
        ValidParentheses validParentheses = new ValidParentheses();
        assertEquals(expected, validParentheses.isValid(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"(),true", "(],false", "()[]{}, true", "{[]}, true", "([)], false",",true"})
    void test_2(String input, boolean expected) {
        ValidParentheses validParentheses = new ValidParentheses();
        assertEquals(expected, validParentheses.isValid_2(input));
    }

    @Test
    void test_empty_string() {
        ValidParentheses validParentheses = new ValidParentheses();
        assertTrue(validParentheses.isValid(""));
    }

    @Test
    void test_random_string() {
        ValidParentheses validParentheses = new ValidParentheses();
        assertTrue(validParentheses.isValid("random"));
    }

}