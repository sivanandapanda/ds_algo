package ds.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraInterpreterTest {

    @Test
    void test() {
        var algorithm = new DijkstraInterpreter();

        algorithm.interpretExpression("( ( 1 + 2 ) * ( 2 + 1 ) )");

        assertEquals(9, algorithm.result());
    }

}