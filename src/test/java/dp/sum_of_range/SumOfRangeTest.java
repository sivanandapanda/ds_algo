package dp.sum_of_range;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfRangeTest {

    @Test
    void test() {
        int[] arr = {8, 1, 2, 4, 6, 3};

        SumOfRange sumOfRange = new SumOfRange(arr);

        assertEquals(12, sumOfRange.sumRange(2, 4));
    }
}