package algo.external.gfg.fibonacci;

import java.time.Duration;
import java.time.LocalDateTime;

import static algo.external.gfg.fibonacci.MemoFib.CALCULATE_FOR;

public class RecursiveFib {

    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.now();
        System.out.println(CALCULATE_FOR + " = " + calculate(CALCULATE_FOR) + " completed in " + Duration.between(start, LocalDateTime.now()));
    }

    /**
     * 45 = 1134903170 completed in PT5.0119988S
     */

    private static int calculate(int n) {
        if(n <= 1) {
            return n;
        } else {
            return calculate(n-1) + calculate(n-2);
        }
    }
}
