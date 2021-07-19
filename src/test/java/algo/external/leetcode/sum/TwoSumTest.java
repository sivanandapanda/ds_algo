package algo.external.leetcode.sum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    void test1() {
        assertArrayEquals(new int[]{0, 1}, new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9));
    }

    @Test
    void test2() {
        assertArrayEquals(new int[]{1, 2}, new TwoSum().twoSum(new int[]{3,2,4}, 6));
    }

    @Test
    void test3() {
        assertArrayEquals(new int[]{0, 1}, new TwoSum().twoSum(new int[]{3,3}, 6));
    }

    @Test
    void test4() {
        assertArrayEquals(new int[]{1, 2}, new TwoSum().twoSum(new int[]{4, 3, 3}, 6));
    }

}