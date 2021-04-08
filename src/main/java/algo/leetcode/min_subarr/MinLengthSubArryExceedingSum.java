package algo.leetcode.min_subarr;

public class MinLengthSubArryExceedingSum {

    //o(n^2)
    public static int find(int[] nums, int target) {

        int minLength = 0;

        for (int i = 0; i < nums.length; i++) {

            int temp = nums[i];

            if(temp >= target) {
                minLength = 1;
                break;
            }

            for (int j = i+1; j < nums.length; j++) {
                temp += nums[j];

                if(temp >= target) {
                    if(minLength == 0) {
                        minLength = j-i+1;
                    }

                    if(minLength > j-i+1) {
                        minLength = j-i+1;
                        break;
                    }
                }
            }
        }


        return minLength;
    }

    //o(n)
    public static int find_2_pointer(int[] nums, int target) {
        int n = nums.length;
        int curr_sum = 0, min_len = n + 1;

        // Initialize starting and ending indexes
        int start = 0, end = 0;
        while (end < n) {
            // Keep adding array elements while current sum
            // is smaller than or equal to x
            while (curr_sum <= target && end < n)
                curr_sum += nums[end++];

            // If current sum becomes greater than x.
            while (curr_sum > target && start < n) {
                // Update minimum length if needed
                if (end - start < min_len)
                    min_len = end - start;

                // remove starting elements
                curr_sum -= nums[start++];
            }
        }
        return min_len;
    }

}
