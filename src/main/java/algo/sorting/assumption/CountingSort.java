package algo.sorting.assumption;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int[] arr = { 2, 5, 9, 8, 2, 8, 7, 10, 4, 3 };

        System.out.println(Arrays.toString(arr));

        countingSort(arr, 1, 10);

        System.out.println(Arrays.toString(arr));
    }

    private static void countingSort(int[] input, int min, int max) {
        int[] countArr = new int[(max - min) + 1];

        for (int i = 0; i < input.length; i++) {
            countArr[input[i] - min]++;
        }

        int j = 0;
        for (int i = min; i <= max; i++) {
            while(countArr[i - min] > 0) {
                input[j++] = i;
                countArr[i -min]--;
            }
        }

    }
}
