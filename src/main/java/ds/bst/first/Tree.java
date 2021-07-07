package ds.bst.first;

public class Tree {

    private TreeNode root;

    public void insert(int value) {
        if(root == null) {
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }

    public TreeNode get(int value) {
        if(root != null) {
            return root.get(value);
        }

        return null;
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private TreeNode delete(TreeNode subTreeRoot, int value) {
        if (subTreeRoot == null) {
            return subTreeRoot;
        }

        if(value < subTreeRoot.getData()) {
            subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(), value));
        } else if(value > subTreeRoot.getData()) {
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), value));
        } else {
            if(subTreeRoot.getLeftChild() == null) {
                return subTreeRoot.getRightChild(); //cases 1 & 2: works for cases when no child or one chile
            } else if(subTreeRoot.getRightChild() == null) {
                return subTreeRoot.getLeftChild(); //cases 1 & 2: works for cases when no child or one chile
            } else { //case 3, both children are present

                //replace the value in the subtreeRoot node with the smallest value from the right subtree
                subTreeRoot.setData(subTreeRoot.getRightChild().min());

                //delete the node that has the smallest value in the right subtree
                subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), subTreeRoot.getData()));
            }
        }

        return subTreeRoot;
    }

    public int min() {
        if(root != null) {
            return root.min();
        }

        return Integer.MIN_VALUE;
    }

    public int max() {
        if(root != null) {
            return root.max();
        }

        return Integer.MAX_VALUE;
    }

    public void traverseInOrder() {
        if(root != null) {
            root.traverseInOrder();
        }
    }

    public void traversePreOrder() {
        if(root != null) {
            root.traversePreOrder();
        }
    }

    public void traversePostOrder() {
        if(root != null) {
            root.traversePostOrder();
        }
    }
}
