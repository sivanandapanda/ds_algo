package algo.sorting;

import java.util.Arrays;

public abstract class AbstractSort<T extends Comparable<T>> {
    protected T[] arr;

    public void setArr(T[] arr) {
        this.arr = arr;
    }

    public T[] getArr() {
        return arr;
    }

    public abstract void sort();

    protected void swap(int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void display() {
        System.out.println(Arrays.toString(arr));
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i+1].compareTo(arr[i]) < 0) {
                return false;
            }
        }

        return true;
    }
}
