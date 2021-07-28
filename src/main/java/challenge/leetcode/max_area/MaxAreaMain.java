package challenge.leetcode.max_area;

public class MaxAreaMain {

    public static int maxArea(int[] height) {
        //o(n^2)
        /*int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = height.length-1; j > i; j--) {
                int tempArea = Math.min(height[i], height[j]) * (j - i);
                maxArea = Math.max(maxArea, tempArea);
            }
        }*/

        //o(n)
        int startIndex = 0;
        int endIndex = height.length-1;

        int maxArea = 0;

        while(startIndex < endIndex) {

            maxArea = Math.max(maxArea, Math.min(height[startIndex], height[endIndex]) * (endIndex - startIndex));

            if(height[startIndex] < height[endIndex]) {

                startIndex++;

            } else {
                endIndex--;
            }
        }

        return maxArea;
    }

}
