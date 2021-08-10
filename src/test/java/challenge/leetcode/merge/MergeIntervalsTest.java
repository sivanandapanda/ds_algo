package challenge.leetcode.merge;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalsTest {

    @Test
    void test_1() {
        int[][] input = {{1, 4}, {4, 5}};
        var afterMerge = new MergeIntervals().merge(input);
        Stream.of(afterMerge).forEach(a -> System.out.println(Arrays.toString(a)));
        assertArrayEquals(new int[][] {{1,5}}, afterMerge);
    }

    @Test
    void test_2() {
        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        var afterMerge = new MergeIntervals().merge(input);
        Stream.of(afterMerge).forEach(a -> System.out.println(Arrays.toString(a)));
        assertArrayEquals(new int[][] {{8, 10}, {15, 18},{1,6}}, afterMerge);
    }

    @Test
    void test_3() {
        int[][] input = {{1, 4}, {1, 4}};
        var afterMerge = new MergeIntervals().merge(input);
        Stream.of(afterMerge).forEach(a -> System.out.println(Arrays.toString(a)));
        assertArrayEquals(new int[][] {{1,4}}, afterMerge);
    }

    @Test
    void test_4() {
        int[][] input = {{1, 4}, {0, 2}, {3, 5}};
        var afterMerge = new MergeIntervals().merge(input);
        Stream.of(afterMerge).forEach(a -> System.out.println(Arrays.toString(a)));
        assertArrayEquals(new int[][] {{0,5}}, afterMerge);
    }

    @Test
    void test_5() {
        int[][] input = {{2, 3}, {5, 5}, {2, 2}, {3, 4}, {3, 4}};
        var afterMerge = new MergeIntervals().merge(input);
        Stream.of(afterMerge).forEach(a -> System.out.println(Arrays.toString(a)));
        assertArrayEquals(new int[][] {{2,4},{5,5}}, afterMerge);
    }
}