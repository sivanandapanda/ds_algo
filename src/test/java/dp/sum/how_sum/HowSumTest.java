package dp.sum.how_sum;

import dp.model.DpCalcType;
import org.junit.jupiter.api.Test;

class HowSumTest {

    @Test
    void test_recursive() {
        HowSum howSum = new HowSum(DpCalcType.RECURSIVE);
        int[] arr = {5, 3, 4, 7};
        var targetSum = 8;
        var actual = howSum.find(targetSum, arr);
        System.out.println(actual);
    }

    @Test
    void test_memo() {
        HowSum howSum = new HowSum(DpCalcType.MEMO);
        int[] arr = {5, 3, 4, 7};
        var targetSum = 8;
        var actual = howSum.find(targetSum, arr);
        System.out.println(actual);
    }

    @Test
    void test_memo_3000() {
        HowSum howSum = new HowSum(DpCalcType.MEMO);
        int[] arr = {5, 3, 4, 7};
        var targetSum = 8;
        var actual = howSum.find(targetSum, arr);
        System.out.println(actual);
    }

    @Test
    void test_tab() {
        HowSum howSum = new HowSum(DpCalcType.TABULATION);
        int[] arr = {5, 3, 4, 7};
        var targetSum = 8;
        var actual = howSum.find(targetSum, arr);
        System.out.println(actual);
    }

    @Test
    void test_tab_8() {
        HowSum howSum = new HowSum(DpCalcType.TABULATION);
        int[] arr = {2, 3, 4};
        var targetSum = 8;
        var actual = howSum.find(targetSum, arr);
        System.out.println(actual);
    }

    @Test
    void test_tab_3000() {
        HowSum howSum = new HowSum(DpCalcType.TABULATION);
        int[] arr = {5, 3, 4, 7};
        var targetSum = 3000;
        var actual = howSum.find(targetSum, arr);
        System.out.println(actual);
    }
}