package dp.stairway_to_heaven;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class StairwayToHeavenTest {

    @ParameterizedTest
    @CsvSource({"4", "5", "6"})
    void test_with_n_steps(int n) {
        StairwayToHeaven stairwayToHeaven = new StairwayToHeaven();
        int actual = stairwayToHeaven.calculateWaysToHeaven(n);

        int expected = 0;

        if(n == 4) {
            expected = 5;
        } else if(n == 5) {
            expected = 8;
        } else if(n == 6) {
            expected = 13;
        }

        assertEquals(expected, actual);
    }

    @Test
    void test_6_steps() {
        StairwayToHeaven stairwayToHeaven = new StairwayToHeaven();
        assertEquals(13, stairwayToHeaven.calculateWaysToHeaven(6));
    }
}