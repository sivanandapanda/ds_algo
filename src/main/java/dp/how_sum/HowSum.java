package dp.how_sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO modify code to return all combinations instead of 1
 */
public class HowSum {
    public static void main(String[] args) {
        int sum = 8;
        //int[] arr = {5, 3};
        //int[] arr = {5, 3, 4, 7};
        int[] arr = {3, 5, 2};

        IHowSum howSum = new MemoHowSum();
        System.out.println(howSum.find(sum, arr));
    }

}

interface IHowSum {
    List<Integer> find(int sum, int[] arr);
}

class RecursiveHowSum implements IHowSum {

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

class MemoHowSum implements IHowSum {

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