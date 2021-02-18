package algo.sorting;

public class InsertionSort<T extends Comparable<T>> extends AbstractSort<T> {

    public void sort() {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            T temp = arr[j];
            while(j > 0 && temp.compareTo(arr[j-1]) < 0) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
