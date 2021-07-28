package challenge.leetcode.missing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstMissingIntegerTest {

    @Test
    void test() {
        FirstMissingInteger firstMissingInteger = new FirstMissingInteger();

        assertEquals(3, firstMissingInteger.find(new int[]{1, 2, 0}));

        assertEquals(2, firstMissingInteger.find(new int[]{3,4,-1,1}));

        assertEquals(1, firstMissingInteger.find(new int[]{7,8,9,11,12}));
    }

}