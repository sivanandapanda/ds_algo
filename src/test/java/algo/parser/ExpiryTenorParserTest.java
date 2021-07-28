package algo.parser;

import challenge.leetcode.calculator.BasicCalculator;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExpiryTenorParserTest {

    @Test
    void test_1() {
        ExpiryTenorParser parser = new ExpiryTenorParser(Map.of("1M40Y", 140, "10Y40Y", 1040));
        var input = "1M40Y+10Y40Y";
        assertEquals("140+1040", parser.parse(input));
        BasicCalculator calculator = new BasicCalculator();
        assertEquals(1180, calculator.calculate(parser.parse(input)));
    }

    @Test
    void test_2() {
        ExpiryTenorParser parser = new ExpiryTenorParser(Map.of("1M40Y", 140, "10Y40Y", 1040, "2M2Y", 22));
        var input = "(1M40Y+(10Y40Y-2M2Y) * 2) / 2";
        assertEquals("(140+(1040-22)*2)/2", parser.parse(input));
        BasicCalculator calculator = new BasicCalculator();
        assertEquals(1088, calculator.calculate(parser.parse(input)));
    }

    @Test
    void test_3() {
        ExpiryTenorParser parser = new ExpiryTenorParser(Map.of("1M40Y", 140, "10Y40Y", 1040, "2M2Y", 22));
        var input = "(1M40Y+(10Y40Y-2M2Y) * 2)";
        assertEquals("(140+(1040-22)*2)", parser.parse(input));
        BasicCalculator calculator = new BasicCalculator();
        assertEquals(2176, calculator.calculate(parser.parse(input)));
    }

    @Test
    void test_not_found() {
        ExpiryTenorParser parser = new ExpiryTenorParser(Map.of("1M40Y", 140, "10Y40Y", 1040));
        assertThrows(IllegalArgumentException.class, () -> parser.parse("1M40Y+10Y40Y+2M2Y"));
    }

}