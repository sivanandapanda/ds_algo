package challenge.leetcode.product_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductOfArrayExceptSelfTest {

    @Test
    void test_1() {
        var result = new ProductOfArrayExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4});
        assertArrayEquals(new int[]{24, 12, 8, 6}, result);
    }

    @Test
    void test_2() {
        var result = new ProductOfArrayExceptSelf().productExceptSelf(new int[]{-1,1,0,-3,3});
        assertArrayEquals(new int[]{0,0,9,0,0}, result);
    }
}