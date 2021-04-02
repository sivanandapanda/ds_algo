package dp.construct.count_construct;

import dp.model.DpCalcType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CountConstructTest {
    private static CountConstruct countConstruct;

    @BeforeAll
    public static void setup() {
        countConstruct = new CountConstruct(DpCalcType.MEMO);
    }

    @Test
    void test_purple() {
        assertEquals(2, countConstruct.count("purple", List.of("purp", "p", "ur", "le", "purpl")));
    }

    @Test
    void test_abcdef() {
        assertEquals(1, countConstruct.count("abcdef", List.of("ab", "abc", "cd", "def", "abcd")));
    }

    @Test
    void test_skateboard() {
        assertNotEquals(1, countConstruct.count("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar")));
    }

    @Test
    void test_enterapotentpot() {
        assertEquals(4, countConstruct.count("enterapotentpot", List.of("a", "p", "ent", "enter", "ot", "o", "t")));
    }

    @Test
    void test_eeeeef() {
        assertEquals(0, countConstruct.count("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                List.of("e", "ee", "eee", "eeee", "eeeeee", "eeeeeeeeeee")));
    }
}