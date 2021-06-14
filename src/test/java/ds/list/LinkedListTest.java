package ds.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void test_with_strings() {
        List<String> names = new LinkedList<>();
        names.insert("Adam");
        names.insert("Daniel");
        names.insert("Anna");
        names.traverse();

        names.remove("Daniel");
        names.traverse();

        names.insert("Michael");
        names.traverse();

        assertEquals(3, names.size());
    }

    @Test
    void test_with_persons() {
        List<Person> names = new LinkedList<>();
        names.insert(new Person(19, "Adam"));
        names.insert(new Person(32, "Daniel"));
        names.insert(new Person(25, "Anna"));
        names.traverse();

        names.remove(new Person(32, "Daniel"));
        names.traverse();

        names.insert(new Person(25, "Michael"));
        names.traverse();

        assertEquals(3, names.size());
    }

}