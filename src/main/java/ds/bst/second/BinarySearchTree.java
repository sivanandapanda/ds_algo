package ds.bst.second;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public void insert(T data) {
        if (root == null) {
            root = new Node<>(data, null);
        } else {
            insert(data, root);
        }
    }

    private void insert(T data, Node<T> node) {
        if (node.getData().compareTo(data) > 0) {
            if (node.getLeftChild() != null) {
                insert(data, node.getLeftChild());
            } else {
                node.setLeftChild(new Node<>(data, node));
            }
        } else {
            if (node.getRightChild() != null) {
                insert(data, node.getRightChild());
            } else {
                node.setRightChild(new Node<>(data, node));
            }
        }
    }

    @Override
    public void remove(T data) {

    }

    @Override
    public void traversal() {
        //in-order traversal in O(N) linear time

        if (root == null) {
            return;
        }

        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(Node<T> node) {
        if(node.getLeftChild() != null) {
            inOrderTraversal(node.getLeftChild());
        }

        System.out.print(node + " - ");

        if(node.getRightChild() != null) {
            inOrderTraversal(node.getRightChild());
        }
    }

    @Override
    public T getMin() {
        if (root == null) {
            return null;
        }

        //min item left most item of the tree
        return getMin(root);
    }

    @Override
    public T getMax() {
        if (root == null) {
            return null;
        }

        //max item right most item of the tree
        return getMax(root);

    }

    private T getMin(Node<T> node) {
        if (node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
        }

        return node.getData();
    }

    private T getMax(Node<T> node) {
        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }

        return node.getData();
    }
}
