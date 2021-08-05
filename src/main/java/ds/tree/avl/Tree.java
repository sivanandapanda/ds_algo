package ds.tree.avl;

public interface Tree<T> {

    void insert(T data);
    void remove(T data);

    //in-order traversal
    void traversal();
}
