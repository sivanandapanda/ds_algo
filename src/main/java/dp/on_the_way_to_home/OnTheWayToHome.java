package dp.on_the_way_to_home;

/*
 * only right and down movements allowed
 */
public class OnTheWayToHome {

    private final int xAxisGridLength;
    private final int yAxisGridLength;

    public OnTheWayToHome(int xAxisGridLength, int yAxisGridLength) {
        this.xAxisGridLength = xAxisGridLength;
        this.yAxisGridLength = yAxisGridLength;
    }

    public int findNumberOfWaysToHome() {
        int[][] ways = new int[xAxisGridLength][yAxisGridLength];

        for (int i = 0; i < yAxisGridLength; i++) {
            ways[xAxisGridLength-1][i] = 1;
        }

        for (int i = 0; i < xAxisGridLength; i++) {
            ways[i][yAxisGridLength-1] = 1;
        }

        for (int i = xAxisGridLength - 2; i >= 0 ; i--) {
            for (int j = yAxisGridLength - 2; j >= 0 ; j--) {
                ways[i][j] = ways[i][j+1] + ways[i+1][j];
            }
        }

        return ways[0][0];
    }
}
