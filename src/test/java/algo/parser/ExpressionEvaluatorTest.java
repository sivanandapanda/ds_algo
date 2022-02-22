package algo.parser;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpressionEvaluatorTest {
    @Test
    void test_1() {
        ExpiryTenorParser parser = new ExpiryTenorParser(Map.of("1M40Y", 140, "10Y40Y", 1040));
        var input = "1M40Y+10Y40Y";
        assertEquals("140+1040", parser.parse(input));
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        assertEquals(1180, evaluator.evaluateExpression(parser.parse(input)));
    }

    @Test
    void test_2() {
        ExpiryTenorParser parser = new ExpiryTenorParser(Map.of("1M40Y", 140, "10Y40Y", 1040, "2M2Y", 22));
        var input = "(1M40Y+(10Y40Y-2M2Y) * 2) / 2";
        assertEquals("(140+(1040-22) * 2) / 2", parser.parse(input));
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        assertEquals(1088, evaluator.evaluateExpression(parser.parse(input)));
    }

    @Test
    void test_3() {
        ExpiryTenorParser parser = new ExpiryTenorParser(Map.of("1M40Y", 140, "10Y40Y", 1040, "2M2Y", 22));
        var input = "(1M40Y+(10Y40Y-2M2Y) * 2)";
        assertEquals("(140+(1040-22) * 2)", parser.parse(input));
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        assertEquals(2176, evaluator.evaluateExpression(parser.parse(input)));
    }

    @Test
    void test_with_negative_number() {
        ExpiryTenorParser parser = new ExpiryTenorParser(Map.of("1M40Y", 140, "10Y40Y", 1040, "2M2Y", -22));
        var input = "(1M40Y+(10Y40Y- 2M2Y) * 2)";
        assertEquals("(140+(1040- -22) * 2)", parser.parse(input));
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        assertEquals(2264, evaluator.evaluateExpression(parser.parse(input)));
    }
}