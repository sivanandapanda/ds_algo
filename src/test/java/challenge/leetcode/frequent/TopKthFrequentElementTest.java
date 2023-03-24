package challenge.leetcode.frequent;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TopKthFrequentElementTest {

    @Test
    void test_top_2_frequent() {
        var result = new TopKthFrequentElement().topKFrequent(new int[]{1, 1, 1, 2, 2, 3, 3, 3}, 2);
        assertArrayEquals(result, new int[]{1, 3});
    }

    @Test
    void test_top_3_frequent() {
        var result = new TopKthFrequentElement().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 3);
        assertArrayEquals(result, new int[]{1,2,3});
    }

    @Test
    void test_top_3_frequent_1() {
        var result = new TopKthFrequentElement().topKFrequent(new int[]{5,3,1,1,1,3,5,73,1,5}, 3);
        assertArrayEquals(result, new int[]{1, 5,3});
    }

    @Test
    void test_top_10_frequent() {
        var result = new TopKthFrequentElement().topKFrequent(new int[]{3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6}, 10);
        assertArrayEquals(result, new int[]{1, 2, 5, 3, 6, 7, 4, 8, 10, 11});
    }

    @Test
    void test_top_1_frequent() {
        var result = new TopKthFrequentElement().topKFrequent(new int[]{1}, 1);
        assertArrayEquals(result, new int[]{1});
    }

}