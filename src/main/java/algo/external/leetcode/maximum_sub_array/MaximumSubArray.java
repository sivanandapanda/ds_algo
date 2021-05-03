package algo.external.leetcode.maximum_sub_array;

import java.util.Map;

public class MaximumSubArray {
    public static void main(String[] args) {

        //int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //int[] arr = new int[]{-2, 2, 2};
        int[] arr = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};

        //Map<String, Integer> cache = new HashMap<>();

        //find(arr, 0, arr.length, cache);
        find2(arr);
    }

    private static void find2(int[] arr) {

        int maxEndingHere = 0 , maxSoFar = 0;

        for (int j : arr) {
            maxEndingHere = Math.max(0, maxEndingHere + j);

            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
            }
        }

        System.out.println(maxSoFar);
    }

    private static int find(int[] arr, int start, int end, Map<String, Integer> cache) {

        if(start == end) {
            return arr[start];
        }

        StringBuilder builder = new StringBuilder();

        int i = start;
        while(i <=end ) {
            builder.append(arr[i]);
            i++;
        }

        if(!cache.containsKey(builder.toString()))  {

        }

        return cache.get(builder.toString());
    }

}
