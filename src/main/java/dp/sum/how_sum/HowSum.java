package dp.sum.how_sum;

import dp.model.DpCalcType;

import java.util.*;

public class HowSum {

    private final IHowSum howSum;

    public HowSum(DpCalcType dpCalcType) {
        switch (dpCalcType) {
            case MEMO:
                howSum = new MemoHowSum();
                break;
            case TABULATION:
                howSum = new TabHowSum();
                break;
            case RECURSIVE:
            default:
                howSum = new RecursiveHowSum();
                break;
        }
    }

    public List<Integer> find(int targetSum, int[] arr) {
        return howSum.find(targetSum, arr);
    }

    private interface IHowSum {
        List<Integer> find(int sum, int[] arr);
    }

    private static class RecursiveHowSum implements IHowSum {

        @Override
        public List<Integer> find(int targetSum, int[] arr) {
            if(targetSum == 0) return new ArrayList<>();
            if(targetSum < 0) return null;

            for (int i : arr) {
                var remainder = targetSum - i;
                var list = find(remainder, arr);
                if(list != null) {
                    list.add(i);
                    return list;
                }
            }

            return null;
        }
    }

    private static class MemoHowSum implements IHowSum {

        @Override
        public List<Integer> find(int targetSum, int[] arr) {
            return find(targetSum, arr, new HashMap<>());
        }

        private List<Integer> find(int targetSum, int[] arr, Map<Integer, List<Integer>> map) {
            if(map.containsKey(targetSum)) return map.get(targetSum);

            if(targetSum == 0) return new ArrayList<>();
            if(targetSum < 0) return null;

            for (int i : arr) {
                var remainder = targetSum - i;
                var list = find(remainder, arr);
                if(list != null) {
                    list.add(i);
                    map.put(targetSum, list);
                    return list;
                }

            }

            map.put(targetSum, null);
            return null;
        }
    }

    private static class TabHowSum implements IHowSum {

        @Override
        public List<Integer> find(int targetSum, int[] arr) {
            List<Integer>[] tab = new List[targetSum+1];
            tab[0] = new ArrayList<>();

            for (int i = 0; i <= targetSum; i++) {
                if(tab[i] != null) {
                    for (int num : arr) {
                        try {
                            if(i+num <= targetSum) {
                                var list = new ArrayList<>(tab[i]);
                                list.add(num);
                                tab[i+num] = list;
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