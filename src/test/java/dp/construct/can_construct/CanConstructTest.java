package dp.construct.can_construct;

import dp.model.DpCalcType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CanConstructTest {

    private static CanConstruct canConstruct;

    @BeforeAll
    public static void setup() {
        canConstruct = new CanConstruct(DpCalcType.MEMO);
    }

    @Test
    void test() {
        System.out.println("potato".indexOf("pot"));
        System.out.println("potato".substring("pot".length()));
    }

    @Test
    void test_abcdef() {
        assertTrue(canConstruct.find("abcdef", List.of("ab", "abc", "cd", "def", "abcd")));
    }

    @Test
    void test_skateboard() {
        assertFalse(canConstruct.find("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar")));
    }

    @Test
    void test_enterapotentpot() {
        assertTrue(canConstruct.find("enterapotentpot", List.of("a", "p", "ent", "enter", "ot", "o", "t")));
    }

    @Test
    void test_eeeeef() {
        assertFalse(canConstruct.find("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                List.of("e", "ee", "eee", "eeee", "eeeeee", "eeeeeeeeeee")));
    }
}