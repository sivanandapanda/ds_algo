package challenge.leetcode.product_array;

import java.util.Arrays;

//leetcode 238
//https://leetcode.com/problems/product-of-array-except-self/
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        System.out.println("input   = " + Arrays.toString(nums));
        var result = new int[nums.length];

        var prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] * nums[i];
        }
        System.out.println("prefix  = " + Arrays.toString(prefix));

        var postfix = new int[nums.length];
        postfix[nums.length-1] = nums[nums.length-1];
        for (int i = nums.length-2; i >= 0; i--) {
            postfix[i] = postfix[i+1] * nums[i];
        }
        System.out.println("postfix = " + Arrays.toString(postfix));

        for (int i = 0; i < nums.length; i++) {
           result[i] = (i-1 < 0 ? 1 : prefix[i-1]) * (i+1 == nums.length ? 1 : postfix[i+1]);
        }

        System.out.println("result  = " + Arrays.toString(result));

        return result;
    }
}
