package dp.on_the_way_to_home.grid_traveler;

import dp.model.DpCalcType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GridTravelerTest {

    @ParameterizedTest
    @CsvSource(value = {"2,3,3", "3,3,6", "16,16,155117520"})
    void test_memo(int m, int n, int expected) {
        var gridTraveler = new GridTraveler(DpCalcType.MEMO);
        assertEquals(expected, gridTraveler.calc(m, n));
    }

    @ParameterizedTest
    @CsvSource(value = {"2:3:3", "3:3:6", "16:16:155117520"}, delimiter = ':')
    void test_tab(int m, int n, int expected) {
        var gridTraveler = new GridTraveler(DpCalcType.TABULATION);
        assertEquals(expected, gridTraveler.calc(m, n));
    }

}