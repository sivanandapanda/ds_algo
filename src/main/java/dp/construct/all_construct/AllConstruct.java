package dp.construct.all_construct;

import dp.model.DpCalcType;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class AllConstruct {

    private final IAllConstruct allConstruct;

    public AllConstruct(DpCalcType dpCalcType) {
        switch (dpCalcType) {
            case MEMO:
                allConstruct = new MemoAllConstruct();
                break;
            case TABULATION:
                allConstruct = new TabAllConstruct();
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
                var lists = new ArrayList<List<String>>();
                lists.add(new ArrayList<>());
                return lists;
            }

            var result = new ArrayList<List<String>>();

            for (String word : words) {
                if (targetWord.indexOf(word) == 0) {
                    var suffix = targetWord.substring(word.length());
                    result.addAll(find(suffix, words).stream().peek(l -> l.add(0, word)).collect(toList()));
                }
            }

            return result;
        }
    }

    private static class MemoAllConstruct implements IAllConstruct {

        @Override
        public List<List<String>> find(String targetWord, List<String> words) {
            var map = new HashMap<String, List<List<String>>>();
            var result = find(targetWord, words, map);
            System.out.println(map);
            return result;
        }

        private List<List<String>> find(String targetWord, List<String> words, Map<String, List<List<String>>> map) {
            if (map.containsKey(targetWord)) return map.get(targetWord);

            if ("".equals(targetWord)) {
                var lists = new ArrayList<List<String>>();
                lists.add(new ArrayList<>());
                return lists;
            }

            var result = new ArrayList<List<String>>();

            for (String word : words) {
                if (targetWord.indexOf(word) == 0) {
                    var suffix = targetWord.substring(word.length());
                    result.addAll(find(suffix, words, map)
                            .stream()
                            .map(l -> {
                                var newList = new ArrayList<>(l);
                                newList.add(0, word);
                                return newList;
                            })
                            .collect(toList()));
                }
            }

            map.put(targetWord, new ArrayList<>(result));
            return result;
        }
    }

    private static class TabAllConstruct implements IAllConstruct {

        @Override
        public List<List<String>> find(String targetWord, List<String> words) {
            List<List<String>>[] tab = new List[targetWord.length() + 1];
            Arrays.fill(tab, new ArrayList<List<String>>());
            var list0 = new ArrayList<List<String>>();
            list0.add(new ArrayList<>());
            tab[0] = list0;

            for (int i = 0; i <= targetWord.length(); i++) {
                if(tab[i] != null) {
                    for (String word : words) {
                        if(targetWord.substring(i).indexOf(word) == 0) {
                            if(i+word.length() <= targetWord.length()) {
                                var existingList = new ArrayList<>(tab[i + word.length()]);

                                var newList = new ArrayList<>(tab[i]).stream().peek(l -> l.add(word)).collect(toList());

                                var list = new ArrayList<>(newList);
                                list.addAll(existingList);

                                tab[i + word.length()] = list;
                            }
                        }
                    }
                }
            }

            return tab[targetWord.length()];
        }
    }
}
