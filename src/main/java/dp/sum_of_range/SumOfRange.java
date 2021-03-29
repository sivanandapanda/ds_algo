package dp.sum_of_range;

import java.util.Arrays;

public class SumOfRange {

    private final int size;
    private final int[] arr;

    private final int[] sumUntil;

    public SumOfRange(int[] arr) {
        this.arr = arr;
        this.size = arr.length;

        this.sumUntil = preProcessing();
    }

    private int[] preProcessing() {
        int[] sumUntil = new int[size];
        sumUntil[0] = arr[0];

        for (int i = 1; i < size; i++) {
            sumUntil[i] = sumUntil[i-1] + arr[i];
        }

        System.out.println(Arrays.toString(sumUntil));

        return sumUntil;
    }

    public int sumRange(int leftIndex, int rightIndex) {

        if(leftIndex == 0) {
            return sumUntil[rightIndex];
        } else {
            return sumUntil[rightIndex] - sumUntil[leftIndex-1];
        }
    }
}
