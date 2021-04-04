package dp.construct.all_construct;

import dp.model.DpCalcType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AllConstructTest {

    private static AllConstruct allConstruct;

    @BeforeAll
    public static void setup() {
        allConstruct = new AllConstruct(DpCalcType.MEMO);
    }

    @Test
    void test_purple() {
        var lists = allConstruct.find("purple", List.of("purp", "p", "ur", "le", "purpl"));
        System.out.println(lists);
        assertEquals(2, lists.size());
    }

    @Test
    void test_abcdef() {
        var lists = allConstruct.find("abcdef", List.of("ab", "abc", "cd", "def", "abcd", "ef", "c"));
        System.out.println(lists);
        assertEquals(4, lists.size());
    }

    @Test
    void test_skateboard() {
        var lists = allConstruct.find("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar"));
        System.out.println(lists);
        assertEquals(0, lists.size());
    }

    @Test
    void test_enterapotentpot() {
        var lists = allConstruct.find("enterapotentpot", List.of("a", "p", "ent", "enter", "ot", "o", "t"));
        System.out.println(lists);
        assertEquals(4, lists.size());
    }

    @Test
    void test_eeeeef() {
        var lists = allConstruct.find("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", List.of("e", "ee", "eee", "eeee", "eeeeee", "eeeeeeeeeee"));
        System.out.println(lists);
        assertEquals(0, lists.size());
    }

}