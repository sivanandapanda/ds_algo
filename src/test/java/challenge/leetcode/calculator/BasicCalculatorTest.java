package challenge.leetcode.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BasicCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1+2+3,6","(1+(4+5+2)-3)+(6+8),23", " 2-1 + 2 ,3"})
    void test(String input, int expected) {
        BasicCalculator calculator = new BasicCalculator();
        assertEquals(expected, calculator.calculate(input));
    }

    @Test
    void test_empty_string() {
        BasicCalculator calculator = new BasicCalculator();
        assertEquals(0, calculator.calculate(""));
    }

    @Test
    void test_invalid_expression() {
        BasicCalculator calculator = new BasicCalculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate("(1+2[3)]"));
    }
}