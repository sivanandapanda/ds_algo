package algo.sorting;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    @Test
    void test_sorting() {
        InsertionSort<Integer> sortingAlgo = new InsertionSort<>();
        sortingAlgo.setArr(new Integer[]{25, 5, -1, 22, 2});
        sortingAlgo.sort();
        sortingAlgo.display();
        assertTrue(AbstractSort.isSorted(sortingAlgo.getArr()));
    }

    @Test
    void random_sorting() {
        Integer[] arr = new Integer[10000];

        IntStream.range(0, arr.length).forEach(i -> arr[i] = new Random().nextInt(1000));

        InsertionSort<Integer> sortingAlgo = new InsertionSort<>();
        sortingAlgo.setArr(arr);
        sortingAlgo.sort();
        sortingAlgo.display();
        assertTrue(AbstractSort.isSorted(sortingAlgo.getArr()));
    }
}