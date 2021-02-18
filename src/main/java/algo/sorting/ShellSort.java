package algo.sorting;

public class ShellSort<T extends Comparable<T>> extends AbstractSort<T> {

    public void sort() {
        for(int gap = arr.length / 2; gap > 0; gap/=2) {
            sort(gap);
        }
    }

    private void sort(int gap) {
        for (int i = gap; i < arr.length; i++) {
            int j = i;
            T temp = arr[j];
            while(j >= gap && temp.compareTo(arr[j-gap]) < 0) {
                arr[j] = arr[j-1];
                j -= gap;
            }
            arr[j] = temp;
        }
    }
}
