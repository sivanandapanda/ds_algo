package ds.list;

public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> root;
    private int numOfItems;

    @Override
    public void insert(T data) {
        if (root == null) {
            root = new Node<>(data);
        } else {
            insertBeginning(data);
        }
        numOfItems++;
    }

    private void insertBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(root);
        root = newNode;
    }

    private void insertEnd(T data, Node<T> node) {
        if (node.getNext() != null) {
            insertEnd(data, node.getNext());
        } else {
            Node<T> newNode = new Node<>(data);
            newNode.setNext(root);
        }
    }

    @Override
    public void traverse() {
        if (root == null) return;

        Node<T> actualNode = root;

        while (actualNode != null) {
            System.out.print(actualNode);
            actualNode = actualNode.getNext();
        }
        System.out.println();
    }

    @Override
    public void remove(T data) {
        if (root == null) return;

        if (root.getData().compareTo(data) == 0) {
            root = root.getNext();
        } else {
            remove(data, root, root.getNext());
        }
    }

    private void remove(T data, Node<T> previousNode, Node<T> actualNode) {
        while (actualNode != null) {
            if (actualNode.getData().compareTo(data) == 0) {
                numOfItems--;
                previousNode.setNext(actualNode.getNext());
                //actualNode = null;
                return;
            }

            previousNode = actualNode;
            actualNode = actualNode.getNext();
        }
    }

    @Override
    public int size() {
        return numOfItems;
    }
}
