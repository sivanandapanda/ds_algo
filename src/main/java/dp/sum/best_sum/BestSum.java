package dp.sum.best_sum;

import dp.model.DpCalcType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSum {

    private final IBestSum bestSum;

    public BestSum(DpCalcType dpCalcType) {
        switch (dpCalcType) {
            case MEMO:
                this.bestSum = new MemoBestSum();
                break;
            case RECURSIVE:
            default:
                this.bestSum = new RecursiveBestSum();
                break;
        }
    }

    public List<Integer> find(int targetSum, int[] numbers) {
        return bestSum.find(targetSum, numbers);
    }

    private interface IBestSum {
        List<Integer> find(int sum, int[] numbers);
    }

    private static class RecursiveBestSum implements IBestSum {

        @Override
        public List<Integer> find(int targetSum, int[] numbers) {
            if(targetSum == 0) return new ArrayList<>();
            if(targetSum < 0) return null;

            List<Integer> shortestCombination = null;

            for (var num : numbers) {
                var remainder = targetSum - num;
                var list = find(remainder, numbers);
                if(list != null) {
                    var combinations = new ArrayList<>(list);
                    combinations.add(num);

                    if(shortestCombination == null || combinations.size() < shortestCombination.size()) {
                        shortestCombination = combinations;
                    }
                }
            }

            return shortestCombination;
        }
    }

    private static class MemoBestSum implements IBestSum {

        @Override
        public List<Integer> find(int targetSum, int[] numbers) {
            return find(targetSum, numbers, new HashMap<>());
        }

        private List<Integer> find(int targetSum, int[] numbers, Map<Integer, List<Integer>> map) {
            if(map.containsKey(targetSum)) return map.get(targetSum);

            if(targetSum == 0) return new ArrayList<>();
            if(targetSum < 0) return null;

            List<Integer> shortestCombination = null;

            for (var num : numbers) {
                var remainder = targetSum - num;
                var list = find(remainder, numbers, map);
                if(list != null) {
                    var combinations = new ArrayList<>(list);
                    combinations.add(num);

                    if(shortestCombination == null || combinations.size() < shortestCombination.size()) {
                        shortestCombination = combinations;
                    }
                }
            }

            map.put(targetSum, shortestCombination);

            return shortestCombination;
        }
    }

}