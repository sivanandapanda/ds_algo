package algo.gfg.first_non_repeating;

import java.util.*;

public class FirstNonRepeatingMain {

    public static void main(String[] args) {
        System.out.println(find(new int[] {2,3,4,2,4,5,6,3,5,7}));
    }

    private static int find(int[] arr) {
        LinkedHashMap<Integer, Integer> countMap = new LinkedHashMap<>();

        for (int i : arr) {
            var count = countMap.getOrDefault(i, 0);
            countMap.put(i, count+1);
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if(entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }

}
