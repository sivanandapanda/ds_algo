package dp.on_the_way_to_home.grid_traveler;

import dp.model.DpCalcType;

import java.util.HashMap;
import java.util.Map;

public class GridTraveler {

    private final IGridTraveler gridTraveler;

    public GridTraveler(DpCalcType dpCalcType) {
        switch (dpCalcType) {
            case MEMO:
                gridTraveler = new MemoGridTraveler();
                break;
            case TABULATION:
                gridTraveler = new TabGridTraveler();
                break;
            case RECURSIVE:
            default:
                gridTraveler = new RecursiveGridTraveler();
                break;
        }
    }

    public int calc(int m, int n) {
        return gridTraveler.calc(m, n);
    }

    private interface IGridTraveler {
        int calc(int m, int n);
    }

    private static class RecursiveGridTraveler implements IGridTraveler {

        @Override
        public int calc(int m, int n) {
            if(m ==1 && n == 1) {
                return 1;
            }

            if(m == 0 || n == 0) {
                return 0;
            }

            return calc(m-1, n) + calc(m, n-1);
        }
    }

    private static class MemoGridTraveler implements IGridTraveler {
        public int calc(int m, int n) {
            return calc(m, n, new HashMap<>());
        }

        private String getKey(int m, int n) {
            return m + "," + n;
        }

        private int calc(int m, int n, Map<String, Integer> map) {
            String key = getKey(m, n);

            if(map.containsKey(key)) {
                return map.get(key);
            }

            if(m ==1 && n == 1) {
                return 1;
            }

            if(m == 0 || n == 0) {
                return 0;
            }

            map.put(key, calc(m-1, n, map) + calc(m, n-1, map));

            return map.get(key);
        }
    }

    private static class TabGridTraveler implements IGridTraveler {

        @Override
        public int calc(int m, int n) {
            int[][] tab = new int[m+1][n+1];

            //fill all with 0
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    tab[i][j] = 0;
                }
            }

            //base case
            tab[1][1] = 1;

            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    var current = tab[i][j];
                    if(i+1 <= m) tab[i+1][j] += current;
                    if(j+1 <= n) tab[i][j+1] += current;
                }
            }

            return tab[m][n];
        }
    }
}
