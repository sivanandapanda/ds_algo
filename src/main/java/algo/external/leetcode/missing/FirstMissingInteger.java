package algo.external.leetcode.missing;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingInteger {

    public int find(int[] nums) {

        int ans = 1;

        Set<Integer> cache = new HashSet<>();

        for (int i : nums) {
            cache.add(i);
        }

        for (Integer integer : cache) {
            if(ans == integer) {
                ans++;
            }
        }

        return ans;
    }
}
