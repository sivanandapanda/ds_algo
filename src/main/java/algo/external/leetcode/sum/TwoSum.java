package algo.external.leetcode.sum;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 * leetcode 1
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            var remainder = target - nums[i];

            if(map.containsKey(remainder) && i != map.get(remainder)) {
                return new int[] {i, map.get(remainder)};
            }
        }

        return null;
    }
}
