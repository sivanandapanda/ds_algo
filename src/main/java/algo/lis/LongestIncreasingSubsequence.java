package algo.lis;

import java.util.Arrays;
import java.util.Random;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100);
        }

        //arr = new int[] {10, 22, 9, 33, 21, 50, 41, 60};

        System.out.println(Arrays.toString(arr));

        System.out.println("Answer: " + find(arr));
    }

    private static int find(int[] arr) {
        int[] lis = new int[arr.length];

        Arrays.fill(lis, 1);

        for (int i = 1; i < arr.length; i++) {

            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    int oldMax = lis[i];
                    int newMax = lis[j] + 1;
                    lis[i] = Math.max(newMax, oldMax);
                }
            }
        }

        int max = 1;

        for (int i = 0; i < lis.length; i++) {
            if(lis[i] > max) {
                max = lis[i];
            }
        }

        return max;
    }
}
