package dp.on_the_way_to_home.grid_traveler;

import java.util.HashMap;
import java.util.Map;

public class GridTraveler {

    public static void main(String[] args) {
        IGridTraveler gridTraveler = new MemoGridTraveler();
        System.out.println(gridTraveler.calc(18, 18));
    }
}

interface IGridTraveler {
    int calc(int m, int n);
}

class RecursiveGridTraveler implements IGridTraveler {

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

class MemoGridTraveler implements IGridTraveler {
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
