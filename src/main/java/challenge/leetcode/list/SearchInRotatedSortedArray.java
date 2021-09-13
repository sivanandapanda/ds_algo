package challenge.leetcode.list;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/
 * leetcode 33
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        if(nums == null || nums.length == 0) return -1;

        if(nums.length == 1) {
            if(nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }

        int start = 0, end = nums.length-1;

        int result = -1;

        if(nums[end] < nums[start]) {
            while (start < end) {
                if (target == nums[start]) {
                    result = start;
                    break;
                } else if (target == nums[end]) {
                    result = end;
                    break;
                } else if (target < nums[end] || target > nums[start]) {
                    if (target < nums[end]) {
                        end--;
                    }

                    if (target > nums[start]) {
                        start++;
                    }
                } else {
                    break;
                }
            }
        } else {
            result = Arrays.binarySearch(nums, target);
            if(result < 0) {
                result = -1;
            }
        }

        return result;
    }

}
