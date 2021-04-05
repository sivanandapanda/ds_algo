package dp.construct.count_construct;

import dp.model.DpCalcType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CountConstructTest {

    @Test
    void test_purple() {
        var countConstruct = new CountConstruct(DpCalcType.RECURSIVE);
        assertEquals(2, countConstruct.count("purple", List.of("purp", "p", "ur", "le", "purpl")));
    }

    @Test
    void test_abcdef() {
        var countConstruct = new CountConstruct(DpCalcType.RECURSIVE);
        assertEquals(1, countConstruct.count("abcdef", List.of("ab", "abc", "cd", "def", "abcd")));
    }

    @Test
    void test_memo_purple() {
        var countConstruct = new CountConstruct(DpCalcType.MEMO);
        assertEquals(2, countConstruct.count("purple", List.of("purp", "p", "ur", "le", "purpl")));
    }

    @Test
    void test_memo_abcdef() {
        var countConstruct = new CountConstruct(DpCalcType.MEMO);
        assertEquals(1, countConstruct.count("abcdef", List.of("ab", "abc", "cd", "def", "abcd")));
    }

    @Test
    void test_memo_skateboard() {
        var countConstruct = new CountConstruct(DpCalcType.MEMO);
        assertNotEquals(1, countConstruct.count("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar")));
    }

    @Test
    void test_memo_enterapotentpot() {
        var countConstruct = new CountConstruct(DpCalcType.MEMO);
        assertEquals(4, countConstruct.count("enterapotentpot", List.of("a", "p", "ent", "enter", "ot", "o", "t")));
    }

    @Test
    void test_memo_eeeeef() {
        var countConstruct = new CountConstruct(DpCalcType.MEMO);
        assertEquals(0, countConstruct.count("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                List.of("e", "ee", "eee", "eeee", "eeeeee", "eeeeeeeeeee")));
    }

    @Test
    void test_tab_purple() {
        var countConstruct = new CountConstruct(DpCalcType.TABULATION);
        assertEquals(2, countConstruct.count("purple", List.of("purp", "p", "ur", "le", "purpl")));
    }

    @Test
    void test_tab_abcdef() {
        var countConstruct = new CountConstruct(DpCalcType.TABULATION);
        assertEquals(1, countConstruct.count("abcdef", List.of("ab", "abc", "cd", "def", "abcd")));
    }

    @Test
    void test_tab_skateboard() {
        var countConstruct = new CountConstruct(DpCalcType.TABULATION);
        assertNotEquals(1, countConstruct.count("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar")));
    }

    @Test
    void test_tab_enterapotentpot() {
        var countConstruct = new CountConstruct(DpCalcType.TABULATION);
        assertEquals(4, countConstruct.count("enterapotentpot", List.of("a", "p", "ent", "enter", "ot", "o", "t")));
    }

    @Test
    void test_tab_eeeeef() {
        var countConstruct = new CountConstruct(DpCalcType.TABULATION);
        assertEquals(0, countConstruct.count("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                List.of("e", "ee", "eee", "eeee", "eeeeee", "eeeeeeeeeee")));
    }
}