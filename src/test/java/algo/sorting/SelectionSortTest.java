package algo.sorting;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SelectionSortTest {
    @Test
    void test_sorting() {
        SelectionSort<Integer> sortingAlgo = new SelectionSort<>();
        sortingAlgo.setArr(new Integer[]{25, 5, -1, 22, 2});
        sortingAlgo.sort();
        sortingAlgo.display();
        assertTrue(AbstractSort.isSorted(sortingAlgo.getArr()));
    }
    
    @Test
    void random_sorting() {
        //Integer[] arr = new Integer[1_000_000];
        Integer[] arr = new Integer[1_000];

        IntStream.range(0, arr.length).forEach(i -> arr[i] = new Random().nextInt(1000));

        SelectionSort<Integer> sortingAlgo = new SelectionSort<>();
        sortingAlgo.setArr(arr);
        sortingAlgo.sort();
        //sortingAlgo.display();
        assertTrue(AbstractSort.isSorted(sortingAlgo.getArr()));
    }

}