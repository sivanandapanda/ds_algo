package algo.sorting;

public class SelectionSort<T extends Comparable<T>> extends AbstractSort<T> {

    public void sort() {
        for (int i = 0; i < arr.length; i++) {
            int smallestIndex = i;
            for (int j = i; j < arr.length; j++) {
                if(arr[smallestIndex].compareTo(arr[j]) > 0) {
                    smallestIndex = j;
                }
            }
            swap(i, smallestIndex);
        }
    }
}
