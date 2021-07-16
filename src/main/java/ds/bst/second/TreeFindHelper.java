package ds.bst.second;

public class TreeFindHelper<T extends Comparable<T>> {

    public T kthSmallest_inefficient(Tree<T> tree, int k) {
        if(k < 1) return null;

        var min = tree.getMin();
        tree.remove(min);
        while(k > 1) {
            min = tree.getMin();
            tree.remove(min);

            k--;
        }

        return min;
    }

    public T kthSmallest(Tree<T> tree, int k) {
        return kthSmallest(tree.getRoot(), k);
    }

    private T kthSmallest(Node<T> node, int k) {
        if(k < 1) return null;

        var leftTreeSize = findTreeSize(node.getLeftChild());

        if(k <= leftTreeSize) {
            return kthSmallest(node.getLeftChild(), k);
        } else if(k == leftTreeSize+1) {
            return node.getData();
        } else {
            return kthSmallest(node.getRightChild(), k - leftTreeSize - 1);
        }
    }

    private int findTreeSize(Node<T> node) {
        if(node == null) return 0;

        return findTreeSize(node.getLeftChild()) + findTreeSize(node.getRightChild()) + 1;
    }
}
