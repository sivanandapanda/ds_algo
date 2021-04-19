package dp.rod_cutter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RodCutterTest {

    @Test
    void test() {
        int[] costArray = {0, 2, 4, 5, 7};

        RodCutter rodCutter = new RodCutter(costArray);

        assertEquals(8, rodCutter.maxCost());
    }

}