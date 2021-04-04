package dp.sum.can_sum;

import dp.model.DpCalcType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CanSum {

    private final ICanSum canSum;

    public CanSum(DpCalcType dpCalcType) {
        switch (dpCalcType) {
            case MEMO:
                canSum = new MemoCanSum();
                break;
            case TABULATION:
                canSum = new TabCanSum();
                break;
            case RECURSIVE:
            default:
                canSum = new RecursiveCanSum();
                break;
        }
    }

    public boolean find(int sum, int[] arr) {
        return canSum.find(sum, arr);
    }

    private interface ICanSum {
        boolean find(int sum, int[] arr);
    }

    private static class RecursiveCanSum implements ICanSum {

        @Override
        public boolean find(int targetSum, int[] arr) {
            if(targetSum == 0) return true;
            if(targetSum < 0) return false;

            for (int i : arr) {
                var remainder = targetSum - i;
                if(find(remainder, arr)) {
                    return true;
                }
            }

            return false;
        }
    }

    private static class MemoCanSum implements ICanSum {

        @Override
        public boolean find(int targetSum, int[] arr) {
            var map = new HashMap<Integer, Boolean>();
            var result = find(targetSum, arr, map);
            System.out.println(map);
            return result;
        }

        private boolean find(int targetSum, int[] arr, Map<Integer, Boolean> map) {
            if(map.containsKey(targetSum)) return map.get(targetSum);

            if(targetSum == 0) return true;
            if(targetSum < 0) return false;

            for (int i : arr) {
                var remainder = targetSum - i;
                if(find(remainder, arr, map)) {
                    map.put(targetSum, true);
                    return true;
                }
            }

            map.put(targetSum, false);
            return false;
        }
    }

    private static class TabCanSum implements ICanSum {

        @Override
        public boolean find(int targetSum, int[] arr) {
            boolean[] tab = new boolean[targetSum+1];
            Arrays.fill(tab, false);

            tab[0] = true;

            for (int i = 0; i <= targetSum; i++) {
                if(tab[i]) {
                    for (int num : arr) {
                        if(i+num <= targetSum) tab[i+num] = true;
                    }
                }
            }

            System.out.println(Arrays.toString(tab));

            return tab[targetSum];
        }
    }
}

