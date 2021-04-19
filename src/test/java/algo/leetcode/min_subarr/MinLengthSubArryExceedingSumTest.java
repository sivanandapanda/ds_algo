package algo.leetcode.min_subarr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinLengthSubArryExceedingSumTest {

    @Test
    void test_1() {
        int[] arr = {2,3,1,2,4,3};
        assertEquals(2, MinLengthSubArryExceedingSum.find(arr, 7));
    }

    @Test
    void test_1_1() {
        int[] arr = {2,3,1,2,4,3};
        assertEquals(2, MinLengthSubArryExceedingSum.find(arr, 6));
    }

    @Test
    void test_2() {
        int[] arr = {1,4,4};
        assertEquals(1, MinLengthSubArryExceedingSum.find(arr, 4));
    }

    @Test
    void test_2_1() {
        int[] arr = {1,4,4};
        assertEquals(3, MinLengthSubArryExceedingSum.find(arr, 9));
    }

    @Test
    void test_3() {
        int[] arr = {1,1,1,1,1,1,1,1};
        assertEquals(0, MinLengthSubArryExceedingSum.find(arr, 11));
    }

}