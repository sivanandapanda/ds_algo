package algo.sorting;

//Leetcode 75
public class DutchNationalFlagMain {

    public static void sort(int[] nums) {
        int smallest = 0;
        int secondSmallest = 1;

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {

            if (nums[i] > nums[j]) {
                swap(nums, i, j);
                if(nums[i] == smallest) {
                    i++;
                } else {
                    j--;
                }
            } else if (nums[i] == nums[j] && nums[i] == smallest) {
                i++;
            } else {
                j--;
            }
        }

        for (int k = 1; k < nums.length; k++) {
            if (nums[k] > smallest) {
                i = k;
                break;
            }
        }

        j = nums.length - 1;

        while (i < j) {

            if (nums[i] > nums[j]) {
                swap(nums, i, j);
                if(nums[i] == smallest) {
                    i++;
                } else {
                    j--;
                }
            } else if (nums[i] == nums[j] && nums[i] == secondSmallest) {
                i++;
            } else {
                j--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        var temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
