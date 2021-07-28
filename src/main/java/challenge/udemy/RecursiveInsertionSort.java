package challenge.udemy;

import java.util.Arrays;

/**
 * Recursive insertion sort
 */
public class RecursiveInsertionSort {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        insertionSort(intArray, 1);

        for (int j : intArray) {
            System.out.println(j);
        }
    }

    private static void insertionSort(int[] input, int index) {
        if(index >= input.length) {
            return;
        }

        int temp = input[index];

        int i;
        for (i = index; i > 0 && input[i - 1] > temp; i--) {
            input[i] = input[i - 1];
        }

        input[i] = temp;

        System.out.println("Result when index " + index);
        System.out.println(Arrays.toString(input));
        System.out.println("---------------------------");

        insertionSort(input, index+1);
    }
}


