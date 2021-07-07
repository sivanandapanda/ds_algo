package ds.bst.second;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    void test_insert(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(10);
        bst.insert(5);
        bst.insert(2);
        bst.insert(1);
        bst.insert(12);
        bst.insert(9);
        bst.insert(17);

        bst.traversal();

        assertEquals(1, bst.getMin());
        assertEquals(17, bst.getMax());
    }

}