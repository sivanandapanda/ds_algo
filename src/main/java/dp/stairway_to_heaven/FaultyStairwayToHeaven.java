package dp.stairway_to_heaven;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FaultyStairwayToHeaven {

    private final Set<Integer> faultyStepsSet;

    public FaultyStairwayToHeaven(int... faultySteps) {
        this.faultyStepsSet = new HashSet<>();

        for (int faulty : faultySteps) {
            faultyStepsSet.add(faulty -1);
        }
    }

    public int calculateWaysToHeaven(int numberOfSteps) {
        if(numberOfSteps <= 0) {
            return 0;
        }

        int[] ways = new int[numberOfSteps];
        Arrays.fill(ways, -1);

        ways[0] = 1;
        if(numberOfSteps > 1) {
            ways[1] = 2;
            for (int faulty : faultyStepsSet) {
                ways[faulty] = 0;
            }
        }

        int result = calculateWaysToHeaven(numberOfSteps - 1, ways);

        System.out.println("Result: " + result + " and array: " + Arrays.toString(ways));

        return result;
    }

    private int calculateWaysToHeaven(int n, int[] ways) {
        if (ways[n] == -1) {
            for (int i = 2; i <= n; i++) {
                if(!faultyStepsSet.contains(i)) {
                    ways[i] = calculateWaysToHeaven(i - 1, ways) + calculateWaysToHeaven(i - 2, ways);
                }
            }
        }
        return ways[n];
    }
}
