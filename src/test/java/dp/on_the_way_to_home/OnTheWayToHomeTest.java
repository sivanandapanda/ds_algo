package dp.on_the_way_to_home;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OnTheWayToHomeTest {

    @Test
    void test_3_by_4_grid() {
        OnTheWayToHome onTheWayToHome = new OnTheWayToHome(3, 4);
        int numberOfWaysToHome = onTheWayToHome.findNumberOfWaysToHome();
        assertEquals(10, numberOfWaysToHome);
    }

    @Test
    void test_3_by_3_grid() {
        OnTheWayToHome onTheWayToHome = new OnTheWayToHome(3, 3);
        int numberOfWaysToHome = onTheWayToHome.findNumberOfWaysToHome();
        assertEquals(6, numberOfWaysToHome);
    }

}