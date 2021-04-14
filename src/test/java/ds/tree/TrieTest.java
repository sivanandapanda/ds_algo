package ds.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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