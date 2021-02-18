package ds.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    @Test
    public void test_add() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        binaryTree.add(3);
        binaryTree.add(10);
        binaryTree.add(13);
        binaryTree.add(7);
        binaryTree.add(5);
        binaryTree.add(1);

        System.out.println(binaryTree.toString());
    }

    @Test
    public void test_size() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        binaryTree.add(3);
        binaryTree.add(10);
        binaryTree.add(13);
        binaryTree.add(7);
        binaryTree.add(5);
        binaryTree.add(1);

        assertEquals(6, binaryTree.size());
    }

    @Test
    public void test_find() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        binaryTree.add(3);
        binaryTree.add(10);
        binaryTree.add(13);
        binaryTree.add(7);
        binaryTree.add(5);
        binaryTree.add(1);

        assertTrue(binaryTree.find(3));
        assertTrue(binaryTree.find(10));
        assertTrue(binaryTree.find(13));
        assertTrue(binaryTree.find(7));
        assertTrue(binaryTree.find(5));
        assertTrue(binaryTree.find(1));
        assertFalse(binaryTree.find(4));
        assertFalse(binaryTree.find(14));
    }

    @Test
    public void test_height() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        binaryTree.add(3);
        binaryTree.add(10);
        binaryTree.add(13);
        binaryTree.add(7);
        binaryTree.add(5);
        binaryTree.add(1);

        assertEquals(4, binaryTree.height());
    }

    @Test
    public void test_rebalance() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        binaryTree.add(3);
        binaryTree.add(10);
        binaryTree.add(13);
        binaryTree.add(7);
        binaryTree.add(5);
        binaryTree.add(1);


        assertEquals(4, binaryTree.height());
        assertEquals("1-3-5-7-10-13", binaryTree.toString());

        BinaryTree<Integer> newTree = binaryTree.buildRebalancedTree();
        assertEquals(3, newTree.height());
        assertEquals("1-3-5-7-10-13", newTree.toString());
    }

    @Test
    public void remove_test_no_child() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        binaryTree.add(3);
        binaryTree.add(10);
        binaryTree.add(13);

        System.out.println(binaryTree.toString());
        System.out.println(binaryTree.remove(13));
        System.out.println(binaryTree.toString());
    }

    @Test
    public void remove_test_1_child() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        binaryTree.add(3);
        binaryTree.add(10);
        binaryTree.add(13);

        System.out.println(binaryTree.toString());
        System.out.println(binaryTree.remove(10));
        System.out.println(binaryTree.toString());
    }

    @Test
    public void remove_test_root_node_1_child() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        binaryTree.add(3);
        binaryTree.add(10);
        binaryTree.add(13);

        System.out.println(binaryTree.toString());
        System.out.println(binaryTree.remove(3));
        System.out.println(binaryTree.toString());
    }

    @Test
    public void remove_test_root_node_no_child() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        binaryTree.add(3);

        System.out.println(binaryTree.toString());
        System.out.println(binaryTree.remove(3));
        System.out.println(binaryTree.toString());
    }

    @Test
    public void remove_test_root_node_2_child() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        binaryTree.add(10);
        binaryTree.add(3);
        binaryTree.add(13);

        System.out.println(binaryTree.toString());
        System.out.println(binaryTree.remove(10));
        System.out.println(binaryTree.toString());
    }

    @Test
    public void remove_test_root_node_2_child_case_2() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        binaryTree.add(10);
        binaryTree.add(3);
        binaryTree.add(13);

        System.out.println(binaryTree.toString());
        System.out.println(binaryTree.remove(10));
        System.out.println(binaryTree.toString());
    }
}