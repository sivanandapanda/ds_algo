package dp.stairway_to_heaven;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FaultyStairwayToHeavenTest {

    @Test
    void test_with_5_steps_and_3rd_step_is_faulty() {
        FaultyStairwayToHeaven faultyStairwayToHeaven = new FaultyStairwayToHeaven(3);
        assertEquals(2, faultyStairwayToHeaven.calculateWaysToHeaven(5));
    }

    @Test
    void test_with_5_steps_and_2nd_and_4th_steps_are_faulty() {
        FaultyStairwayToHeaven faultyStairwayToHeaven = new FaultyStairwayToHeaven(2, 4);
        assertEquals(1, faultyStairwayToHeaven.calculateWaysToHeaven(5));
    }

    @Test
    void test_with_5_steps_and_2nd_and_3rd_steps_are_faulty() {
        FaultyStairwayToHeaven faultyStairwayToHeaven = new FaultyStairwayToHeaven(2, 3);
        assertEquals(0, faultyStairwayToHeaven.calculateWaysToHeaven(5));
    }
}