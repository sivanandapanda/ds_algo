package algo.leetcode.trap_rain_water;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrapRainWaterMainTest {

    @Test
    void test_1() {
        int[] heightArr = {0,1,0,2,1,0,1,3,2,1,2,1};
        assertEquals(6, TrapRainWaterMain.trap(heightArr));
    }

    @Test
    void test_2() {
        int[] heightArr = {4,2,0,3,2,5};
        assertEquals(9, TrapRainWaterMain.trap(heightArr));
    }

    @Test
    void test_3() {
        int[] heightArr =  {0,2,0};
        assertEquals(0, TrapRainWaterMain.trap(heightArr));
    }

    @Test
    void test_4() {
        int[] heightArr = {4,2,3};
        assertEquals(1, TrapRainWaterMain.trap(heightArr));
    }

    @Test
    void test_5() {
        int[] heightArr = {5,5,1,7,1,1,5,2,7,6};
        assertEquals(23, TrapRainWaterMain.trap(heightArr));
    }

    @Test
    void test_6() {
        int[] heightArr = {0,1,2,0,3,0,1,2,0,0,4,2,1,2,5,0,1,2,0,2};
        assertEquals(26, TrapRainWaterMain.trap(heightArr));
    }

}