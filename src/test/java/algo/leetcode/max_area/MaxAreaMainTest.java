package algo.leetcode.max_area;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxAreaMainTest {

    @Test
    void test_1() {
        int[] heightArr = {4,3,2,1,4};
        assertEquals(16, MaxAreaMain.maxArea(heightArr));
    }

    @Test
    void test_2() {
        int[] heightArr = {1,2,1};
        assertEquals(2, MaxAreaMain.maxArea(heightArr));
    }

    @Test
    void test_3() {
        int[] heightArr = {1,8,6,2,5,4,8,3,7};
        assertEquals(49, MaxAreaMain.maxArea(heightArr));
    }

    @Test
    void test_4() {
        int[] heightArr = {1,1};
        assertEquals(1, MaxAreaMain.maxArea(heightArr));
    }

    @Test
    void test_5() {
        int[] heightArr = {2,3,10,5,7,8,9};
        assertEquals(36, MaxAreaMain.maxArea(heightArr));
    }

}