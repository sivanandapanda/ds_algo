package algo.leetcode.trap_rain_water;

public class TrapRainWaterMain {

    public static int trap(int[] height) {
        int trappedWater = 0;

        int index = 0;

        while (index < height.length) {

            if(index+1 < height.length && height[index+1] < height[index]) {

                int nextHighest = 0;
                int nextHighestIndex = -1;
                for (int i = index+1; i < height.length; i++) {
                    if(height[i] > nextHighest) {

                        boolean allInnerElementsSmallerThan2 = true;

                        for (int j = index+1; j < i; j++) {
                            allInnerElementsSmallerThan2 &= height[j] < height[index] && height[j] < height[i];
                        }

                        if(allInnerElementsSmallerThan2) {
                            nextHighest = height[i];
                            nextHighestIndex = i;
                        }
                    }
                }

                if(nextHighestIndex == -1 || nextHighest == 0) {
                    break;
                }

                int smallestHeight = Math.min(nextHighest, height[index]);

                for (int i = index+1; i < nextHighestIndex; i++) {
                    trappedWater += Math.abs(smallestHeight - height[i]);
                }

                index = nextHighestIndex;
            } else {
                index++;
            }
        }

        return trappedWater;
    }
}
