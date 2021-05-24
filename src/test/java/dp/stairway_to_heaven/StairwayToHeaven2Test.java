package dp.stairway_to_heaven;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StairwayToHeaven2Test {

    @Test
    void test() {
        int[] fees = {1, 1, 1, 3};
        StairwayToHeaven2 stairwayToHeaven = new StairwayToHeaven2(fees);
        assertEquals(2, stairwayToHeaven.calculateWaysToHeaven(fees.length));
    }

    @Test
    void test_1000() {
        int[] fees = new int[1000];
        Arrays.fill(fees, new Random().nextInt(10));

        StairwayToHeaven2 stairwayToHeaven = new StairwayToHeaven2(fees);
        System.out.println(stairwayToHeaven.calculateWaysToHeaven(fees.length));
    }
}