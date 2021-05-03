package algo.external.gfg.kth_non_repeating;

import java.util.LinkedHashMap;
import java.util.Map;

public class KthNonRepeatingMain {
    public static void main(String[] args) {
        System.out.println(find(new int[] {2,3,4,2,4,5,6,3,5,7,5,8}, 3));
    }

    private static int find(int[] arr, int k) {
        LinkedHashMap<Integer, Integer> countMap = new LinkedHashMap<>();

        for (int i : arr) {
            var count = countMap.getOrDefault(i, 0);
            countMap.put(i, count+1);
        }

        int skipCOunter = k;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if(entry.getValue() == 1) {
                skipCOunter--;

                if(skipCOunter == 0) {
                    return entry.getKey();
                }

            }
        }

        return -1;
    }
}
