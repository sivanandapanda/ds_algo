package dp.sum.best_sum;

import dp.model.DpCalcType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BestSumTest {

    @Test
    void test_1() {
        var bestSum = new BestSum(DpCalcType.RECURSIVE);
        int[] arr = {5, 3, 4, 7};
        assertEquals(List.of(7), bestSum.find(7, arr));
    }

    @Test
    void test_8_1() {
        var bestSum = new BestSum(DpCalcType.RECURSIVE);
        int[] arr = {2, 3, 5};
        List<Integer> actual = bestSum.find(8, arr);

        assertEquals(2, actual.size());
        assertTrue(actual.contains(5));
        assertTrue(actual.contains(3));
    }

    @Test
    void test_8_2() {
        var bestSum = new BestSum(DpCalcType.RECURSIVE );
        int[] arr = {1, 4, 5};
        assertEquals(List.of(4, 4), bestSum.find(8, arr));
    }

    @Test
    void test_memo_1() {
        var bestSum = new BestSum(DpCalcType.MEMO);
        int[] arr = {5, 3, 4, 7};
        assertEquals(List.of(7), bestSum.find(7, arr));
    }

    @Test
    void test_memo_8_1() {
        var bestSum = new BestSum(DpCalcType.MEMO);
        int[] arr = {2, 3, 5};
        List<Integer> actual = bestSum.find(8, arr);

        assertEquals(2, actual.size());
        assertTrue(actual.contains(5));
        assertTrue(actual.contains(3));
    }

    @Test
    void test_memo_8_2() {
        var bestSum = new BestSum(DpCalcType.MEMO);
        int[] arr = {1, 4, 5};
        assertEquals(List.of(4, 4), bestSum.find(8, arr));
    }

    @Test
    void test_memo_100() {
        var bestSum = new BestSum(DpCalcType.MEMO);
        int[] arr = {1, 2, 5, 25};
        assertEquals(List.of(25, 25, 25, 25), bestSum.find(100, arr));
    }

    @Test
    void test_tab_100() {
        var bestSum = new BestSum(DpCalcType.TABULATION);
        int[] arr = {1, 2, 5, 25};
        assertEquals(List.of(25, 25, 25, 25), bestSum.find(100, arr));
    }

    @Test
    void test_tab_8_2() {
        var bestSum = new BestSum(DpCalcType.TABULATION);
        int[] arr = {1, 4, 5};
        assertEquals(List.of(4, 4), bestSum.find(8, arr));
    }

}