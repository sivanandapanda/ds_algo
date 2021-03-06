package ds.tree.trie;

import ds.tree.trie.Trie;
import ds.tree.trie.TrieOptimal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TrieTest {

    @Test
    void test() {
        Trie trie = new Trie();

        assertFalse(trie.search("apple"));

        trie.insert("apple");

        assertTrue(trie.search("apple"));

        assertFalse(trie.search("app"));
        assertTrue(trie.startsWith("app"));
        trie.insert("app");
        assertTrue(trie.search("app"));

    }

    @Test
    void test_with_optimal() {
        TrieOptimal trie = new TrieOptimal();

        assertFalse(trie.search("apple"));

        trie.insert("apple");

        assertTrue(trie.search("apple"));

        assertFalse(trie.search("app"));
        assertTrue(trie.startsWith("app"));
        trie.insert("app");
        assertTrue(trie.search("app"));

    }
}