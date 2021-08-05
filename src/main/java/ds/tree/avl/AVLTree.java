package ds.tree.avl;

public class AVLTree<T extends Comparable<T>> implements Tree<T> {

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

        updateHeight(node);
        // settle the violations
        settleViolations(node);
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

                updateHeight(parentNode);
                settleViolations(parentNode);
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
                updateHeight(parentNode);
                settleViolations(parentNode);
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
                updateHeight(parentNode);
                settleViolations(parentNode);
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

        // settle the violations
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

    //O(logN)
    private void settleViolations(Node<T> node) {

        //we have to check upto root
        while (node != null) {
            updateHeight(node);
            settleViolationsHelper(node);
            node = node.getParentNode();
        }

    }

    private void settleViolationsHelper(Node<T> node) {
        int balance = getBalance(node);

        if(balance > 1) { //left heavy situation

            //left right heavy situation: left rotation
            if(getBalance(node.getLeftChild()) < 0) {
                leftRotation(node.getLeftChild());
            }

            // left left heavy situation
            rightRotation(node);
        }

        if(balance < -1) { //left heavy situation

            //right left heavy situation: left rotation
            if(getBalance(node.getRightChild()) > 0) {
                rightRotation(node.getRightChild());
            }

            // right right heavy situation
            leftRotation(node);
        }
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

    //it can be done O(1)
    private void rightRotation(Node<T> node) {
        System.out.println("Rotating right on node = " + node);
        var tempLeftChild = node.getLeftChild();
        var grandChild = tempLeftChild.getRightChild();

        //make the rotation - the new root node will be the tempLeftChild
        tempLeftChild.setRightChild(node);
        node.setLeftChild(grandChild);

        if(grandChild != null) {
            grandChild.setParentNode(node);
        }

        //handle parent of the node
        var tempParent = node.getParentNode();
        node.setParentNode(tempLeftChild);
        tempLeftChild.setParentNode(tempParent);

        //handle parent
        if(tempLeftChild.getParentNode() != null && tempLeftChild.getParentNode().getLeftChild() == node) {
            tempLeftChild.getParentNode().setLeftChild(tempLeftChild);
        }

        if(tempLeftChild.getParentNode() != null && tempLeftChild.getParentNode().getRightChild() == node) {
            tempLeftChild.getParentNode().setRightChild(tempLeftChild);
        }

        if(node == root) {
            root = tempLeftChild;
        }

        updateHeight(node);
        updateHeight(tempLeftChild);
    }

    //it can be done O(1)
    private void leftRotation(Node<T> node) {
        System.out.println("Rotating left on node = " + node);
        var tempRightChild = node.getRightChild();
        var grandChild = tempRightChild.getLeftChild();

        //make the rotation - the new root node will be the tempRightChild
        tempRightChild.setLeftChild(node);
        node.setRightChild(grandChild);

        if(grandChild != null) {
            grandChild.setParentNode(node);
        }

        //handle parent of the node
        var tempParent = node.getParentNode();
        node.setParentNode(tempRightChild);
        tempRightChild.setParentNode(tempParent);

        //handle parent
        if(tempRightChild.getParentNode() != null && tempRightChild.getParentNode().getLeftChild() == node) {
            tempRightChild.getParentNode().setLeftChild(tempRightChild);
        }

        if(tempRightChild.getParentNode() != null && tempRightChild.getParentNode().getRightChild() == node) {
            tempRightChild.getParentNode().setRightChild(tempRightChild);
        }

        if(node == root) {
            root = tempRightChild;
        }

        updateHeight(node);
        updateHeight(tempRightChild);
    }

    private void updateHeight(Node<T> node) {
        node.setHeight((Math.max(height(node.getLeftChild()), height(node.getRightChild()))) + 1);
    }

    private int height(Node<T> node) {
        if(node == null) return -1;

        return node.getHeight();
    }

    private int getBalance(Node<T> node) {
        if(node == null) return 0;

        return height(node.getLeftChild()) - height(node.getRightChild());
    }
}
