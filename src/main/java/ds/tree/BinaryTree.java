package ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Features
 * 1. Add
 * 2. Remove
 * 3. Traverse - Depth-First traversal (in-order, pre-order, post-order), Breadth-First traversal
 * 4. Get size
 * 5. Get/Find
 * 6. Get height
 * 7. Re-balance
 */
public class BinaryTree<T extends Comparable<T>> {

    private Node<T> root = null;
    private final AtomicInteger size = new AtomicInteger(0);

    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (nonNull(root)) {
            //Iterable<Node<T>> nodes = preOrderTraversal(root, builder);
            //Iterable<Node<T>> nodes = inOrderTraversal(root, builder);
            //Iterable<Node<T>> nodes = postOrderTraversal(root, builder);
            Iterable<Node<T>> nodes = iterateInOrder();

            for (Node<T> node : nodes) {
                builder.append(node.data).append("-");
            }
        }

        return (builder.length() > 0) ? builder.deleteCharAt(builder.length() - 1).toString() : "";
    }

    public Iterable<Node<T>> iteratePreOrder() {
        List<Node<T>> list = new ArrayList<>();
        preOrderTraversal(root, list);
        return list;
    }

    public Iterable<Node<T>> iteratePostOrder() {
        List<Node<T>> list = new ArrayList<>();
        postOrderTraversal(root, list);
        return list;
    }

    public Iterable<Node<T>> iterateInOrder() {
        List<Node<T>> list = new ArrayList<>();
        inOrderTraversal(root, list);
        return list;
    }

    private void preOrderTraversal(Node<T> node, List<Node<T>> list) {
        if (nonNull(node)) {
            list.add(node);
            preOrderTraversal(node.leftNode, list);
            preOrderTraversal(node.rightNode, list);
        }
    }

    private void inOrderTraversal(Node<T> node, List<Node<T>> list) {
        if (nonNull(node)) {
            inOrderTraversal(node.leftNode, list);
            list.add(node);
            inOrderTraversal(node.rightNode, list);
        }
    }

    private void postOrderTraversal(Node<T> node, List<Node<T>> list) {
        if (nonNull(node)) {
            postOrderTraversal(node.leftNode, list);
            postOrderTraversal(node.rightNode, list);
            list.add(node);
        }
    }

    public Iterable<Node<T>> iterateBreadthFirst() {
        List<Node<T>> list = new LinkedList<>();
        if (nonNull(root)) {
            List<Node<T>> currentNodes = new LinkedList<>();
            currentNodes.add(root);
            while (!currentNodes.isEmpty()) {
                List<Node<T>> nextNodes = new LinkedList<>();
                for (Node<T> currentNode : currentNodes) {
                    if (nonNull(currentNode)) {
                        list.add(currentNode);
                        nextNodes.add(currentNode.leftNode);
                        nextNodes.add(currentNode.rightNode);
                    }
                }
                currentNodes = nextNodes;
            }
        }

        return list;
    }

    public void add(T item) {
        if (isNull(root)) {
            root = new Node<>(item);
        } else {
            add(root, item);
        }

        size.incrementAndGet();
    }

    private void add(Node<T> node, T item) {
        int compareTo = item.compareTo(node.data);

        if (compareTo > 0) {
            if (isNull(node.rightNode)) {
                node.rightNode = new Node<>(item);
            } else {
                add(node.rightNode, item);
            }
        } else {
            if (isNull(node.leftNode)) {
                node.leftNode = new Node<>(item);
            } else {
                add(node.leftNode, item);
            }
        }
    }

    public int size() {
        return size.get();
    }

    public boolean find(T item) {
        return find(root, item);
    }

    private boolean find(Node<T> node, T item) {
        if (isNull(node)) {
            return false;
        }

        int compareTo = item.compareTo(node.data);

        if (compareTo == 0) {
            return true;
        } else if (compareTo > 0) {
            return find(node.rightNode, item);
        } else {
            return find(node.leftNode, item);
        }
    }

    public int height() {
        return height(root);
    }

    private int height(Node<T> node) {
        if (isNull(node)) {
            return 0;
        }

        return Math.max(height(node.leftNode), height(node.rightNode)) + 1;
    }

    public BinaryTree<T> buildRebalancedTree() {
        List<Node<T>> nodes = (List<Node<T>>) iterateInOrder();

        int size = nodes.size() - 1;

        Node<T> root = buildTreeUntil(nodes, 0 , size);
        BinaryTree<T> binaryTree = new BinaryTree<>();
        binaryTree.root = root;
        return binaryTree;
    }

    private Node<T> buildTreeUntil(List<Node<T>> nodes, int start, int end) {
        if(start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node<T> node = nodes.get(mid);

        node.leftNode = buildTreeUntil(nodes, start, mid-1);
        node.rightNode = buildTreeUntil(nodes, mid+1, end);

        return node;
    }

    public boolean remove(T item) {
        Node<T> currentNode = root;
        Node<T> parentNode = null;

        Node<T> found = null;

        while (nonNull(currentNode)) {
            int compareTo = item.compareTo(currentNode.data);

            if (compareTo < 0) {
                parentNode = currentNode;
                currentNode = currentNode.leftNode;
            } else if (compareTo > 0) {
                parentNode = currentNode;
                currentNode = currentNode.rightNode;
            } else {
                found = currentNode;

                if(isNull(currentNode.leftNode) && isNull(currentNode.rightNode)) { // case 1 = no children
                    if(nonNull(parentNode)) {
                        if(nonNull(parentNode.leftNode) && parentNode.leftNode.equals(currentNode)) {
                            parentNode.leftNode = null;
                        } else if (nonNull(parentNode.rightNode) && parentNode.rightNode.equals(currentNode)) {
                            parentNode.rightNode = null;
                        }
                    } else {
                        root = null;
                    }
                } else if (nonNull(currentNode.leftNode) && nonNull(currentNode.rightNode)) { // case 2 = both children

                    List<Node<T>> list = new ArrayList<>();
                    inOrderTraversal(currentNode, list);

                    for (int i = 0; i < list.size(); i++) {
                        if(list.get(i).equals(currentNode)) {
                            if(nonNull(parentNode)) {
                                if (nonNull(parentNode.leftNode) && parentNode.leftNode.equals(currentNode)) {
                                    parentNode.leftNode = list.get(i+1);
                                } else if (nonNull(parentNode.rightNode) && parentNode.rightNode.equals(currentNode)) {
                                    parentNode.rightNode = list.get(i+1);
                                }
                            } else {
                                root = list.get(i+1);
                            }
                            list.get(i+1).leftNode = currentNode.leftNode;
                            //list.get(i+1).rightNode = currentNode.rightNode;
                            break;
                        }
                    }

                } else { // case 3 = 1 children
                    Node<T> childNode = nonNull(currentNode.leftNode) ? currentNode.leftNode : currentNode.rightNode;
                    if(nonNull(parentNode)) {
                        if (nonNull(parentNode.leftNode) && parentNode.leftNode.equals(currentNode)) {
                            parentNode.leftNode = childNode;
                        } else if (nonNull(parentNode.rightNode) && parentNode.rightNode.equals(currentNode)) {
                            parentNode.rightNode = childNode;
                        }
                    } else {
                        root = childNode;
                    }
                }

                break;
            }
        }

        return nonNull(found);
    }

    private static class Node<T extends Comparable<T>> {
        private final T data;
        private Node<T> leftNode;
        private Node<T> rightNode;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(data, node.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }
    }
}
