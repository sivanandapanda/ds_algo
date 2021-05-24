package dp.arrangement;

import dp.model.DpCalcType;

import java.util.HashMap;
import java.util.Map;

public class DominoArrangement {

    private final IDominoArrangement dominoArrangement;

    public DominoArrangement(DpCalcType dpCalcType) {
        switch (dpCalcType) {
            case MEMO:
                dominoArrangement = new MemoArrangements();
                break;
            case TABULATION:
            case RECURSIVE:
            default:
                dominoArrangement = new RecursiveArrangements();
                break;
        }
    }

    public int findNumberOfArrangements(int i) {
        return dominoArrangement.find(i);
    }

    private interface IDominoArrangement {
        int find(int size);
    }

    private static class RecursiveArrangements implements IDominoArrangement {

        @Override
        public int find(int size) {
            //base cases
            if(size<=2) {
                return size;
            }

            return find(size-1) + find(size-2);
        }
    }

    private static class MemoArrangements implements IDominoArrangement {

        @Override
        public int find(int size) {
            return find(size, new HashMap<>());
        }

        private int find(int size, Map<Integer, Integer> cache) {
            if(size<=2) {
                return size;
            }

            if(cache.containsKey(size)) {
                return cache.get(size);
            } else {
                int result = find(size-1, cache) + find(size-2, cache);

                cache.put(size, result);

                return result;
            }
        }
    }
}
