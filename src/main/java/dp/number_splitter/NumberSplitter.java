package dp.number_splitter;

import static java.lang.Math.max;

public class NumberSplitter {

    public int maxProduct(int n) {
        int[] maxProduct = new int[n + 1];

        maxProduct[1] = 0;
        maxProduct[2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                maxProduct[i] = max(max(j * maxProduct[i-j], j* (i-j)), maxProduct[i]);
            }
        }

        return maxProduct[n];
    }

}
