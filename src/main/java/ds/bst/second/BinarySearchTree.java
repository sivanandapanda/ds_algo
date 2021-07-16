package ds.bst.second;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public Node<T> getRoot() {
        return root;
    }

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
        if (root == null) {
            return;
        }

        remove(data, root);
    }

    private void remove(T data, Node<T> node) {
        if(node == null) return;

        if (data.compareTo(node.getData()) < 0) {
            remove(data, node.getLeftChild());
        } else if(data.compareTo(node.getData()) > 0) {
            remove(data, node.getRightChild());
        } else {
            if(node.getRightChild() == null && node.getLeftChild() == null) {
                var parentNode = node.getParentNode();

                if(parentNode != null && parentNode.getLeftChild() == node) {
                    parentNode.setLeftChild(null);
                } else if(parentNode != null && parentNode.getRightChild() == node) {
                    parentNode.setRightChild(null);
                }

                //may be we want to remove root node
                if(parentNode == null) {
                    root = null;
                }

                //remove the node and make it eligible for GC
                node = null;
            }

            //case 2) when we remove items with a single chile
            else if(node.getLeftChild() == null && node.getRightChild() != null) {
                var parentNode = node.getParentNode();

                if(parentNode != null && parentNode.getLeftChild() == node) {
                    parentNode.setLeftChild(node.getRightChild());
                } else if(parentNode != null && parentNode.getRightChild() == node) {
                    parentNode.setRightChild(node.getRightChild());
                }

                //may be we want to remove root node
                if(parentNode == null) {
                    root = node.getRightChild();
                }

                node.getRightChild().setParentNode(parentNode);
            }

            //case 3) when we remove items with a single chile
            else if(node.getLeftChild() != null && node.getRightChild() == null) {
                var parentNode = node.getParentNode();

                if(parentNode != null && parentNode.getLeftChild() == node) {
                    parentNode.setLeftChild(node.getLeftChild());
                } else if(parentNode != null && parentNode.getRightChild() == node) {
                    parentNode.setRightChild(node.getLeftChild());
                }

                //may be we want to remove root node
                if(parentNode == null) {
                    root = node.getLeftChild();
                }

                node.getLeftChild().setParentNode(parentNode);
            }

            //case 4) remove 2 children
            else {
                //find the oredecessor
                Node<T> predecessor = getPredecessor(node.getLeftChild());

                T temp = predecessor.getData();
                predecessor.setData(node.getData());
                node.setData(temp);

                remove(data, predecessor);
            }
        }
    }

    private Node<T> getPredecessor(Node<T> node) {
        if(node.getRightChild() != null) {
            return getPredecessor(node.getRightChild());
        }

        return node;
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

    private void preOrderTraversal(Node<T> node) {
        System.out.print(node + " - ");

        if(node.getLeftChild() != null) {
            preOrderTraversal(node.getLeftChild());
        }

        if(node.getRightChild() != null) {
            preOrderTraversal(node.getRightChild());
        }
    }

    private void postOrderTraversal(Node<T> node) {
        if(node.getLeftChild() != null) {
            postOrderTraversal(node.getLeftChild());
        }

        if(node.getRightChild() != null) {
            postOrderTraversal(node.getRightChild());
        }

        System.out.print(node + " - ");
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
