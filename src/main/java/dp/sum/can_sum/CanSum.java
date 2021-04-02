package dp.sum.can_sum;

import java.util.HashMap;
import java.util.Map;

public class CanSum {

    public static void main(String[] args) {
        int sum = 3000;
        int[] arr = {5, 3};
        //int[] arr = {5, 3, 4, 7};

        ICanSum canSum = new MemoCanSum();
        System.out.println(canSum.find(sum, arr));
    }
}

interface ICanSum {
    boolean find(int sum, int[] arr);
}

class RecursiveCanSum implements ICanSum {

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

class MemoCanSum implements ICanSum {

    @Override
    public boolean find(int targetSum, int[] arr) {
        return find(targetSum, arr, new HashMap<>());
    }

    private boolean find(int targetSum, int[] arr, Map<Integer, Boolean> map) {
        if(map.containsKey(targetSum)) return map.get(targetSum);

        if(targetSum == 0) return true;
        if(targetSum < 0) return false;

        for (int i : arr) {
            var remainder = targetSum - i;
            if(find(remainder, arr)) {
                map.put(targetSum, true);
                return true;
            }
        }

        map.put(targetSum, false);
        return false;
    }
}