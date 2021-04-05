package dp.construct.all_construct;

import dp.model.DpCalcType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AllConstructTest {

    @Test
    void test_purple() {
        var allConstruct = new AllConstruct(DpCalcType.RECURSIVE);
        var lists = allConstruct.find("purple", List.of("purp", "p", "ur", "le", "purpl"));
        System.out.println(lists);
        assertEquals(2, lists.size());
    }

    @Test
    void test_abcdef() {
        var allConstruct = new AllConstruct(DpCalcType.RECURSIVE);
        var lists = allConstruct.find("abcdef", List.of("ab", "abc", "cd", "def", "abcd", "ef", "c"));
        System.out.println(lists);
        assertEquals(4, lists.size());
    }

    @Test
    void test_skateboard() {
        var allConstruct = new AllConstruct(DpCalcType.RECURSIVE);
        var lists = allConstruct.find("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar"));
        System.out.println(lists);
        assertEquals(0, lists.size());
    }

    @Test
    void test_memo_purple() {
        var allConstruct = new AllConstruct(DpCalcType.MEMO);
        var lists = allConstruct.find("purple", List.of("purp", "p", "ur", "le", "purpl"));
        System.out.println(lists);
        assertEquals(2, lists.size());
    }

    @Test
    void test_memo_abcdef() {
        var allConstruct = new AllConstruct(DpCalcType.MEMO);
        var lists = allConstruct.find("abcdef", List.of("ab", "abc", "cd", "def", "abcd", "ef", "c"));
        System.out.println(lists);
        assertEquals(4, lists.size());
    }

    @Test
    void test_memo_skateboard() {
        var allConstruct = new AllConstruct(DpCalcType.MEMO);
        var lists = allConstruct.find("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar"));
        System.out.println(lists);
        assertEquals(0, lists.size());
    }

    @Test
    void test_memo_enterapotentpot() {
        var allConstruct = new AllConstruct(DpCalcType.MEMO);
        var lists = allConstruct.find("enterapotentpot", List.of("a", "p", "ent", "enter", "ot", "o", "t"));
        System.out.println(lists);
        assertEquals(4, lists.size());
    }

    @Test
    void test_memo_eeeeef() {
        var allConstruct = new AllConstruct(DpCalcType.MEMO);
        var lists = allConstruct.find("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                List.of("e", "ee", "eee", "eeee", "eeeeee", "eeeeeeeeeee"));
        System.out.println(lists);
        assertEquals(0, lists.size());
    }

    @Test
    void test_tab_purple() {
        var allConstruct = new AllConstruct(DpCalcType.TABULATION);
        var lists = allConstruct.find("purple", List.of("purp", "p", "ur", "le", "purpl"));
        System.out.println(lists);
        assertEquals(2, lists.size());
    }

    @Test
    void test_tab_abcdef() {
        var allConstruct = new AllConstruct(DpCalcType.TABULATION);
        var lists = allConstruct.find("abcdef", List.of("ab", "abc", "cd", "def", "abcd", "ef", "c"));
        System.out.println(lists);
        assertEquals(4, lists.size());
    }

    @Test
    void test_tab_skateboard() {
        var allConstruct = new AllConstruct(DpCalcType.TABULATION);
        var lists = allConstruct.find("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar"));
        System.out.println(lists);
        assertEquals(0, lists.size());
    }

    @Test
    void test_tab_enterapotentpot() {
        var allConstruct = new AllConstruct(DpCalcType.TABULATION);
        var lists = allConstruct.find("enterapotentpot", List.of("a", "p", "ent", "enter", "ot", "o", "t"));
        System.out.println(lists);
        assertEquals(4, lists.size());
    }

    @Test
    void test_tab_eeeeef() {
        var allConstruct = new AllConstruct(DpCalcType.TABULATION);
        var lists = allConstruct.find("eeeeeeeeeeeef",
                List.of("e", "ee", "eee", "eeee", "eeeeee", "eeeeeeeeeee"));
        System.out.println(lists);
        assertEquals(0, lists.size());
    }

}