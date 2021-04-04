package dp.sum.can_sum;

import dp.model.DpCalcType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CanSumTest {

    @Test
    void test_recursive() {
        CanSum canSum = new CanSum(DpCalcType.RECURSIVE);
        int[] arr = {5, 3, 4, 7};
        var targetSum = 8;
        assertTrue(canSum.find(targetSum, arr));
    }

    @Test
    void test_memo() {
        CanSum canSum = new CanSum(DpCalcType.MEMO);
        int[] arr = {5, 3, 4, 7};
        var targetSum = 8;
        assertTrue(canSum.find(targetSum, arr));
    }

    @Test
    void test_memo_3000() {
        CanSum canSum = new CanSum(DpCalcType.MEMO);
        int[] arr = {5, 3, 4, 7};
        var targetSum = 3000;
        assertTrue(canSum.find(targetSum, arr));
    }

    @Test
    void test_memo_300() {
        CanSum canSum = new CanSum(DpCalcType.MEMO);
        int[] arr = {7, 14};
        var targetSum = 300;
        assertFalse(canSum.find(targetSum, arr));
    }

    @Test
    void test_tab() {
        CanSum canSum = new CanSum(DpCalcType.TABULATION);
        int[] arr = {5, 3, 4, 7};
        var targetSum = 8;
        assertTrue(canSum.find(targetSum, arr));
    }

    @Test
    void test_tab_2() {
        CanSum canSum = new CanSum(DpCalcType.TABULATION);
        int[] arr = {5, 3, 4, 7};
        var targetSum = 2;
        assertFalse(canSum.find(targetSum, arr));
    }

    @Test
    void test_tab_3000() {
        CanSum canSum = new CanSum(DpCalcType.TABULATION);
        int[] arr = {5, 3, 4, 7};
        var targetSum = 3000;
        assertTrue(canSum.find(targetSum, arr));
    }

    @Test
    void test_tab_300() {
        CanSum canSum = new CanSum(DpCalcType.TABULATION);
        int[] arr = {7, 14};
        var targetSum = 300;
        assertFalse(canSum.find(targetSum, arr));
    }
}