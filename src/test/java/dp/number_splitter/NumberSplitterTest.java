package dp.number_splitter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberSplitterTest {

    @Test
    void test() {
        assertEquals(6, new NumberSplitter().maxProduct(5));
    }

}