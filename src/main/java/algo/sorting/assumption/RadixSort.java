package algo.sorting.assumption;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int[] arr = { 4725, 4586, 1330, 8792, 1594, 5729 };

        System.out.println(Arrays.toString(arr));

        radixSort(arr, 10, 4);

        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr, int radix, int width) {
        for (int i = 0; i < width; i++) {
            radisSingleSort(arr, i, radix);
        }
    }

    private static void radisSingleSort(int[] arr, int position, int radix) {
        int numItems = arr.length;
        int[] countArray = new int[radix];

        for (int value : arr) {
            countArray[getDigit(position, value, radix)]++;
        }

        // to make stable sort
        //Adjust the count ds.array
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j-1];
        }

        int[] temp = new int[numItems];
        for (int tempIndex = numItems-1; tempIndex >= 0 ; tempIndex--) {
            temp[--countArray[getDigit(position, arr[tempIndex], radix)]] = arr[tempIndex];
        }
        // stable sort end

        System.arraycopy(temp, 0, arr, 0, numItems);
        /*for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            arr[tempIndex] = temp[tempIndex];
        }*/
    }

    private static int getDigit(int position, int value, int radix) {
        return value/ (int) Math.pow(radix, position) % radix;
    }
}
