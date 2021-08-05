package ds.tree.bst.first;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    @Test
    void test_insert_and_traverse_inorder() {
        Tree intTree = createIntTree();

        intTree.traverseInOrder();
        System.out.println();
    }

    @Test
    void test_insert_and_find() {
        Tree intTree = createIntTree();

        System.out.println(intTree.get(26));
        System.out.println(intTree.get(32));
        System.out.println(intTree.get(23));
        assertNotNull(intTree.get(26));
        assertNotNull(intTree.get(32));
        assertNull(intTree.get(23));
    }

    @Test
    void test_insert_and_delete_root() {
        Tree intTree = createIntTree();
        intTree.traverseInOrder();
        System.out.println();

        intTree.delete(25);

        intTree.traverseInOrder();
        System.out.println();
    }

    @Test
    void test_insert_and_delete_1() {
        Tree intTree = createIntTree();
        intTree.insert(17);
        intTree.traverseInOrder();
        System.out.println();

        intTree.delete(17);

        intTree.traverseInOrder();
        System.out.println();
    }

    @Test
    void test_insert_and_delete_2() {
        Tree intTree = createIntTree();
        intTree.insert(17);
        intTree.traverseInOrder();
        System.out.println();

        intTree.delete(15);

        intTree.traverseInOrder();
        System.out.println();
    }

    @Test
    void test_insert_and_delete_3() {
        Tree intTree = createIntTree();
        intTree.traverseInOrder();
        System.out.println();

        intTree.delete(888);

        intTree.traverseInOrder();
        System.out.println();
    }

    @Test
    void test_insert_and_find_min() {
        Tree intTree = createIntTree();

        System.out.println(intTree.min());
        assertEquals(15, intTree.min());
    }

    @Test
    void test_insert_and_find_max() {
        Tree intTree = createIntTree();

        System.out.println(intTree.max());
        assertEquals(32, intTree.max());
    }

    @Test
    void test_insert_and_traverse_preorder() {
        Tree intTree = createIntTree();

        intTree.traversePreOrder();
        System.out.println();
    }

    @Test
    void test_insert_and_traverse_postorder() {
        Tree intTree = createIntTree();

        intTree.traversePostOrder();
        System.out.println();
    }

    private Tree createIntTree() {
        Tree intTree = new Tree();
        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);
        return intTree;
    }

}