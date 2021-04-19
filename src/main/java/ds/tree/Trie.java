package ds.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

    private final Map<String, List<String>> prefixMap;
    private final Map<String, List<String>> wordMap;

    public Trie() {
        this.wordMap = new HashMap<>();
        this.prefixMap = new HashMap<>();
    }

    public void insert(String word) {
        if (word == null) {
            return;
        }

        for (int i = 0; i < word.length() ; i++) {
            var subString = word.substring(0, i + 1);

            var wordList = prefixMap.getOrDefault(subString, new ArrayList<>());

            wordList.add(word);

            prefixMap.put(subString, wordList);
        }

        var wordList = prefixMap.getOrDefault(word, new ArrayList<>());
        wordList.add(word);
        wordMap.put(word, wordList);
    }

    public boolean search(String word) {
        if (word == null) {
            return false;
        }

        return wordMap.containsKey(word);
    }

    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }

        return prefixMap.containsKey(prefix);
    }

}
