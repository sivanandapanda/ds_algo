package algo.sorting;

public class BubbleSort<T extends Comparable<T>> extends AbstractSort<T> {

    public void sort() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if(arr[i].compareTo(arr[j]) > 0) {
                    swap(i, j);
                }
            }
        }
    }
}
