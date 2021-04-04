package dp.sum.best_sum;

import dp.model.DpCalcType;

import java.util.*;

public class BestSum {

    private final IBestSum bestSum;

    public BestSum(DpCalcType dpCalcType) {
        switch (dpCalcType) {
            case MEMO:
                this.bestSum = new MemoBestSum();
                break;
            case TABULATION:
                this.bestSum = new TabBestSum();
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

    private static class TabBestSum implements IBestSum {

        @Override
        public List<Integer> find(int targetSum, int[] numbers) {
            List<Integer>[] tab = new List[targetSum+1];
            tab[0] = new ArrayList<>();

            for (int i = 0; i <= targetSum; i++) {
                if(tab[i] != null) {
                    for (int num : numbers) {
                        try {
                            if(i+num <= targetSum) {
                                var combinations = new ArrayList<>(tab[i]);
                                combinations.add(num);
                                if(tab[i + num] == null || tab[i + num].size() > combinations.size()) {
                                    tab[i + num] = combinations;
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("targetSum = " + targetSum + ", i = " + i + ", num = " + num);
                            e.printStackTrace();
                        }
                    }
                }
            }

            System.out.println(Arrays.toString(tab));

            return tab[targetSum];
        }
    }

}