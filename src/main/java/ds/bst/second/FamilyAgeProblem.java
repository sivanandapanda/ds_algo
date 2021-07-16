package ds.bst.second;

import ds.list.Person;

public class FamilyAgeProblem {

    private final Tree<Person> familyTree;

    public FamilyAgeProblem(Tree<Person> familyTree) {
        this.familyTree = familyTree;
    }

    public int findTotalAge() {
        return findTotalAge(familyTree.getRoot());
    }

    private int findTotalAge(Node<Person> node) {
        if(node == null) return 0;

        int leftAgeSum = findTotalAge(node.getLeftChild());
        int rightAgeSum = findTotalAge(node.getRightChild());

        return leftAgeSum + rightAgeSum + node.getData().getAge();
    }
}
