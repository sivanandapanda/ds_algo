package dp.construct.can_construct;

import dp.model.DpCalcType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CanConstructTest {

    @Test
    void test() {
        System.out.println("potato".indexOf("pot"));
        System.out.println("potato".substring("pot".length()));
    }

    @Test
    void test_abcdef() {
        var canConstruct = new CanConstruct(DpCalcType.RECURSIVE);
        assertTrue(canConstruct.find("abcdef", List.of("ab", "abc", "cd", "def", "abcd")));
    }

    @Test
    void test_skateboard() {
        var canConstruct = new CanConstruct(DpCalcType.RECURSIVE);
        assertFalse(canConstruct.find("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar")));
    }

    @Test
    void test_enterapotentpot() {
        var canConstruct = new CanConstruct(DpCalcType.RECURSIVE);
        assertTrue(canConstruct.find("enterapotentpot", List.of("a", "p", "ent", "enter", "ot", "o", "t")));
    }

    @Test
    void test_memo_abcdef() {
        var canConstruct = new CanConstruct(DpCalcType.MEMO);
        assertTrue(canConstruct.find("abcdef", List.of("ab", "abc", "cd", "def", "abcd")));
    }

    @Test
    void test_memo_skateboard() {
        var canConstruct = new CanConstruct(DpCalcType.MEMO);
        assertFalse(canConstruct.find("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar")));
    }

    @Test
    void test_memo_enterapotentpot() {
        var canConstruct = new CanConstruct(DpCalcType.MEMO);
        assertTrue(canConstruct.find("enterapotentpot", List.of("a", "p", "ent", "enter", "ot", "o", "t")));
    }

    @Test
    void test_memo_eeeeef() {
        var canConstruct = new CanConstruct(DpCalcType.MEMO);
        assertFalse(canConstruct.find("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                List.of("e", "ee", "eee", "eeee", "eeeeee", "eeeeeeeeeee")));
    }

    @Test
    void test_tab_abcdef() {
        var canConstruct = new CanConstruct(DpCalcType.TABULATION);
        assertTrue(canConstruct.find("abcdef", List.of("ab", "abc", "cd", "def", "abcd","abcdefg")));
    }

    @Test
    void test_tab_skateboard() {
        var canConstruct = new CanConstruct(DpCalcType.TABULATION);
        assertFalse(canConstruct.find("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar")));
    }

    @Test
    void test_tab_enterapotentpot() {
        var canConstruct = new CanConstruct(DpCalcType.TABULATION);
        assertTrue(canConstruct.find("enterapotentpot", List.of("a", "p", "ent", "enter", "ot", "o", "t")));
    }

    @Test
    void test_tab_eeeeef() {
        var canConstruct = new CanConstruct(DpCalcType.TABULATION);
        assertFalse(canConstruct.find("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                List.of("e", "ee", "eee", "eeee", "eeeeee", "eeeeeeeeeee")));
    }
}