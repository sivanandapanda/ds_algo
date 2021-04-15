package algo.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DutchNationalFlagMainTest {

    @Test
    void test_1() {
        var input = new int[]{0, 1, 2, 0, 1, 2};
        DutchNationalFlagMain.sort(input);
        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, input);
    }

    @Test
    void test_2() {
        var input = new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        DutchNationalFlagMain.sort(input);
        assertArrayEquals(new int[]{0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}, input);
    }

    @Test
    void test_3() {
        var input = new int[]{2, 0, 1};
        DutchNationalFlagMain.sort(input);
        System.out.println(Arrays.toString(input));
        assertArrayEquals(new int[]{0, 1, 2}, input);
    }

}