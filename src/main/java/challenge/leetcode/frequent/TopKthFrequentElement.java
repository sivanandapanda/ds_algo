package challenge.leetcode.frequent;

import java.util.*;

//leetcode 347
//https://leetcode.com/problems/top-k-frequent-elements/
public class TopKthFrequentElement {

    //time complexity = O(n + nlogn) (i.e. linear time to populate the map and then nlogn to sort the map)
    //space complexity = O(n) + O(n) + O(k) (i.e. space for new hashMap + new heap + result array)
    int[] topKFrequent(int[] nums, int k) {
        var numberCountMap = new HashMap<Integer, Integer>();
        var result = new int[k];

        for (int currentNumber : nums) {
            var count = numberCountMap.getOrDefault(currentNumber, 0) + 1;
            numberCountMap.put(currentNumber, count);
        }

        var maxHeap = new PriorityQueue<Map.Entry<Integer, Integer>>(
                (a, b) -> a.getValue().equals(b.getValue()) ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()
        );

        numberCountMap.entrySet().forEach(maxHeap::offer);

        for (int i = 0; i < k; i++) {
            var poll = maxHeap.poll();
            if (poll != null) result[i] = poll.getKey();
        }

        return result;
    }
    
    //below solution is also known as bucket sort
    //time complexity = O(n + n) (i.e. linear time to populate the map and then linear time to populate the result array)
    //space complexity = O(n) + O(k) (i.e. space for new hashMap + result array)
    int[] anotherSolution(int[] nums, int k){
        var numberCountMap = new HashMap<Integer, Integer>();
        for (int currentNumber : nums) {
            var count = numberCountMap.getOrDefault(currentNumber, 0) + 1;
            numberCountMap.put(currentNumber, count);
        }

        var bucket = new ArrayList<List<Integer>>(nums.length + 1);
        for (int i = 0; i <= nums.length; i++) {
            bucket.add(i, new ArrayList<>());
        }

        numberCountMap.forEach((key,value) -> {
            var listOfItems = bucket.get(value);
            listOfItems.add(key);
            bucket.set(value, listOfItems);
        });

        var result = new int[k];

        int resultsFound = 0;
        for (int i = bucket.size()-1; i >= 0; i--) {
            if (bucket.get(i) == null) continue;
            for (Object fromBucket: bucket.get(i)) {
                if (fromBucket instanceof Integer) {
                    result[resultsFound++] = (int) fromBucket;

                    if(resultsFound == k) {
                        return result;
                    }
                }
            }
        }

        return result;
    }

}
