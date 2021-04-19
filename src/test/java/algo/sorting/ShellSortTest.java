package algo.sorting;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ShellSortTest {

    @Test
    void test_sorting() {
        ShellSort<Integer> sortingAlgo = new ShellSort<>();
        sortingAlgo.setArr(new Integer[]{25, 5, -1, 22, 2});
        sortingAlgo.sort();
        sortingAlgo.display();
        assertTrue(AbstractSort.isSorted(sortingAlgo.getArr()));
    }

    @Test
    void random_sorting() {
        Integer[] arr = new Integer[1_000_000];

        IntStream.range(0, arr.length).forEach(i -> arr[i] = new Random().nextInt(1000));

        ShellSort<Integer> sortingAlgo = new ShellSort<>();
        sortingAlgo.setArr(arr);
        sortingAlgo.sort();
        //sortingAlgo.display();
        assertTrue(AbstractSort.isSorted(sortingAlgo.getArr()));
    }

}