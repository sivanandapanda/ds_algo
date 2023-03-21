package challenge.leetcode.duplicates;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainsDuplicateTest {

    @Test
    void test_duplicates() {
        assertFalse(new ContainsDuplicate().containsDuplicate(new int[]{1, 2, 3, 4}));
        assertTrue(new ContainsDuplicate().containsDuplicate(new int[]{1, 3, 3, 4}));
        assertTrue(new ContainsDuplicate().containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

}