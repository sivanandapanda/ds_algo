package dp.longest_inc_subseq;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestIncreasingSubsequenceTest {

    @Test
    void test() {
        int[] arr = {11, 23, 10, 37, 21};

        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence(arr);

        assertEquals(3, lis.lis());
    }
}