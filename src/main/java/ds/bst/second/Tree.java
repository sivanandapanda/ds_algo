package ds.bst.second;

public interface Tree<T> {

    void insert(T data);
    void remove(T data);

    //in-order traversal
    void traversal();

    T getMin();
    T getMax();
}
