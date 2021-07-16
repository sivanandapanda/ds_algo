package ds.bst.second;

import ds.list.Person;
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

        bst.remove(9);
        bst.traversal();

        bst.remove(17);
        bst.traversal();

        bst.remove(5);
        bst.traversal();

        bst.remove(10);
        bst.traversal();

        bst.remove(2);
        bst.traversal();

        bst.remove(1);
        bst.traversal();

        bst.remove(12);
        bst.traversal();
    }

    @Test
    void compareTrees() {
        Tree<Integer> tree1 = new BinarySearchTree<>();
        tree1.insert(10);
        tree1.insert(5);
        tree1.insert(2);
        tree1.insert(1);
        tree1.insert(12);
        tree1.insert(9);
        tree1.insert(17);

        Tree<Integer> tree2 = new BinarySearchTree<>();
        tree2.insert(10);
        tree2.insert(2);
        tree2.insert(5);
        tree2.insert(9);
        tree2.insert(1);
        tree2.insert(12);
        tree2.insert(17);

        assertFalse(new TreeCompareHelper<Integer>().compareTrees(tree1.getRoot(), tree2.getRoot()));
    }

    @Test
    void compareTrees2() {
        Tree<Integer> tree1 = new BinarySearchTree<>();
        tree1.insert(10);
        tree1.insert(5);
        tree1.insert(2);
        tree1.insert(1);
        tree1.insert(12);
        tree1.insert(9);
        tree1.insert(17);

        Tree<Integer> tree2 = new BinarySearchTree<>();
        tree2.insert(10);
        tree2.insert(5);
        tree2.insert(2);
        tree2.insert(9);
        tree2.insert(1);
        tree2.insert(12);
        tree2.insert(17);

        assertTrue(new TreeCompareHelper<Integer>().compareTrees(tree1.getRoot(), tree2.getRoot()));
    }

    @Test
    void compareTrees3() {
        Tree<Integer> tree1 = new BinarySearchTree<>();
        tree1.insert(10);
        tree1.insert(5);
        tree1.insert(2);
        tree1.insert(1);
        tree1.insert(12);
        tree1.insert(19);
        tree1.insert(17);

        Tree<Integer> tree2 = new BinarySearchTree<>();
        tree2.insert(10);
        tree2.insert(5);
        tree2.insert(2);
        tree2.insert(9);
        tree2.insert(1);
        tree2.insert(12);
        tree2.insert(17);

        assertFalse(new TreeCompareHelper<Integer>().compareTrees(tree1.getRoot(), tree2.getRoot()));
    }

    @Test
    void compareTrees4() {
        Tree<Integer> tree1 = new BinarySearchTree<>();
        tree1.insert(10);

        Tree<Integer> tree2 = new BinarySearchTree<>();
        tree2.insert(10);

        assertTrue(new TreeCompareHelper<Integer>().compareTrees(tree1.getRoot(), tree2.getRoot()));
    }

    @Test
    void compareTrees5() {
        assertTrue(new TreeCompareHelper<Integer>().compareTrees(null, null));
    }

    @Test
    void findKthSmallest_inefficient() {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.insert(10);
        tree.insert(5);
        tree.insert(2);
        tree.insert(1);
        tree.insert(12);
        tree.insert(19);
        tree.insert(17);

        assertEquals(5, new TreeFindHelper<Integer>().kthSmallest_inefficient(tree, 3));
    }

    @Test
    void findKthSmallest1() {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.insert(10);
        tree.insert(5);
        tree.insert(2);
        tree.insert(1);
        tree.insert(12);
        tree.insert(19);
        tree.insert(17);

        assertEquals(5, new TreeFindHelper<Integer>().kthSmallest(tree, 3));
    }

    @Test
    void findKthSmallest2() {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.insert(10);
        tree.insert(5);
        tree.insert(2);
        tree.insert(1);
        tree.insert(12);
        tree.insert(19);
        tree.insert(17);

        assertEquals(17, new TreeFindHelper<Integer>().kthSmallest(tree, 6));
    }

    @Test
    void findKthSmallest3() {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.insert(10);
        tree.insert(5);
        tree.insert(2);
        tree.insert(1);
        tree.insert(12);
        tree.insert(19);
        tree.insert(17);

        assertEquals(19, new TreeFindHelper<Integer>().kthSmallest(tree, 7));
    }

    @Test
    void findKthSmallest4() {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.insert(10);
        tree.insert(5);
        tree.insert(2);
        tree.insert(1);
        tree.insert(12);
        tree.insert(19);
        tree.insert(17);

        assertNull(new TreeFindHelper<Integer>().kthSmallest(tree, 8));
    }

    @Test
    void findFamilyAge() {
        Tree<Person> tree = new BinarySearchTree<>();
        tree.insert(new Person(47, "Adam"));
        tree.insert(new Person(21, "Kevin"));
        tree.insert(new Person(55, "Joe"));
        tree.insert(new Person(20, "Arnold"));
        tree.insert(new Person(34, "Noel"));
        tree.insert(new Person(23, "Susan"));
        tree.insert(new Person(38, "Rose"));
        tree.insert(new Person(68, "Marco"));

        assertEquals(306, new FamilyAgeProblem(tree).findTotalAge());

    }
}