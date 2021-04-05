package dp.construct.count_construct;

import dp.model.DpCalcType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountConstruct {
    private final ICountConstruct countConstruct;

    public CountConstruct(DpCalcType dpCalcType) {
        switch (dpCalcType) {
            case MEMO:
                countConstruct = new MemoCanConstruct();
                break;
            case TABULATION:
                countConstruct = new TabCountConstruct();
                break;
            case RECURSIVE:
            default:
                countConstruct = new RecursiveCanConstruct();
                break;
        }
    }

    public int count(String targetWord, List<String> words) {
        return countConstruct.count(targetWord, words);
    }

    private interface ICountConstruct {
        int count(String targetWord, List<String> words);
    }

    private static class RecursiveCanConstruct implements ICountConstruct {

        @Override
        public int count(String targetWord, List<String> words) {
            if ("".equals(targetWord)) return 1;

            var totalCount = 0;

            for (String word : words) {
                if (targetWord.indexOf(word) == 0) {
                    var suffix = targetWord.substring(word.length());
                    var numWaysForRest = count(suffix, words);
                    totalCount += numWaysForRest;
                }
            }

            return totalCount;
        }
    }

    private static class MemoCanConstruct implements ICountConstruct {

        @Override
        public int count(String targetWord, List<String> words) {
            return count(targetWord, words, new HashMap<>());
        }

        private int count(String targetWord, List<String> words, Map<String, Integer> map) {

            if (map.containsKey(targetWord)) return map.get(targetWord);

            if ("".equals(targetWord)) return 1;

            var totalCount = 0;

            for (String word : words) {
                if (targetWord.indexOf(word) == 0) {
                    var suffix = targetWord.substring(word.length());
                    var numWaysForRest = count(suffix, words, map);
                    totalCount += numWaysForRest;
                }
            }

            map.put(targetWord, totalCount);

            return totalCount;
        }
    }

    private static class TabCountConstruct implements ICountConstruct {

        @Override
        public int count(String targetWord, List<String> words) {
            int[] tab = new int[targetWord.length() + 1];
            Arrays.fill(tab, 0);
            tab[0] = 1;

            for (int i = 0; i <= targetWord.length(); i++) {
                if(tab[i] > 0) {
                    for (String word : words) {
                        if(targetWord.substring(i).indexOf(word) == 0) {
                            if(i+word.length() <= targetWord.length()) {
                                tab[i + word.length()] += tab[i];
                            }
                        }
                    }
                }
            }

            return tab[targetWord.length()];
        }
    }
}
