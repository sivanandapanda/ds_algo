package ds.tree.avl;

import org.junit.jupiter.api.Test;

class AVLTreeTest {

    @Test
    void test_insert(){
        Tree<Integer> avl = new AVLTree<>();

        avl.insert(12);
        avl.insert(4);
        avl.insert(20);
        avl.insert(1);
        avl.insert(5);
        avl.insert(23);

        avl.traversal();

        avl.remove(23);
        avl.remove(20);

        avl.traversal();
    }

    @Test
    void test_insert2(){
        Tree<Integer> avl = new AVLTree<>();

        avl.insert(1);
        avl.insert(3);
        avl.insert(4);

        avl.traversal();
    }

    @Test
    void test_insert3(){
        Tree<Integer> avl = new AVLTree<>();

        avl.insert(3);
        avl.insert(2);
        avl.insert(1);

        avl.traversal();
    }

    @Test
    void test_insert4(){
        Tree<Integer> avl = new AVLTree<>();

        avl.insert(3);
        avl.insert(1);
        avl.insert(2);

        avl.traversal();
    }

    @Test
    void test_insert5(){
        Tree<Integer> avl = new AVLTree<>();

        avl.insert(3);
        avl.insert(5);
        avl.insert(4);

        avl.traversal();
    }
}