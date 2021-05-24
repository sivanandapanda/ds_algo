package dp.stairway_to_heaven;

import java.util.HashMap;
import java.util.Map;

public class StairwayToHeaven2 {

    private final int[] fees;

    public StairwayToHeaven2(int[] fees) {
        this.fees = fees;
    }

    public int calculateWaysToHeaven(int numberOfSteps) {
        return find(numberOfSteps, new HashMap<>());
    }

    private int find(int n, Map<Integer, Integer> cache) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 3;

        if(cache.containsKey(n)) {
            return cache.get(n);
        } else {
            int answer = 0;
            for(int i = 3; i <= n; i++){
                answer = Math.min((find(i - 1, cache) + fees[i - 1]), Math.min((find(i - 2, cache)  + fees[i - 2]), find(i - 3, cache) + fees[i - 3]));
            }
            cache.put(n, answer);
            return answer;
        }
    }
}
