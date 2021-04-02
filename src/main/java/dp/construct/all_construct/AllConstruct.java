package dp.construct.all_construct;

import dp.construct.count_construct.CountConstruct;
import dp.model.DpCalcType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllConstruct {

    private final IAllConstruct allConstruct;

    public AllConstruct(DpCalcType dpCalcType) {
        switch (dpCalcType) {
            case MEMO:
                allConstruct = new MemoAllConstruct();
                break;
            case RECURSIVE:
            default:
                allConstruct = new RecursiveAllConstruct();
                break;
        }
    }

    public List<List<String>> find(String targetWord, List<String> words) {
        return allConstruct.find(targetWord, words);
    }

    private interface IAllConstruct {
        List<List<String>> find(String targetWord, List<String> words);
    }

    private static class RecursiveAllConstruct implements IAllConstruct {

        @Override
        public List<List<String>> find(String targetWord, List<String> words) {
            if ("".equals(targetWord)) {
                return new ArrayList<>();
            }

            return null;
        }
    }

    private static class MemoAllConstruct implements IAllConstruct {

        @Override
        public List<List<String>> find(String targetWord, List<String> words) {
            return null;
        }
    }

}
