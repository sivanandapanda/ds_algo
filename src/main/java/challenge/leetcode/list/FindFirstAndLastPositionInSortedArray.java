package challenge.leetcode.list;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/
 * leetcode 34
 */
public class FindFirstAndLastPositionInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1, -1};

        if(nums == null || nums.length == 0) return result;

        if(nums.length == 1) {
            if(nums[0] == target) {
                return new int[]{0, 0};
            } else {
                return result;
            }
        }

        int start = 0, end = nums.length-1;

        if(target < nums[start] || target > nums[end]) return result;

        while (start <= end) {
            if(nums[start] == target && result[0] == -1) {
                result[0] = start;
            }

            if(nums[end] == target && result[1] == -1) {
                result[1] = end;
            }

            if(result[0] > -1 && result[1] > -1) {
                break;
            } else {
                if(result[0] == -1) start++;
                if(result[1] == -1) end--;
            }
        }

        if(result[0] > -1 && result[1] == -1) {
            result[1] = result[0];
        }

        if(result[1] > -1 && result[0] == -1) {
            result[0] = result[1];
        }

        return result;
    }

}
