package challenge.leetcode.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInRotatedSortedArrayTest {

    @Test
    void test1() {
        assertEquals(0, new SearchInRotatedSortedArray().search(new int[]{1}, 1));
    }

    @Test
    void test2() {
        assertEquals(1, new SearchInRotatedSortedArray().search(new int[]{1, 3, 5}, 3));
    }

    @Test
    void test3() {
        assertEquals(4, new SearchInRotatedSortedArray().search(new int[]{4,5,6,7,0,1,2}, 0));
    }

    @Test
    void test4() {
        assertEquals(-1, new SearchInRotatedSortedArray().search(new int[]{4,5,6,7,0,1,2}, 3));
    }

}