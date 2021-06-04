package dp.burgler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BurglarsNightOutTest {

    @Test
    void test() {
        int[] houses = {3, 8, 10, 4, 1, 7, 2};
        var maxMoneyRobbed = new BurglarsNightOut().maxMoneyRobbed(houses);
        assertEquals(20,  maxMoneyRobbed);
    }

}