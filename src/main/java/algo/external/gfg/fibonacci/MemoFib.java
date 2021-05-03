package algo.external.gfg.fibonacci;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class MemoFib {

    public static int CALCULATE_FOR = 115;

    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.now();
        System.out.println(CALCULATE_FOR + " = " + calculate(CALCULATE_FOR) + " completed in " + Duration.between(start, LocalDateTime.now()));
    }

    /**
     * 45 = 1134903170 completed in PT0.0009998S
     * 115 = 5831833409587358613 completed in PT0S
     */

    private static Long calculate(int n) {
        Long[] lookup = new Long[n+1];
        lookup[0] = 0L;
        lookup[1] = 1L;

        return fib(n, lookup);
    }

    private static Long fib(int n, Long[] lookup) {
        if(Objects.isNull(lookup[n])) {
            lookup[n] = fib(n-1, lookup) + fib(n-2, lookup);
        }
        return lookup[n];
    }
}
