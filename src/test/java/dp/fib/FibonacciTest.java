package dp.fib;

import dp.model.DpCalcType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest {

    @ParameterizedTest
    @CsvSource(value = {"40:102334155","5:5","6:8","15:610"}, delimiter = ':')
    void test_memo(int find, int expected){
        var fibonacci = new Fibonacci(DpCalcType.MEMO);
        assertEquals(expected, fibonacci.find(find));
    }

    @ParameterizedTest
    @CsvSource(value = {"40:102334155","5:5","6:8","15:610"}, delimiter = ':')
    void test_tab(int find, int expected){
        var fibonacci = new Fibonacci(DpCalcType.TABULATION);
        assertEquals(expected, fibonacci.find(find));
    }

}