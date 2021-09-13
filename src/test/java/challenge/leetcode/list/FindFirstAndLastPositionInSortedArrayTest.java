package challenge.leetcode.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindFirstAndLastPositionInSortedArrayTest {
    @Test
    void test1() {
        assertArrayEquals(new int[]{0, 2}, new FindFirstAndLastPositionInSortedArray().searchRange(new int[]{3, 3, 3}, 3));
    }

    @Test
    void test2() {
        assertArrayEquals(new int[]{1, 3}, new FindFirstAndLastPositionInSortedArray().searchRange(new int[]{1, 3, 3, 3, 7}, 3));
    }

    @Test
    void test3() {
        assertArrayEquals(new int[]{3, 4}, new FindFirstAndLastPositionInSortedArray().searchRange(new int[]{5,7,7,8,8,10}, 8));
    }

    @Test
    void test4() {
        assertArrayEquals(new int[]{0, 0}, new FindFirstAndLastPositionInSortedArray().searchRange(new int[]{1, 3}, 1));
    }

    @Test
    void test5() {
        assertArrayEquals(new int[]{1, 1}, new FindFirstAndLastPositionInSortedArray().searchRange(new int[]{1,2, 3}, 2));
    }
}