package algo.challenge;

import java.util.Arrays;

/**
 * Radix sort for strings
 */
public class ChallengeThree {

    public static void main(String[] args) {
        String[] arr = { "bcdef", "dbaqc", "abcde", "omadd", "bbbbb" };

        System.out.println(Arrays.toString(arr));

        radixSort(arr, 26, arr[0].length());

        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(String[] arr, int radix, int width) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(arr, i, radix);
        }
    }

    private static void radixSingleSort(String[] arr, int position, int radix) {
        int[] countArr = new int[radix];

        for (String value : arr) {
            countArr[getChar(value, position)]++;
        }

        for (int j = 1; j < radix; j++) {
            countArr[j] += countArr[j-1];
        }

        String[] temp = new String[arr.length];
        for (int tempIndex = arr.length-1; tempIndex >= 0 ; tempIndex--) {
            temp[--countArr[getChar(arr[tempIndex], position)]] = arr[tempIndex];
        }

        System.arraycopy(temp, 0, arr, 0, arr.length);
    }

    private static int getChar(String str, int position) {
        return str.charAt(str.length() - position -1) - 'a';
    }
}
