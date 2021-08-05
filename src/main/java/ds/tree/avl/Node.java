package ds.tree.avl;

public class Node<T> {

    private T data;
    private Node<T> leftChild;
    private Node<T> rightChild;

    //required when implementing remove or after rotation
    private Node<T> parentNode;

    private int height;

    public Node(T data, Node<T> parentNode) {
        this.data = data;
        this.parentNode = parentNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public Node<T> getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node<T> parentNode) {
        this.parentNode = parentNode;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}
