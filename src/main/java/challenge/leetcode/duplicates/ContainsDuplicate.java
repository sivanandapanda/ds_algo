package challenge.leetcode.duplicates;

//leetcode 217
//https://leetcode.com/problems/contains-duplicate/

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    boolean containsDuplicate(int[] nums) {
        Set<Integer> numberSet = new HashSet<>();

        for (int num : nums) {
            if (numberSet.contains(num)) {
                return true;
            } else {
                numberSet.add(num);
            }
        }

        return false;
    }
}
