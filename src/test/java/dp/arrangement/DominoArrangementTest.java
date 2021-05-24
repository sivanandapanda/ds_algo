package dp.arrangement;

import dp.model.DpCalcType;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DominoArrangementTest {

    @Test
    void test() {
        DominoArrangement dominoArrangement = new DominoArrangement(DpCalcType.RECURSIVE);
        assertEquals(8, dominoArrangement.findNumberOfArrangements(5));
    }

    @Test
    void test_memo() {
        DominoArrangement dominoArrangement = new DominoArrangement(DpCalcType.MEMO);
        assertEquals(8, dominoArrangement.findNumberOfArrangements(5));
    }

    @Test
    void test_memo_6() {
        DominoArrangement dominoArrangement = new DominoArrangement(DpCalcType.MEMO);
        assertEquals(13, dominoArrangement.findNumberOfArrangements(6));
    }

    @Test @Disabled
    void test_1000() {
        DominoArrangement dominoArrangement = new DominoArrangement(DpCalcType.RECURSIVE);
        assertEquals(8, dominoArrangement.findNumberOfArrangements(1000));
    }

    @Test
    void test_memo_1000() {
        DominoArrangement dominoArrangement = new DominoArrangement(DpCalcType.MEMO);
        assertEquals(1318412525, dominoArrangement.findNumberOfArrangements(1000));
    }

}