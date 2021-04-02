package dp.construct.can_construct;

import dp.model.DpCalcType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanConstruct {

    private final ICanConstruct canConstruct;

    public CanConstruct(DpCalcType dpCalcType) {
        switch (dpCalcType) {
            case MEMO:
                canConstruct = new MemoCanConstruct();
                break;
            case RECURSIVE:
            default:
                canConstruct = new RecursiveCanConstruct();
                break;
        }
    }

    public boolean find(String targetWord, List<String> words) {
        return canConstruct.find(targetWord, words);
    }

    private interface ICanConstruct {
        boolean find(String targetWord, List<String> words);
    }

    private static class RecursiveCanConstruct implements ICanConstruct {

        @Override
        public boolean find(String targetWord, List<String> words) {
            if("".equals(targetWord)) return true;

            for (String word : words) {
                if(targetWord.indexOf(word) == 0) {
                    var suffix = targetWord.substring(word.length());
                    if(find(suffix, words)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    private static class MemoCanConstruct implements ICanConstruct {

        @Override
        public boolean find(String targetWord, List<String> words) {
            return find(targetWord, words, new HashMap<>());
        }

        private boolean find(String targetWord, List<String> words, Map<String, Boolean> map) {

            if(map.containsKey(targetWord)) return map.get(targetWord);

            if("".equals(targetWord)) return true;

            for (String word : words) {
                if(targetWord.indexOf(word) == 0) {
                    var suffix = targetWord.substring(word.length());
                    if(find(suffix, words, map)) {
                        map.put(targetWord, true);
                        return true;
                    }
                }
            }

            map.put(targetWord, false);

            return false;
        }
    }
}
