package challenge.gfg.fibonacci;

import java.time.Duration;
import java.time.LocalDateTime;

import static challenge.gfg.fibonacci.MemoFib.CALCULATE_FOR;

public class TabFib {

    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.now();
        System.out.println(CALCULATE_FOR + " = " + calculate(CALCULATE_FOR) + " completed in " + Duration.between(start, LocalDateTime.now()));
    }

    /**
     * 45 = 1134903170 completed in PT0.000999S
     * 115 = 5831833409587358613 completed in PT0.0010013S
     */

    private static long calculate(int n) {
        long[] lookup = new long[n+1];
        lookup[0] = 0;
        lookup[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            lookup[i] = lookup[i-1] + lookup[i-2];
        }

        return lookup[n];
    }
}
