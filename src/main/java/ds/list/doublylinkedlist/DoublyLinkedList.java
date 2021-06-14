package ds.list.doublylinkedlist;

public class DoublyLinkedList<T extends Comparable<T>> {

    private Node<T> head;
    private Node<T> tail;
    private int numOfItems;

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);

        if(tail == null) {
            tail = newNode;
            head = newNode;
        } else {
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = newNode;
        }

        numOfItems++;
    }

    public void remove(T data) {

    }

    public void traverseForward() {
        if (head == null) return;

        Node<T> actualNode = head;

        while (actualNode != null) {
            System.out.print(actualNode);
            actualNode = actualNode.getNext();
        }
        System.out.println();
    }

    public void traverseBackward() {
        if (tail == null) return;

        Node<T> actualNode = tail;

        while (actualNode != null) {
            System.out.print(actualNode);
            actualNode = actualNode.getPrevious();
        }
        System.out.println();
    }

    public int size() {
        return numOfItems;
    }
}
