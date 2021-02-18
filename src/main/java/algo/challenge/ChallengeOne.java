package algo.challenge;

import java.util.Arrays;

/**
 * Descending Merge Sort
 */
public class ChallengeOne {

    public static void main(String[] args) {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};

        System.out.println(Arrays.toString(arr));

        mergeSort(arr, 0, arr.length);

        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] input, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    private static void merge(int[] input, int start, int mid, int end) {
        String prefix = String.format("Start: %s mid: %s end: %s = ", start, mid, end);
        //System.out.println(prefix);

        if (input[mid - 1] >= input[mid]) {
            return;
        }

        // { 32, 36 }, { 33, 38}

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] >= input[j] ? input[i++] : input[j++];
        }

        //System.out.println(prefix + Arrays.toString(temp) + " <== temp");

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);

        //System.out.println(prefix + Arrays.toString(input));
        //System.out.println("--------------------");
    }
}