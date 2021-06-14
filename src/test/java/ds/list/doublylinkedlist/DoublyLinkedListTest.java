package ds.list.doublylinkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DoublyLinkedListTest {

    @Test
    void test_with_strings() {
        DoublyLinkedList<String> names = new DoublyLinkedList<>();
        names.insert("Adam");
        names.insert("Daniel");
        names.insert("Anna");
        names.traverseForward();

        names.insert("Michael");
        names.traverseForward();
        names.traverseBackward();

        assertEquals(4, names.size());
    }
}