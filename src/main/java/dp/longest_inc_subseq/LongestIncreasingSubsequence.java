package dp.longest_inc_subseq;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    private final int size;
    private final int[] arr;

    public LongestIncreasingSubsequence(int[] arr) {
        this.arr = arr;
        this.size = arr.length;
    }

    public int lis() {
        int[] lis = new int[size];
        Arrays.fill(lis, 1);

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int maxLength = 1;

        for (int i : lis) {
            maxLength = Math.max(maxLength, i);
        }

        return maxLength;
    }
}
