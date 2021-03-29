package dp.rod_cutter;

import java.util.Arrays;

public class RodCutter {

    private final int size;
    private final int[] cost;

    public RodCutter(int[] cost) {
        this.cost = cost;
        this.size = this.cost.length;
    }

    public int maxCost() {
        int[] rod = new int[size];
        rod[0] = 0;

        for (int i = 1; i < size; i++) {
            int maxValue = Integer.MIN_VALUE;

            for (int j = 1; j <= i; j++) {
                maxValue = Math.max(maxValue, cost[j] + rod[i-j]);
            }

            rod[i] = maxValue;
        }

        System.out.println(Arrays.toString(rod));

        return rod[size-1];
    }
}
