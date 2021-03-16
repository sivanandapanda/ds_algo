package algo.sorting;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BubbleSortTest {

    @Test
    void test_sorting() {
        BubbleSort<Integer> sortingAlgo = new BubbleSort<>();
        sortingAlgo.setArr(new Integer[]{25, 5, -1, 22, 2});
        sortingAlgo.sort();
        sortingAlgo.display();
        assertTrue(AbstractSort.isSorted(sortingAlgo.getArr()));
    }

    @Benchmark
    public void measureName() {

    }

    @Test
    void random_sorting() {
        //Integer[] arr = new Integer[1_000_000];
        Integer[] arr = new Integer[1_000];

        IntStream.range(0, arr.length).forEach(i -> arr[i] = new Random().nextInt(1000));

        BubbleSort<Integer> sortingAlgo = new BubbleSort<>();
        sortingAlgo.setArr(arr);
        sortingAlgo.sort();
        //sortingAlgo.display();
        assertTrue(AbstractSort.isSorted(sortingAlgo.getArr()));
    }
}