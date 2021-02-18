package algo.sorting.recursion;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = { 20, 35, -15, 7, 55, 1, -22 };

        System.out.println(Arrays.toString(arr));

        quicksort(arr, 0, arr.length);

        System.out.println(Arrays.toString(arr));
    }

    private static void quicksort(int[] arr, int start, int end) {
        if(end-start < 2) {
            return;
        }

        int pivotIndex = partition(arr, start, end);
        quicksort(arr, start, pivotIndex);
        quicksort(arr, pivotIndex + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        //this is using first element as pivot

        int pivot = arr[start];
        int i = start;
        int j = end;

        while (i < j) {

            //NOTE: empty loop
            while(i < j && arr[--j] >= pivot);
            if( i < j) {
                arr[i] = arr[j];
            }

            //NOTE: empty loop
            while(i < j && arr[++i] <= pivot);
            if( i < j) {
                arr[j] = arr[i];
            }
        }

        arr[j] = pivot;

        return j;
    }
}
